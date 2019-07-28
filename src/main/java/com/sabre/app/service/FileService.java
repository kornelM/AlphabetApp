package com.sabre.app.service;

import com.sabre.app.util.TextUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FileService {
    private static final Logger log = LogManager.getLogger(FileService.class);
    private static final String OUT_DIR_PATH = "out/";
    private static final String OUT_FILE_NAME = "mapped_letters.txt";

    String getStringFromFileLowerCase(String pathToFile) {
        String stringFromFile = TextUtil.EMPTY_STRING;
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

    void saveToFile(Map<String, Set<String>> map) {
        createDirectory();

        Set<String> keys = map.keySet();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUT_DIR_PATH + OUT_FILE_NAME, false))) {
            for (String k : keys) {
                writer
                        .append(k)
                        .append(": ")
                        .append(map.get(k).stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(TextUtil.COMMA)))
                        .append("\n");
            }
        } catch (IOException e) {
            log.error("Could not write to file " + OUT_DIR_PATH + OUT_FILE_NAME, e);
        }

    }

    private void createDirectory() {
        try {
            if (!new File(OUT_DIR_PATH).exists()) {
                Files.createDirectory(Paths.get(OUT_DIR_PATH));
            }
        } catch (IOException e) {
            log.error("Could not create directory!", e);
        }
    }
}
