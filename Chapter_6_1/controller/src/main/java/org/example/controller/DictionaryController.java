package org.example.controller;

import org.example.model.DictionaryModel;

public class DictionaryController {
    private DictionaryModel dictionaryModel = new DictionaryModel();

    public DictionaryController() {}

    public String getWordMeaning (String word) {
        String wordMeaning = new String();
        try {
            wordMeaning = dictionaryModel.searchWordMeaning(word);
        } catch (Exception e) {
            wordMeaning = e.toString();
        }
        return wordMeaning;
    }

    public void addWordMeaning (String word, String meaning) {
        try {
            dictionaryModel.addWord(word, meaning);
        } catch (Exception alreadyAddException) {
            System.err.println(alreadyAddException);
        }
    }

    public void removeWordMeaning (String word) {
        try {
            dictionaryModel.removeWord(word);
        } catch (Exception wordNonExistentException) {
            System.err.println(wordNonExistentException);
        }
    }

}
