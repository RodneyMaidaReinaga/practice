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

@RestController
@RequestMapping("/hello")
public class HelloController {

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
