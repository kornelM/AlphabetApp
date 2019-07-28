package com.sabre.app.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordService {
    private TextService textService;
    private FileService fileService;

    public WordService() {
        this.textService = new TextService();
        this.fileService = new FileService();
    }

    public void computeFile(String filePath) {
        String textWithoutMarks = textService.removePunctuationMarks(fileService.getStringFromFileLowerCase(filePath));
        List<String> lettersSorted = textService.getUniqueLettersListSorted(textService.removeNonLetterChars(textWithoutMarks));
        Map<String, Set<String>> map = textService.getMapWithKeys(lettersSorted);
        textService.mapWordBasedOnLetter(textService.splitBySpace(textWithoutMarks), lettersSorted, map);

        fileService.saveToFile(map);
    }
}
