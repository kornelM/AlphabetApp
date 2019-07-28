package com.alphabet.app.service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextServiceTest {
    private TextService textService;

    @Before
    public void setup() {
        this.textService = new TextService();
    }

    @Test
    public void removePunctuationMarks_shouldReturnStringWithoutAnyPunctuationMarks() {
        //given
        String text = "Test, test message - with punctuation marks! Maybe?";
        String expectedText = "Test test message  with punctuation marks Maybe";

        //when
        String returnedString = this.textService.removePunctuationMarks(text);

        //then
        assertEquals(returnedString, expectedText);
    }

    @Test
    public void removePunctuationMarks_shouldReturnEmptyStringWhenGivenStringIsNull() {
        //given
        String text = null;
        String expectedText = "";

        //when
        String returnedString = this.textService.removePunctuationMarks(text);

        //then
        assertEquals(returnedString, expectedText);
    }

    @Test
    public void removePunctuationMarks_shouldReturnEmptyStringWhenGivenStringIsEmpty() {
        //given
        String text = "";
        String expectedText = "";

        //when
        String returnedString = this.textService.removePunctuationMarks(text);

        //then
        assertEquals(returnedString, expectedText);
    }

    @Test
    public void removePunctuationMarks_shouldReturnEmptyStringWhenGivenOnlyPunctuationMarks() {
        //given
        String text = ",./<>?;':\"[]{}\\|-=()*&^%$#@!`~";
        String expectedText = "";

        //when
        String returnedString = this.textService.removePunctuationMarks(text);

        //then
        assertEquals(returnedString, expectedText);
    }

    @Test
    public void removeNonLetterChars_shouldReturnStringWithLettersOnly() {
        //given
        String text = "Test1, test2, test3";
        String expectedText = "Test test test";

        //when
        String returnedString = this.textService.removeNonLetterChars(text);

        //then
        assertEquals(returnedString, expectedText);
    }

    @Test
    public void removeNonLetterChars_shouldReturnEmptyStringWhenGivenIsNull() {
        //given
        String text = null;
        String expectedText = "";

        //when
        String returnedString = this.textService.removeNonLetterChars(text);

        //then
        assertEquals(returnedString, expectedText);
    }

    @Test
    public void removeNonLetterChars_shouldReturnEmptyStringWhenGivenIsEmpty() {
        //given
        String text = "";
        String expectedText = "";

        //when
        String returnedString = this.textService.removeNonLetterChars(text);

        //then
        assertEquals(returnedString, expectedText);
    }

    @Test
    public void removeNonLetterChars_shouldReturnEmptyStringWhenOnlyNumbersGiven() {
        //given
        String text = "1234567890";
        String expectedText = "";

        //when
        String returnedString = this.textService.removeNonLetterChars(text);

        //then
        assertEquals(returnedString, expectedText);
    }

    @Test
    public void getUniqueLettersListSorted_shouldReturnListWithUniqueLetters() {
        //given
        String text = "it is test";
        List<String> expectedList = Arrays.asList("e", "i", "s", "t");

        //when
        List<String> returnedList = this.textService.getUniqueLettersListSorted(text);

        //then
        assertEquals(returnedList, expectedList);
    }

    @Test
    public void getUniqueLettersListSorted_shouldReturnListWithUniqueLetters_2() {
        //given
        String text = "a";
        List<String> expectedList = Collections.singletonList("a");

        //when
        List<String> returnedList = this.textService.getUniqueLettersListSorted(text);

        //then
        assertEquals(returnedList, expectedList);
    }

    @Test
    public void getUniqueLettersListSorted_shouldReturnEmptyListWhenGivenStringIsNull() {
        //given
        String text = null;
        List<String> expectedList = new ArrayList<>();

        //when
        List<String> returnedList = this.textService.getUniqueLettersListSorted(text);

        //then
        assertEquals(returnedList, expectedList);
    }

    @Test
    public void getUniqueLettersListSorted_shouldReturnEmptyListWhenGivenStringIsEmpty() {
        //given
        String text = "";
        List<String> expectedList = new ArrayList<>();

        //when
        List<String> returnedList = this.textService.getUniqueLettersListSorted(text);

        //then
        assertEquals(returnedList, expectedList);
    }

    @Test
    public void splitBySpace_shouldReturnArrayWithWordsFromGivenSentence() {
        //given
        String text = "string to split";
        String[] expectedArray = new String[]{"string", "to", "split"};

        //when
        String[] returnedArray = this.textService.splitBySpace(text);

        //then
        assertArrayEquals(returnedArray, expectedArray);
    }

    @Test
    public void splitBySpace_shouldReturnEmptyArrayWhenGivenEmptyString() {
        //given
        String text = "";
        String[] expectedArray = new String[]{};

        //when
        String[] returnedArray = this.textService.splitBySpace(text);

        //then
        assertArrayEquals(returnedArray, expectedArray);
    }

    @Test
    public void splitBySpace_shouldReturnEmptyArrayWhenGivenNull() {
        //given
        String text = null;
        String[] expectedArray = new String[]{};

        //when
        String[] returnedArray = this.textService.splitBySpace(text);

        //then
        assertArrayEquals(returnedArray, expectedArray);
    }

    @Test
    public void getMapWithKeys_shouldReturnMapWithLettersAsKeys() {
        //given
        List<String> letters = Arrays.asList("a", "b", "c");
        Map<String, Set<String>> expectedMap = new HashMap<>();
        expectedMap.put("a", new HashSet<>());
        expectedMap.put("b", new HashSet<>());
        expectedMap.put("c", new HashSet<>());

        //when
        Map<String, Set<String>> returnedMap = this.textService.getMapWithKeys(letters);

        //then
        assertEquals(returnedMap, expectedMap);
    }

    @Test
    public void getMapWithKeys_shouldReturnEmptyMapWhenGivenNull() {
        //given
        List<String> letters = null;
        Map<String, Set<String>> expectedMap = new HashMap<>();

        //when
        Map<String, Set<String>> returnedMap = this.textService.getMapWithKeys(letters);

        //then
        assertEquals(returnedMap, expectedMap);
    }

    @Test
    public void getMapWithKeys_shouldReturnEmptyMapWhenGivenEmptyList() {
        //given
        List<String> letters = new ArrayList<>();
        Map<String, Set<String>> expectedMap = new HashMap<>();

        //when
        Map<String, Set<String>> returnedMap = this.textService.getMapWithKeys(letters);

        //then
        assertEquals(returnedMap, expectedMap);
    }

    @Test
    public void mapWordBasedOnLetter() {
        //given
        String one = "one";
        String two = "two";
        String[] words = new String[]{one, two};
        List<String> letters = Arrays.asList("o", "n", "e", "t", "w");
        Map<String, Set<String>> map = new HashMap<>();
        map.put("o", new HashSet<>());
        map.put("n", new HashSet<>());
        map.put("e", new HashSet<>());
        map.put("t", new HashSet<>());
        map.put("w", new HashSet<>());

        //when
        this.textService.mapWordBasedOnLetter(words, letters, map);
        Set<String> setForOLetter = map.get("o");

        //then
        assertTrue(setForOLetter.contains(one));
        assertTrue(setForOLetter.contains(two));
        assertEquals(5, map.keySet().size());
        map.values().forEach(s -> assertTrue(s.size() > 0));
    }
}
