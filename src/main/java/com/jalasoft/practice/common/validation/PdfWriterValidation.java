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
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author Rodney
 * @version 1.1
 */

public class PdfWriterValidation implements IValidatorStrategy{

    private PdfWriter pdfWriter;

    public PdfWriterValidation(PdfWriter pdfWriter) {
        this.pdfWriter = pdfWriter;
    }

    @Override
    public void valdiate() throws InvalidDataException {
        if (pdfWriter.equals(null)) {
            throw new InvalidDataException(ErrorMessageConstant.PDF_WRITER_ERROR_MESSAGE);
        }
    }
}
