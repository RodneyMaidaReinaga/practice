/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.model.convert.parameter;

import java.io.FileInputStream;

/**
 * Class that specify the base needs for needed tfor a conversion from one file to another
 *
 * @author Rodney
 * @version 1.1
 */

public class ConverterParameter {
    FileInputStream inputStream;

    public ConverterParameter(FileInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public FileInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(FileInputStream inputStream) {
        this.inputStream = inputStream;
    }
}
