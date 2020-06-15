/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.common.validation;

import com.jalasoft.practice.common.configuration.ConfigurationProperty;
import com.jalasoft.practice.common.configuration.PropertyHandler;
import com.jalasoft.practice.common.constant.PropertyConstant;
import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.common.constant.ErrorMessageConstant;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rodney
 * @version 1.1
 */

public class LanguageValidation implements IValidatorStrategy{


    private String language;
    private List<String> LANGUAGES;

    public LanguageValidation(String language) throws InvalidDataException{
        this.language = language;
        this.LANGUAGES = ConfigurationProperty.getLanguages();
    }

    @Override
    public void valdiate() throws InvalidDataException {
        if(!LANGUAGES.contains(this.language)) {
            throw new InvalidDataException(ErrorMessageConstant.LANGUAGE_ERROR_MESSAGE);
        }
    }
}
