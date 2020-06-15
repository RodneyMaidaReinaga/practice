/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.model.convert;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Rodney
 * @version 1.1
 */

public class ConvertFactory {

    public final static String PPTX = "pptx";
    public final static Map<String, IConverter> convertMap = new HashMap<String, IConverter>() {
        {
            put(PPTX, new ConvertPptxToPdf());
        }
    };

    public static IConverter createConverter(String convert) {
        return convertMap.get(convert);
    }
}
