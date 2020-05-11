/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.controller.practice3.controller;

import com.jalasoft.practice.controller.practice3.model.Land;

import java.util.ArrayList;
import java.util.List;

/**
 * ListLandTransport is a class that has a list of Land object, is used tostore multiple land objects in a
 * single place
 *
 * @author Rodney
 * @version 1.1
 */

public class ListLandTransport {
    List<Land> land = new ArrayList<>();

    /**
     * Method that add a Land object to the land parameter (a List of Land objects)
     *
     * @param land is an Land object
     */

    public void addLand(Land land) {
        this.land.add(land);
    }

    /**
     * Method that display all the information related with each Land object taht wasadded to the lan list
     */

    public void display() {
        land.stream().forEach(landTransport -> System.out.println(landTransport.displayData()));
    }
}
