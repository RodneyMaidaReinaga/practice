/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.controller.request;

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
    public void validate() throws RequestParamInvalidException {
        if (this.md5 == null || this.md5.trim().isEmpty()) {
            throw new RequestParamInvalidException("md5 is null or empty");
        }
        if (this.md5.matches("[a-fA-F0-A]{32}")) {
            throw new RequestParamInvalidException("md5 invalid");
        }
        if (this.file == null || this.file.isEmpty()) {
            throw new RequestParamInvalidException("File is null or empty");
        }
        if (this.file.getContentType() == null || !this.file.getContentType().startsWith("image")) {
            throw new RequestParamInvalidException("Invalid file format");
        }
        if (this.file.getOriginalFilename().contains("..")) {
            throw new RequestParamInvalidException("Invalid file name");
        }
        if ((this.language == null) || this.language.isEmpty()) {
            throw new RequestParamInvalidException("language is null or empty");
        }
        if (!LANGUAGES.contains(this.language)) {
            throw new RequestParamInvalidException("language not allowed");
        }

    }
}
