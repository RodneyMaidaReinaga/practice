/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.controller.practice3.view;

import com.jalasoft.practice.controller.practice3.controller.ListLandTransport;
import com.jalasoft.practice.controller.practice3.model.Bicycle;
import com.jalasoft.practice.controller.practice3.model.Car;

/**
 * Main method for the Practice 3, creates a ListLandTransport, adds 2 Land object to it and display all the
 * information of each Land object saved in the ListLandTransport object
 *
 * @author Rodney
 * @version 1.1
 */

public class Main {
    public static void main(String[] args) {
        ListLandTransport trans = new ListLandTransport();
        trans.addLand(new Bicycle("Cross", 1500, false, false));
        trans.addLand(new Car("Audi", 20000, true, false));
        trans.display();
    }
}
