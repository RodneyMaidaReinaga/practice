/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.model.extract.parameter;

import com.jalasoft.practice.model.extract.exception.ParameterInvalidException;

import java.io.File;

/**
 * @author Rodney
 * @version 1.1
 */

public class ExtractTextParam extends Parameter{
//    private String imageFile;
    private String language;
    private String tessData;

    public ExtractTextParam(File file, String language, String tessData) {
        super(file);
        this.language = language;
        this.tessData = tessData;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTessData() {
        return tessData;
    }

    public void setTessData(String tessData) {
        this.tessData = tessData;
    }

    @Override
    public void validate() throws ParameterInvalidException {
        super.validate();
        if (this.language.trim().isEmpty()) {
            throw new ParameterInvalidException();
        }
        if (!"eng".equals(this.language)) {
            throw new ParameterInvalidException("language", language);
        }
    }
}
