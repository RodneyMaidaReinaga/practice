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
 * Car is a class that extends from Land
 *
 * @author Rodney
 * @version 1.1
 */

public class Car extends Land {
    private boolean useGas;

    /**
     * Constructor that sets the values for a Car object parameters (parameters: name, price, hasMotor and usGas)
     *
     * @param name is the name of the Car object
     * @param price is the price of the Car object
     * @param hasMotor define if the Car object has a motor or not
     * @param useGas define if the Car object runs on gas or not
     */

    public Car(String name, int price, boolean hasMotor, boolean useGas) {
        super(name, price, hasMotor);
        this.useGas = useGas;
    }

    /**
     * Method that returns the value of the useGas parameter
     *
     * @return a boolean that define if the Car object runs on gas or not
     */

    public boolean isUseGas() {
        return useGas;
    }

    /**
     * Method that overrides the displayData method of the Land class, this method returns a String that
     * displays all the data related with the Car object
     *
     * @return a String that displays all the data related with the Car object
     */

    @Override
    public String displayData() {
        return super.displayData() + ", useGas = " + isUseGas();
    }
}
