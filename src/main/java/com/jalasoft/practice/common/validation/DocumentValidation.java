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

import com.lowagie.text.Document;

/**
 * @author Rodney
 * @version 1.1
 */

public class DocumentValidation implements IValidatorStrategy{

    private Document pdfDocument;

    public DocumentValidation(Document pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    @Override
    public void valdiate() throws InvalidDataException {
        if (pdfDocument.equals(null)) {
            throw new InvalidDataException(ErrorMessageConstant.DOCUMENT_ERROR_MESSAGE);
        }
    }
}
