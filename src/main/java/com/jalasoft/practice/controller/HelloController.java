/**
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package com.jalasoft.practice.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Handles the Post request to the application, receive 4 parameters and either say hello, or copy a file or both
 * depending if the parameters has values or not
 *
 * @author Rodney Maida
 * @version 1.0
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    /**
     * Receive 4 parameters (1) a String parameter called name, (2) a String Parameter called lastName,
     * if these two Parameters are empty, it prints pu "Hello Work", if any of those parameters or both
     * parameters have a value prints out "Hello" + the value of those parameters
     * (3) a String parameter called destinyPath which specify where the file received will be saved,
     * if the destinyPath parameter is empty it saves the file by default at "inputFiles\", if it has a value
     * verify that the path provided is a valid one and if it is saves the file there
     * (4) a MultipartFile parameter called file, if a file is provided is saved to the location
     * specified in the destinyPath parameter, if the file parameter is empty jsut ignore this and do the Hello
     * part specified on the name and lastName parameters
     *
     * @author Rodney Maida
     * @version 1.0
     */

    @PostMapping
    public String practiceOne(@RequestParam(value = "name") String name,
                           @RequestParam(value = "lastName") String lastName,
                           @RequestParam(value = "destinyPath") String destinyPath,
                           @RequestParam(value = "file") MultipartFile file) throws IOException {

        copyFile(destinyPath, file);

        if (name.isEmpty() && lastName.isEmpty()) {
            return sayHello();
        } else {
            return sayHello(name, lastName);
        }
    }

    private String sayHello(){
        return "Hello Work";
    }

    private String sayHello(String name, String lastName){
        return "Hello " + name + " " + lastName;
    }

    private void copyFile(String destinyPath, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            try (InputStream inputStream = file.getInputStream()) {

                String filename = StringUtils.cleanPath(file.getOriginalFilename());

                if (destinyPath.isEmpty()) {
                    destinyPath = "inputFiles\\";
                }

                if (destinyPath.contains("..")) {
                    System.out.println("Relative paths outside current directory are not supported");
                }

                Files.copy(inputStream,
                        Paths.get(completePath(destinyPath) + filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } else {
            System.out.println("Please select a file to copy");
        }
    }

    private String completePath(String path) {
        char lastChar = path.charAt(path.length() - 1);
        if (lastChar == '\\') {
            return path;
        }
        return path + "\\";
    }
}