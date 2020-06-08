/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.controller.request;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.common.validation.IValidatorStrategy;
import com.jalasoft.practice.common.validation.LanguageValidation;
import com.jalasoft.practice.common.validation.MD5Validation;
import com.jalasoft.practice.common.validation.MimeTypeValidation;
import com.jalasoft.practice.common.validation.MultipartValidation;
import com.jalasoft.practice.common.validation.NotNullOrEptyValidation;
import com.jalasoft.practice.common.validation.ValidationContext;
import com.jalasoft.practice.controller.exception.RequestParamInvalidException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rodney
 * @version 1.1
 */

public class RequestExtractParameter extends RequestParameter {
    private String language;
    private final static List<String> LANGUAGES = Arrays.asList("eng", "spa");

    public RequestExtractParameter(String language, String md5, MultipartFile file) {
        super(md5, file);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void validate() throws InvalidDataException {
        List<IValidatorStrategy> strategyList = Arrays.asList(
                new NotNullOrEptyValidation("md5", this.md5),
                new MD5Validation(this.md5),
                new MultipartValidation(this.file),
                new MimeTypeValidation(this.file.getContentType()),
                new NotNullOrEptyValidation("Language", this.language),
                new LanguageValidation(this.language)
        );
        ValidationContext context = new ValidationContext(strategyList);
        context.validate();
    }
}
