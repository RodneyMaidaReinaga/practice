/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.model.convert;

import com.jalasoft.practice.model.convert.parameter.ConvertPptxToPdfParam;
import com.jalasoft.practice.model.convert.parameter.ConverterParameter;
import com.lowagie.text.BadElementException;
import com.lowagie.text.pdf.PdfPTable;

import java.io.IOException;

/**
 * The IConverter interface takes care of specify what a converter clasee needs to implement in order to
 * convert a type of file into another type of file
 *
 * @author Rodney
 * @version 1.1
 */

public interface IConverter<T extends ConverterParameter> {

    /**
     * The ConvertPptx method should be implemented on any class that implemtes this interface
     *
     * @param parameter
     * @return
     * @throws IOException
     * @throws BadElementException
     */

    PdfPTable convert(T parameter) throws IOException, BadElementException;
}


