package com.sabre.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    private static final Logger log = LoggerFactory.getLogger(FileService.class);
    private static final String EMPTY_STRING = "";

    public String getStringFromFile(String pathToFile) {
        String stringFromFile = EMPTY_STRING;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            StringBuilder builder = new StringBuilder();
            String currentLine = reader.readLine();

            while (currentLine != null) {
                builder.append(currentLine);
                currentLine = reader.readLine();
            }
            stringFromFile = builder.toString();
        } catch (IOException e) {
            log.error("Could not read from file " + pathToFile, e);
        }
        return stringFromFile;
    }
}
