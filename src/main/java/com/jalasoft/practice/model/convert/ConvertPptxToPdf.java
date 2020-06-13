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
import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.Rectangle;
import org.apache.poi.POIXMLException;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.ghost4j.converter.ConverterException;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Class that takes care of the conversion of the Pptx file to a PDF file
 *
 * @author Rodney
 * @version 1.1
 */

public class ConvertPptxToPdf implements IConverter<ConvertPptxToPdfParam> {

    /**
     * Class taht implementes the IConverter interface, takes charge of the necessary
     * logic to convert a Pptx to a Pdf file
     *
     * @param parameter is an object taht specify the characteristics needed to do a conversion
     * @return a PDFTable, which will be  used to create the PDf document
     * @throws IOException
     * @throws BadElementException
     */

    public PdfPTable convert(ConvertPptxToPdfParam parameter) throws InvalidDataException,ConverterException {

        try {
            parameter.validate();
            AffineTransform at = new AffineTransform();

            PdfPTable table = new PdfPTable(1);

            XMLSlideShow ppt = new XMLSlideShow(parameter.getInputStream());

            Dimension pgsize = ppt.getPageSize();

            List<XSLFSlide> slide = Arrays.asList(ppt.getSlides());
            parameter.
                    getPdfDocument().
                    setPageSize(new Rectangle((float) pgsize.getWidth(), (float) pgsize.getHeight()));
            parameter.getPdfWriter().open();
            parameter.getPdfDocument().open();
            Image slideImage;
            for (XSLFSlide slid : slide) {
                BufferedImage img = new BufferedImage((int) Math.ceil(pgsize.width),
                        (int) Math.ceil(pgsize.height),
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                graphics.setTransform(at);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
                slid.draw(graphics);
                slideImage = Image.getInstance(img, null);
                table.addCell(new PdfPCell(slideImage, true));
            }
            return table;
        } catch ( NullPointerException ex) {
            throw new InvalidDataException(ex);
        } catch ( POIXMLException ex) {
            throw new InvalidDataException(ex);
        }catch (IOException | BadElementException ex) {
            throw new ConverterException(ex.getMessage());
        }
    }
}
