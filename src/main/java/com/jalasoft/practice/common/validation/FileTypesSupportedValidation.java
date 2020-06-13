/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.common.validation;

import com.jalasoft.practice.common.constant.ErrorMessageConstant;
import com.jalasoft.practice.common.exception.InvalidDataException;

/**
 * @author Rodney
 * @version 1.1
 */

public class FileTypesSupportedValidation implements IValidatorStrategy{
    private String fileType;

    public FileTypesSupportedValidation(String value) {
        this.fileType = value;
    }

    @Override
    public void valdiate() throws InvalidDataException {
        if (this.fileType == null || this.fileType.trim().isEmpty()) {
            throw new InvalidDataException(String.format(ErrorMessageConstant.FILE_TYPE_NOT_SUPPORTED_MESSAGE));
        }
    }
}
