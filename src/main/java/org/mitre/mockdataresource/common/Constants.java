/*****************************************************************************************************************************
NOTICE
This (software/technical data) was produced for the U. S. Government under Contract Number 75FCMC18D0047, and is subject to 
Federal Acquisition Regulation Clause 52.227-14, Rights in Data-General. No other use other than that granted to the U. S. 
Government, or to those acting on behalf of the U. S. Government under that Clause is authorized without the express written 
permission of The MITRE Corporation.For further information, please contact The MITRE Corporation, Contracts Management Office, 
7515 Colshire Drive, McLean, VA 22102-7539, (703) 983-6000.
© 2021 The MITRE Corporation.
******************************************************************************************************************************/

package org.mitre.mockdataresource.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.math.DoubleRange;

public class Constants {

    public static final String DIGEST_ELEMENT_CASE_AGE_0 = "0 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_1 = "1 to 4 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_5 = "5 to 9 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_10 = "10 to 14 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_15 = "15 to 19 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_20 = "20 to 24 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_25 = "25 to 29 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_30 = "30 to 34 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_35 = "35 to 39 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_40 = "40 to 44 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_45 = "45 to 49 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_50 = "50 to 54 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_55 = "55 to 59 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_60 = "60 to 64 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_65 = "65 to 69 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_70 = "70 to 74 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_75 = "75 to 79 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_80 = "80 to 84 years";
    public static final String DIGEST_ELEMENT_CASE_AGE_85 = "Greater Than or Equal 85 Years";


    public static Map<DoubleRange, String> AGE_BUCKET_MAP = new HashMap<>();
    static {
        AGE_BUCKET_MAP.put(new DoubleRange(0.0, 0.9), DIGEST_ELEMENT_CASE_AGE_0);
        AGE_BUCKET_MAP.put(new DoubleRange(1.0, 4.9), DIGEST_ELEMENT_CASE_AGE_1);
        AGE_BUCKET_MAP.put(new DoubleRange(5.0, 9.9), DIGEST_ELEMENT_CASE_AGE_5);
        AGE_BUCKET_MAP.put(new DoubleRange(10.0, 14.9), DIGEST_ELEMENT_CASE_AGE_10);
        AGE_BUCKET_MAP.put(new DoubleRange(15.0, 19.9), DIGEST_ELEMENT_CASE_AGE_15);
        AGE_BUCKET_MAP.put(new DoubleRange(20.0, 24.9), DIGEST_ELEMENT_CASE_AGE_20);
        AGE_BUCKET_MAP.put(new DoubleRange(25.0, 29.9), DIGEST_ELEMENT_CASE_AGE_25);
        AGE_BUCKET_MAP.put(new DoubleRange(30.0, 34.9), DIGEST_ELEMENT_CASE_AGE_30);
        AGE_BUCKET_MAP.put(new DoubleRange(35.0, 39.9), DIGEST_ELEMENT_CASE_AGE_35);
        AGE_BUCKET_MAP.put(new DoubleRange(40.0, 44.9), DIGEST_ELEMENT_CASE_AGE_40);
        AGE_BUCKET_MAP.put(new DoubleRange(45.0, 49.9), DIGEST_ELEMENT_CASE_AGE_45);
        AGE_BUCKET_MAP.put(new DoubleRange(50.0, 54.9), DIGEST_ELEMENT_CASE_AGE_50);
        AGE_BUCKET_MAP.put(new DoubleRange(55.0, 59.9), DIGEST_ELEMENT_CASE_AGE_55);
        AGE_BUCKET_MAP.put(new DoubleRange(60.0, 64.9), DIGEST_ELEMENT_CASE_AGE_60);
        AGE_BUCKET_MAP.put(new DoubleRange(65.0, 69.9), DIGEST_ELEMENT_CASE_AGE_65);
        AGE_BUCKET_MAP.put(new DoubleRange(70.0, 74.9), DIGEST_ELEMENT_CASE_AGE_70);
        AGE_BUCKET_MAP.put(new DoubleRange(75.0, 79.9), DIGEST_ELEMENT_CASE_AGE_75);
        AGE_BUCKET_MAP.put(new DoubleRange(80.0, 84.9), DIGEST_ELEMENT_CASE_AGE_80);
        AGE_BUCKET_MAP.put(new DoubleRange(85.0, 120.0), DIGEST_ELEMENT_CASE_AGE_85);
    }
    
}
