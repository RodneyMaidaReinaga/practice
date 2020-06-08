/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.common.validation;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.common.constant.ErrorMessageConstant;

/**
 * @author Rodney
 * @version 1.1
 */

public class MD5Validation implements IValidatorStrategy{

    private String md5;
    private final static String REGEX_MD5 = "[a-fA-F0-A]{32}";

    public MD5Validation(String md5) {
        this.md5 = md5;
    }

    @Override
    public void valdiate() throws InvalidDataException {
        if (!this.md5.matches(REGEX_MD5)) {
            throw new InvalidDataException(ErrorMessageConstant.MD5_ERROR_MESSAGE);
        }
    }
}
