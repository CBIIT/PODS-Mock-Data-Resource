/*****************************************************************************************************************************
NOTICE
This (software/technical data) was produced for the U. S. Government under Contract Number 75FCMC18D0047, and is subject to 
Federal Acquisition Regulation Clause 52.227-14, Rights in Data-General. No other use other than that granted to the U. S. 
Government, or to those acting on behalf of the U. S. Government under that Clause is authorized without the express written 
permission of The MITRE Corporation.For further information, please contact The MITRE Corporation, Contracts Management Office, 
7515 Colshire Drive, McLean, VA 22102-7539, (703) 983-6000.
© 2021 The MITRE Corporation.
******************************************************************************************************************************/

package org.mitre.mockdataresource.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {
    private List<SummaryElement> caseAgeSummary;

    private List<SummaryElement> caseAgeAtDiagnosisSummary;

    private List<SummaryElement> caseAgeAtTrialSummary;

    private List<SummaryElement> caseDiseaseDiagnosisSummary;

    private List<SummaryElement> caseEthnicitySummary;

    private List<SummaryElement> caseGenderSummary;

    private Integer caseIdSummary;

    private List<SummaryElement> caseProbandSummary;
   
    private List<SummaryElement> caseRaceSummary;

    private List<SummaryElement> caseSexSummary;

    private List<SummaryElement> caseSexAtBirthSummary;
   
    private List<SummaryElement> caseTreatmentAdministeredSummary;

    private List<SummaryElement> caseTreatmentOutcomeSummary;

    private List<SummaryElement> caseTumorSiteSummary;
    
    private Integer cellLineIdSummary;

    private List<SummaryElement> donorAgeSummary;

    private List<SummaryElement> donorAnatomicSiteSummary;

    private List<SummaryElement> donorDiseaseDiagnosisSummary;

    private List<SummaryElement> donorSexSummary;

    private List<SummaryElement> projectAnatomicSiteSummary;

    private List<SummaryElement> projectCancerStudiedSummary;

    private List<SummaryElement> sampleAnalyteTypeSummary;

    private List<SummaryElement> sampleAnatomicTypeSummary;

    private List<SummaryElement> sampleAssayMethodSummary;

    private List<SummaryElement> sampleCompositionTypeSummary;

    private List<SummaryElement> sampleRepositoryNameSummary;

    private Integer sampleIdSummary; 

    // other summary not included as core elements if needed
    private List<SummaryElement> fileTypeSummary;

    private List<SummaryElement> sampleTypeSummary;
}
