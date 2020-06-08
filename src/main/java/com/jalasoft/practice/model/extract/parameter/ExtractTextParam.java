/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.model.extract.parameter;

import com.jalasoft.practice.common.Util;
import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.common.validation.FileValidation;
import com.jalasoft.practice.common.validation.IValidatorStrategy;
import com.jalasoft.practice.common.validation.LanguageValidation;
import com.jalasoft.practice.common.validation.MD5Validation;
import com.jalasoft.practice.common.validation.MimeTypeValidation;
import com.jalasoft.practice.common.validation.MultipartValidation;
import com.jalasoft.practice.common.validation.NotNullOrEptyValidation;
import com.jalasoft.practice.common.validation.ValidationContext;
import com.jalasoft.practice.model.extract.exception.ParameterInvalidException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rodney
 * @version 1.1
 */

public class ExtractTextParam extends Parameter{
    private String language;
    private String tessData;
    private final static List<String> LANGUAGES = Arrays.asList("eng", "spa");

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
    public void validate() throws InvalidDataException {
        List<IValidatorStrategy> strategyList = Arrays.asList(
                new FileValidation(this.inputFile, true),
                new MimeTypeValidation(Util.getMimeType(this.inputFile)),
                new NotNullOrEptyValidation("tessdata", this.tessData),
                new FileValidation(new File(this.tessData), false),
                new NotNullOrEptyValidation("language", this.language),
                new LanguageValidation(this.language)
        );
        ValidationContext context = new ValidationContext(strategyList);
        context.validate();
    }
}
