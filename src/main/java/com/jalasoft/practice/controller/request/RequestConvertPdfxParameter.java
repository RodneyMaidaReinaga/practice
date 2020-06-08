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
import com.jalasoft.practice.common.validation.ExtensionValidation;
import com.jalasoft.practice.common.validation.IValidatorStrategy;
import com.jalasoft.practice.common.validation.MD5Validation;
import com.jalasoft.practice.common.validation.MultipartValidation;
import com.jalasoft.practice.common.validation.NotNullOrEptyValidation;
import com.jalasoft.practice.common.validation.ValidationContext;
import com.jalasoft.practice.controller.exception.RequestParamInvalidException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * Class that represents the parameters suplied by the user in order to request a conversion of a Pptx file
 * into a Pdf file
 * This Class extends from RequestParameter class in order to take advantage of the file and md5 characteristics
 * of the parent class, however so  far the one actually used is the md5 characteristics, needs to analyze
 * if its better to create a new parent class specific for the converion feature of the app
 *
 * @author Rodney
 * @version 1.1
 */

public class RequestConvertPdfxParameter extends RequestParameter{
    private String sourcePath;
    private String destinationPath;
//    private final static List<String> TYPE_LIST = Arrays.asList(
//            "application/vnd.openxmlformats-officedocument.presentationml.presentation","xmp");

    public RequestConvertPdfxParameter(String md5, MultipartFile file, String sourcePath, String destinationPath) {
        super(md5, file);
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    @Override
    public void validate() throws InvalidDataException {
        List<IValidatorStrategy> strategyList = Arrays.asList(
                new NotNullOrEptyValidation("md5", this.md5),
                new MD5Validation(this.md5),
                new MultipartValidation(this.file),
                new NotNullOrEptyValidation("Source path", this.sourcePath),
                new NotNullOrEptyValidation("destination path", this.destinationPath)
        );

        ValidationContext context = new ValidationContext(strategyList);
        context.validate();
    }
}
