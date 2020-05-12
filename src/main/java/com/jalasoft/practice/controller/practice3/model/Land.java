/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.controller.practice3.model;

/**
 * Land is a class that extends from Transport and is defined as the class that represents the land transports
 *
 * @author Rodney
 * @version 1.1
 */

public class Land extends Transport{
    private boolean hasMotor;

    /**
     * Constructor that sets the values for a Land object parameters (parameters: name, price and hasMotor)
     *
     * @param name is the name of the Land object
     * @param price is the price of the Land object
     * @param hasMotor define if the Land object hasa motor or not
     */

    public Land(String name, int price, boolean hasMotor) {
        super(name, price);
        this.hasMotor = hasMotor;
    }

    /**
     * Method that returns the value of the hasMotor parameter
     *
     * @return the hasMotor parameter value
     */

    public boolean isHasMotor() {
        return hasMotor;
    }

    /**
     * Method that returns a String that displays all the data related with the Land object
     *
     * @return a String that displays all the data related with the Land object
     */

    public String displayData() {
        return "name = " + getName() + ", price = " + getPrice() + ", hasMotor = " + isHasMotor();
    }
}
