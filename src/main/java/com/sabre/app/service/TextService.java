package com.sabre.app.service;

import com.sabre.app.util.TextUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextService {

    String removePunctuationMarks(String sentence) {
        if (StringUtils.isNotEmpty(sentence)) {
            return sentence.replaceAll(TextUtil.PUNCTUATION_REGEX, TextUtil.EMPTY_STRING);
        } else {
            return TextUtil.EMPTY_STRING;
        }
    }

    String removeNonLetterChars(String sentence) {
        if (StringUtils.isNotEmpty(sentence)) {
            return sentence.replaceAll(TextUtil.NON_LETTERS_REGEX, TextUtil.EMPTY_STRING);
        } else {
            return TextUtil.EMPTY_STRING;
        }
    }

    List<String> getUniqueLettersListSorted(String sentence) {
        if (StringUtils.isNotEmpty(sentence)) {
            return sentence
                    .chars()
                    .filter(s -> ((char) s != TextUtil.SPACE_CHAR))
                    .distinct()
                    .mapToObj(s -> String.valueOf((char) s))
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    String[] splitBySpace(String sentence) {
        if (StringUtils.isNotEmpty(sentence)) {
            return sentence.split(TextUtil.SPACE_SEPARATOR);
        } else {
            return new String[]{};
        }
    }

    Map<String, Set<String>> getMapWithKeys(List<String> lettersToKeys) {
        if (lettersToKeys != null && lettersToKeys.size() > 0) {
            return lettersToKeys
                    .stream()
                    .collect(Collectors.toMap(Function.identity(), s -> new HashSet<>()));
        } else {
            return new HashMap<>();
        }
    }

    void mapWordBasedOnLetter(String[] words, List<String> letters, Map<String, Set<String>> map) {
        for (String s : words) {
            for (String value : letters) {
                if (s.contains(value)) {
                    map.get(value).add(s);
                }
            }
        }
    }
}
