/*****************************************************************************************************************************
NOTICE
This (software/technical data) was produced for the U. S. Government under Contract Number 75FCMC18D0047, and is subject to 
Federal Acquisition Regulation Clause 52.227-14, Rights in Data-General. No other use other than that granted to the U. S. 
Government, or to those acting on behalf of the U. S. Government under that Clause is authorized without the express written 
permission of The MITRE Corporation.For further information, please contact The MITRE Corporation, Contracts Management Office, 
7515 Colshire Drive, McLean, VA 22102-7539, (703) 983-6000.
© 2021 The MITRE Corporation.
******************************************************************************************************************************/

package org.mitre.mockdataresource.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.math.DoubleRange;
import org.json.JSONObject;
import org.mitre.mockdataresource.common.Constants;
import org.mitre.mockdataresource.model.ProjectSummary;
import org.mitre.mockdataresource.model.Summary;
import org.mitre.mockdataresource.model.SummaryElement;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    public static final String FILE_DIR = "src/main/resources/data/";

    public static final String DATA_FILE_NAME = "stjude.json";

    static final String ATTR_ST_JUDE_DATASETS = "sj_datasets";

    // Attributes mapped to PODS Core elements
    static final String ATTR_AGE_AT_DIAGNOSIS = "attr_age_at_diagnosis";
    static final String ATTR_SUBJECT_NAME = "subject_name";
    static final String ATTR_SAMPLE_NAME = "sample_name";
    static final String ATTR_SEQUENCING_TYPE = "sequencing_type";
    static final String ATTR_DIAGNOSIS = "attr_diagnosis";
    static final String ATTR_ETHNICITY = "attr_ethnicity";
    static final String ATTR_RACE = "attr_race";
    static final String ATTR_SEX = "attr_sex";
    static final String ATTR_PUBLICATION = "attr_publication";

    // Attributes mapped to Other elements
    static final String ATTR_SAMPLE_TYPE = "sample_type";
    static final String ATTR_FILE_TYPE = "file_type";
    static final String OTHER_PROPERTIES_SAMPLE_TYPE = "Sample Type";
    static final String OTHER_PROPERTIES_FILE_TYPE = "File Type";

    @Override
    public List<ProjectSummary> getAll() {
        return createProjectSummaryFromDataFile();
    }

    private List<ProjectSummary> createProjectSummaryFromDataFile() {
        List<ProjectSummary> list = new ArrayList<>();
        String text;
        try {
            text = new String(Files.readAllBytes(Paths.get(FILE_DIR + DATA_FILE_NAME)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("Failed to read data file.", e);
            return list;
        }

        JSONObject jsonObj = new JSONObject(text);

        jsonObj.keySet().forEach(keyStr -> {
            if (!keyStr.equals(ATTR_ST_JUDE_DATASETS)) {
                JSONObject projectObject = (JSONObject) jsonObj.get(keyStr);

                Summary summary = new Summary();
                summary.setCaseDiseaseDiagnosisSummary(extractDigestElementByAttributeName(projectObject, ATTR_DIAGNOSIS));
                summary.setCaseEthnicitySummary(extractDigestElementByAttributeName(projectObject, ATTR_ETHNICITY));
                summary.setSampleIdSummary(((JSONObject) projectObject.getJSONObject(ATTR_SAMPLE_NAME)).length());
                summary.setCaseIdSummary(((JSONObject) projectObject.getJSONObject(ATTR_SUBJECT_NAME)).length());
                summary.setCaseRaceSummary(extractDigestElementByAttributeName(projectObject, ATTR_RACE));
                summary.setCaseSexSummary(extractDigestElementByAttributeName(projectObject, ATTR_SEX));
                summary.setSampleAssayMethodSummary(extractDigestElementByAttributeName(projectObject, ATTR_SEQUENCING_TYPE));
                summary.setCaseAgeSummary(extractCaseAge(projectObject));
                summary.setSampleTypeSummary(extractDigestElementByAttributeName(projectObject, ATTR_SAMPLE_TYPE));
                summary.setFileTypeSummary(extractDigestElementByAttributeName(projectObject, ATTR_FILE_TYPE));
                ProjectSummary project = new ProjectSummary();
                project.setName(keyStr);
                project.setDescription(keyStr);
                project.setPoc("poc");
                project.setPocEmail("pocEmail");
                project.setSummary(summary);
                project.setLastUpdateDate(LocalDate.now());
                project.setType(ProjectSummary.ComponentTypeEnum.PROJECT);
                project.setPublication(extractDigestStringByAttributeName(projectObject, ATTR_PUBLICATION));

                list.add(project);
            }
        });

        return list;
    }

    private List<SummaryElement> extractDigestElementByAttributeName(JSONObject jsonObj, String attributeName) {
        List<SummaryElement> digestElementList = new ArrayList<>();
        JSONObject attributeObject = jsonObj.getJSONObject(attributeName);
        attributeObject.keySet().forEach(key -> {
            digestElementList.add(new SummaryElement(key, (Integer) attributeObject.get(key)));
        });
        return digestElementList;
    }

    private String extractDigestStringByAttributeName(JSONObject jsonObj, String attributeName) {
        return jsonObj.getString(attributeName);
    }

    

    private List<SummaryElement> extractCaseAge(JSONObject projectObject) {
        JSONObject projectAttributeObject = (JSONObject)projectObject.getJSONObject(ATTR_AGE_AT_DIAGNOSIS);
        
        Iterator<String> keysIt = projectAttributeObject.keys();
        Map<String, Integer> ageRangeCountMap = new HashMap<>();
        Set<DoubleRange> predefinedAgeRangeSet = Constants.AGE_BUCKET_MAP.keySet();
        while(keysIt.hasNext()) {
            String keyInString = keysIt.next();
            int ageRangeCount = projectAttributeObject.getInt(keyInString);

            //handle "Not Available" case
            if(keyInString.equals("Not Available")) {
                ageRangeCountMap.put(keyInString, ageRangeCount);
                continue;
            }

            // handle age range
            Double keyInDouble = Double.parseDouble(keyInString);
            List<DoubleRange> rangeList = predefinedAgeRangeSet.stream().filter(item-> 
                item.containsDouble(keyInDouble)
            ).collect(Collectors.toList());
            if(rangeList.size() > 0) {
                String ageRangeInString = Constants.AGE_BUCKET_MAP.get(rangeList.get(0));
                if(!ageRangeCountMap.containsKey(ageRangeInString)) {
                    ageRangeCountMap.put(ageRangeInString, ageRangeCount);
                } else {
                    int currentCount = ageRangeCountMap.get(ageRangeInString);
                    ageRangeCountMap.put(ageRangeInString, currentCount + ageRangeCount);
                }
            }
        }

        List<SummaryElement> list = new ArrayList<>();
        ageRangeCountMap.entrySet().stream().forEach(entry -> {
            list.add(new SummaryElement(entry.getKey(), entry.getValue()));
        });

        return list;
    }
}
