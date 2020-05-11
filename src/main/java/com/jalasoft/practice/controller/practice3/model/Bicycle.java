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
 * Bicycle is a class that extends from Land
 *
 * @author Rodney
 * @version 1.1
 */

public class Bicycle extends Land {
    private boolean exerciseBike;

    /**
     * Constructor that sets the values for a Bicycle object parameters (parameters: name, price,
     * hasMotor and exerciseBike)
     *
     * @param name is the name of the Car object
     * @param price is the price of the Car object
     * @param hasMotor define if the Car object has a motor or not
     * @param exerciseBike define if the Bicycle object is a exercise one or not
     */

    public Bicycle(String name, int price, boolean hasMotor, boolean exerciseBike) {
        super(name, price, hasMotor);
        this.exerciseBike = exerciseBike;
    }

    /**
     * Method that returns the value of the exerciseBike parameter
     *
     * @return a boolean that define if the Bicycle object is a exercise one or not
     */

    public boolean isExerciseBike() {
        return exerciseBike;
    }

    /**
     * Method that overrides the displayData method of the Land class, this method returns a String that
     * displays all the data related with the Bicycle object
     *
     * @return a String that displays all the data related with the Bicycle object
     */

    @Override
    public String displayData() {
        return super.displayData() + ", exerciseBike = " + isExerciseBike();
    }
}
