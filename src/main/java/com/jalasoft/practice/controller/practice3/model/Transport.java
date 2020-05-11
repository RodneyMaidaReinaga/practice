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
 * Class that set the initial characteristics for a transport in general
 *
 * @author Rodney
 * @version 1.1
 */

public class Transport {
    private String name;
    public int price;

    /**
     * Contructor that set the initial values for the Transport object parameters (parameters: name and price)
     *
     * @param name is the name of the transport
     * @param price is the prices of the transport
     */

    public Transport(String name, int price){
        this.name = name;
        this.price = price;
    }

    /**
     * Method that returns the name value
     *
     * @return the name value
     */

    public String getName() {
        return name;
    }

    /**
     * Method that returns the price value
     *
     * @return the price value
     */

    public int getPrice() {
        return price;
    }
}
