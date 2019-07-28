package com.sabre.app.service;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class FileServiceTest {
    private static final String DIR_TEST_PATH = "test/";
    private static final String FILE_TEST_NAME = "test.txt";
    private static final String FILE_TEST_TEXT = "This is test message";

    private FileService fileService;

    @Before
    public void setup() throws IOException {
        this.fileService = new FileService();
        Files.createDirectory(Paths.get(DIR_TEST_PATH));
    }


    @After
    public void clean() throws IOException {
        FileUtils.deleteDirectory(new File(DIR_TEST_PATH));
    }

    @Test
    public void shouldReturnTextFromFile() {
        //given
        writeToFile(FILE_TEST_TEXT);

        // when
        String stringFromFile = this.fileService.getStringFromFileLowerCase(DIR_TEST_PATH + FILE_TEST_NAME);

        //then
        assertEquals(stringFromFile, FILE_TEST_TEXT);
    }

    @Test
    public void shouldReturnAnEmptyStringDueToLackOfFile() {
        //given
        String wrongPath = "wrong/path/to/file";
        String expectedString = "";

        //when
        String stringFromFile = this.fileService.getStringFromFileLowerCase(wrongPath);

        //then
        assertEquals(stringFromFile, expectedString);
    }

    @Test
    public void shouldReturnAnEmptyStringDueToEmptyFile() {
        //given
        String wrongPath = "wrong/path/to/file";
        String expectedString = "";
        writeToFile(expectedString);

        //when
        String stringFromFile = this.fileService.getStringFromFileLowerCase(wrongPath);

        //then
        assertEquals(stringFromFile, expectedString);
    }

    private void writeToFile(String fileText) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DIR_TEST_PATH + FILE_TEST_NAME, true))) {
            writer.append(fileText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
