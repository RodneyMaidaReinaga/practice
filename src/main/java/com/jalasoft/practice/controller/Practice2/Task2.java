/**
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.controller.Practice2;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the required methods to fulfill the required by the Practice 2
 *
 * @author Rodney Maida
 * @version 1.0
 */

public class Task2 {

    /**
     * Does not receive parameters, it takes care of call the methods used to fulfill with Practice 2
     * There are 4 methods, the first 2 methods (printListFor and printListStreamForEach) where for
     * practice and the second 2 methods are the solution for practice 2, one using for and the other one
     * using stream.forEach
     *
     * @author Rodney Maida
     * @version 1.0
     */

    public void practice(){
        List<String> test = new ArrayList<>();
        test.add("Bolivia");
        test.add("Argentina");
        test.add("Argelia");
        test.add("Portugal");
        test.add("Italia");
        test.add("Australia");

        printListFor(test);

        System.out.println("---------------------------");

        printListStreamForEach(test);

        System.out.println("---------------------------");

        printListForFilters(test);

        System.out.println("---------------------------");

        printListStreamForEachFilters(test);
    }

    /**
     * List all the items on the string list "test" using a for to do it
     *
     * @param test is a list of strings
     */

    public void printListFor(List<String> test) {
        for (int index = 0; index < test.size(); index++){
            System.out.println(test.get(index));
        }
    }

    /**
     * List all the items on the string list "test" using a stream.forEach to do it
     *
     * @param test is a list of strings
     */

    public void printListStreamForEach(List<String> test) {
        test.stream().forEach(value -> System.out.println(value));
    }

    /**
     * Resolve what it was required for practices 2 using a for and nest if conditions statements, the first if
     * condition checks if the items of the list starts with a 'A' character, the second if condition checks if
     * the length of the items (Strings) is less than 5 (on the current list provided on the practice method none
     * of the items meet this condition) and the third if check if the count of the characters gives an even number,
     * it checks this using the module operator (%)
     * FYI: the third point of the practice said that the sum of the character be n even number but with what
     * was explained in the class it was clarified that actually it meant to say count of the characters
     *
     * @param test is a list of strings
     */

    public void printListForFilters(List<String> test) {
        for (int index = 0; index < test.size(); index++){
            if (test.get(index).charAt(0) == 'A') {
                if (test.get(index).length() < 5) {
                    if (((test.get(index).length()) % 2) == 0) {
                        System.out.println(test.get(index));
                    }
                }
            }
        }
    }

    /**
     * Resolve what it was required for practices 2 using a stream.forEach and adding 3 filters to it, the
     * first filter checks if the item (String) of the list starts with a 'A' character, the second filter
     * checks if the item has a length less than 5 (on the current list provided on the practice method none
     * of the items meet this condition) and the third filter checks if the length of the item (String) gives
     * an even number, it checks this using the module operator (%)
     * FYI: the third point of the practice said that the sum of the character be n even number but with what
     * was explained in the class it was clarified that actually it meant to say count of the characters
     *
     * @param test is a list of strings
     */

    public void printListStreamForEachFilters(List<String> test) {
        test.stream()
                .filter(value -> value.charAt(0) == 'A')
                .filter(value -> value.length() < 5)
                .filter(value -> value.length() % 2 == 0)
                .forEach(value -> System.out.println(value));
    }
}