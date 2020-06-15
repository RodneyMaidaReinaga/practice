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

import java.io.FileInputStream;

/**
 * @author Rodney
 * @version 1.1
 */

public class FileInputStreamValidation implements IValidatorStrategy{

    private FileInputStream fileInputStream;

    public FileInputStreamValidation(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    @Override
    public void valdiate() throws InvalidDataException {
        if (fileInputStream.equals(null)) {
            throw new InvalidDataException(ErrorMessageConstant.FILE_INPUT_STREAM_ERROR_MESSAGE);
        }
    }
}
