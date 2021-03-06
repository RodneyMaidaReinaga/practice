/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.model.extract;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.model.extract.exception.ExtractException;
import com.jalasoft.practice.model.extract.parameter.ExtractTextParam;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ExtractorTextFromImageTest {

    private final static String PATH = "src/test/resources/extractText/";
    private final static String TESS4J = "thirdParty/Tess4J/tessdata";

    @Test
    public void extractTextValidImage() throws InvalidDataException, ExtractException {
        ExtractTextParam param = new ExtractTextParam(
                new File(PATH + "number.png"),
                "eng",
                TESS4J
        );
        ExtractorTextFromImage ext = new ExtractorTextFromImage();
        assertEquals("468792", ext.extract(param).getText());
    }

    @Test
    public void extractTextValidImageWhitoutText() throws InvalidDataException, ExtractException {
        ExtractTextParam param = new ExtractTextParam(
                new File(PATH + "NarutoTeam7.png"),
                "eng",
                TESS4J
        );
        ExtractorTextFromImage ext = new ExtractorTextFromImage();
        assertEquals("mu:\n" +
                "k ,3\n" +
                "ﬂ“\n" +
                ":2 '7' ,\n" +
                "\\(hﬂ '\n" +
                "5 F 1‘ ”‘ 5", ext.extract(param).getText());
    }

    @Test(expected = InvalidDataException.class)
    public void extractTextFromTextFile() throws InvalidDataException, ExtractException {
        ExtractTextParam param = new ExtractTextParam(
                new File(PATH + "test.txt"),
                "eng",
                TESS4J
        );
        ExtractorTextFromImage ext = new ExtractorTextFromImage();
        ext.extract(param).getText();
    }

    @Test(expected = InvalidDataException.class)
    public void extractTextInvalidTessdata() throws InvalidDataException, ExtractException {
        ExtractTextParam param = new ExtractTextParam(
                new File(PATH + "number.png"),
                "eng",
                TESS4J + "/invalid"
        );
        ExtractorTextFromImage ext = new ExtractorTextFromImage();
        ext.extract(param);
    }

    @Test(expected = InvalidDataException.class)
    public void extractTextInvalidParameter() throws InvalidDataException, ExtractException {
        ExtractorTextFromImage ext = new ExtractorTextFromImage();
        ext.extract(null);
    }
}