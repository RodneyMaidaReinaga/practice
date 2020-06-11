/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.model.convert.parameter;

import com.jalasoft.practice.common.Util;
import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.common.validation.FileInputStreamValidation;
import com.jalasoft.practice.common.validation.FileValidation;
import com.jalasoft.practice.common.validation.IValidatorStrategy;
import com.jalasoft.practice.common.validation.LanguageValidation;
import com.jalasoft.practice.common.validation.MimeTypeValidation;
import com.jalasoft.practice.common.validation.NotNullOrEptyValidation;
import com.jalasoft.practice.common.validation.DocumentValidation;
import com.jalasoft.practice.common.validation.PdfWriterValidation;
import com.jalasoft.practice.common.validation.ValidationContext;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Class that extends from ConverterParameter class, this child class adds the characteristics needed to
 * convert a PPtx file into a Pdf file, and actually mibht be what is needed to convert any kind of file
 * into a PDF
 *
 * @author Rodney
 * @version 1.1
 */

public class ConvertPptxToPdfParam extends ConverterParameter{
    Document pdfDocument;
    PdfWriter pdfWriter;

    public ConvertPptxToPdfParam(FileInputStream inputStream, Document pdfDocument, PdfWriter pdfWriter) {
        super(inputStream);
        this.pdfDocument = pdfDocument;
        this.pdfWriter = pdfWriter;
    }

    public Document getPdfDocument() {
        return pdfDocument;
    }

    public void setPdfDocument(Document pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    public PdfWriter getPdfWriter() {
        return pdfWriter;
    }

    public void setPdfWriter(PdfWriter pdfWriter) {
        this.pdfWriter = pdfWriter;
    }

    @Override
    public void validate() throws InvalidDataException {
        List<IValidatorStrategy> strategyList = Arrays.asList(
                new FileInputStreamValidation(this.inputStream),
                new DocumentValidation(this.pdfDocument),
                new PdfWriterValidation(this.pdfWriter)
        );
        ValidationContext context = new ValidationContext(strategyList);
        context.validate();
    }
}