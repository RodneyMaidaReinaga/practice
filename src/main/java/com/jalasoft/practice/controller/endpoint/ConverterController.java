/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.controller.endpoint;

import com.jalasoft.practice.controller.component.Properties;
import com.jalasoft.practice.controller.request.RequestConvertPdfxParameter;
import com.jalasoft.practice.controller.response.ErrorResponse;
import com.jalasoft.practice.controller.response.OkResponse;
import com.jalasoft.practice.controller.service.FileService;
import com.jalasoft.practice.model.convert.ConvertPptxToPdf;
import com.jalasoft.practice.model.convert.parameter.ConvertPptxToPdfParam;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.ghost4j.converter.ConverterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class that takes care of receive the request to convert a pptx file into a pdf file
 * Also takes care of do the preparations and call the convert method
 * Should be also in charge of making the download link but at the moment i have some problems
 * with the  dowload link generation
 *
 * @author Rodney
 * @version 1.1
 */

@RestController
@RequestMapping("/api/v1")
public class ConverterController {

    @Autowired
    private Properties properties;

    @Autowired
    private FileService fileService;

    /**
     * Method that receive a RequestConvertPdfxParameter as a parameter to requst a convertion of
     * a pptx file into a pdf file
     *
     * @param parameter is a RequestConvertPdfxParameter object
     * @return a ResponseEntity object or a exception with a download link and response status of Ok or Error
     */

    @PostMapping("/convertor")
    public ResponseEntity convertPPTToPDF(RequestConvertPdfxParameter parameter) {

        ConvertPptxToPdf convertPptxToPdf = new ConvertPptxToPdf();

        Document pdfDocument = new Document();
        byte[] byteArray = new byte[0];
        try (
                FileInputStream inputStream = new FileInputStream(parameter.getSourcePath());
                ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
                FileOutputStream outputStream = new FileOutputStream(new File(parameter.getDestinationPath()));
            ) {
                PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, byteArrayOutput);
                if (parameter
                        .getFile()
                        .getContentType()
                        .equalsIgnoreCase(
                                "application/vnd.openxmlformats-officedocument." +
                                        "presentationml.presentation")
                ) {
                    PdfPTable table = convertPptxToPdf.convert(
                            new ConvertPptxToPdfParam(inputStream, pdfDocument, pdfWriter));
                    pdfDocument.add(table);
                    pdfDocument.close();
                    byteArray = byteArrayOutput.toByteArray();
                    pdfWriter.close();
                }
                outputStream.write(byteArray);
            String fileDownloadUri = fileService.getDaownloadLink(new File(parameter.getDestinationPath()));
            return ResponseEntity.ok().body(
                    new OkResponse<Integer>(fileDownloadUri, HttpServletResponse.SC_OK));
        } catch (FileNotFoundException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        } catch (ConverterException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        } catch (DocumentException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        } catch (IOException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        }
    }
}
