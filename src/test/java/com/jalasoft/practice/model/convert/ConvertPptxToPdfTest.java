/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.model.convert;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.model.convert.parameter.ConvertPptxToPdfParam;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import org.ghost4j.converter.ConverterException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

public class ConvertPptxToPdfTest {

    private final static String PATH = "src\\test\\resources\\convertTest/";

    @Test
    public void convertPptxToPdfWithValidParametersCompleteTable()
            throws FileNotFoundException, DocumentException, ConverterException, InvalidDataException {
        FileInputStream fileInputStream = new FileInputStream(PATH + "MiPPTAzul.pptx");
        Document pdfDocument = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new ByteArrayOutputStream());
        ConvertPptxToPdf convertPptxToPdf = new ConvertPptxToPdf();

        PdfPTable table = convertPptxToPdf.convert(
                new ConvertPptxToPdfParam(fileInputStream, pdfDocument, pdfWriter));
        assertEquals( true, table.isComplete());
    }

    @Test
    public void convertPptxToPdfWithValidParametersContentObject()
            throws FileNotFoundException, DocumentException, ConverterException, InvalidDataException {
        FileInputStream fileInputStream = new FileInputStream(PATH + "MiPPTAzul.pptx");
        Document pdfDocument = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new ByteArrayOutputStream());
        ConvertPptxToPdf convertPptxToPdf = new ConvertPptxToPdf();

        PdfPTable table = convertPptxToPdf.convert(
                new ConvertPptxToPdfParam(fileInputStream, pdfDocument, pdfWriter));
        assertEquals( true, table.isContent());
    }

    @Test(expected = InvalidDataException.class)
    public void convertPptxToPdfFileImPutStreamNull()
            throws DocumentException, ConverterException, InvalidDataException {
        Document pdfDocument = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new ByteArrayOutputStream());
        ConvertPptxToPdf convertPptxToPdf = new ConvertPptxToPdf();

        PdfPTable table = convertPptxToPdf.convert(new ConvertPptxToPdfParam(null, pdfDocument, pdfWriter));
    }

    @Test(expected = InvalidDataException.class)
    public void convertPptxToPdfPdfDocumentNull()
            throws DocumentException, ConverterException, InvalidDataException, FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(PATH + "MiPPTAzul.pptx");
        Document pdfDocument = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new ByteArrayOutputStream());
        ConvertPptxToPdf convertPptxToPdf = new ConvertPptxToPdf();

        PdfPTable table = convertPptxToPdf.convert(
                new ConvertPptxToPdfParam(fileInputStream, null, pdfWriter));
    }

    @Test(expected = InvalidDataException.class)
    public void convertPptxToPdfWriterNull()
            throws ConverterException, InvalidDataException, FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(PATH + "MiPPTAzul.pptx");
        Document pdfDocument = new Document();
        ConvertPptxToPdf convertPptxToPdf = new ConvertPptxToPdf();

        PdfPTable table = convertPptxToPdf.convert(
                new ConvertPptxToPdfParam(fileInputStream, pdfDocument, null));
    }

    @Test(expected = InvalidDataException.class)
    public void convertPptxToWithConvertPArameterNull()
            throws ConverterException, InvalidDataException {
        ConvertPptxToPdf convertPptxToPdf = new ConvertPptxToPdf();

        PdfPTable table = convertPptxToPdf.convert(null);
    }

    @Test(expected = InvalidDataException.class)
    public void convertPptxToPdfWithValidFile()
            throws FileNotFoundException, DocumentException, ConverterException, InvalidDataException {
        FileInputStream fileInputStream = new FileInputStream(PATH + "number.png");
        Document pdfDocument = new Document();
        PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new ByteArrayOutputStream());
        ConvertPptxToPdf convertPptxToPdf = new ConvertPptxToPdf();

        PdfPTable table = convertPptxToPdf.convert(
                new ConvertPptxToPdfParam(fileInputStream, pdfDocument, pdfWriter));
    }
}