package org.example.model;

import java.util.HashMap;

public class DictionaryModel {
    private HashMap<String, String> dictionary = new HashMap<>();

    public DictionaryModel() {}

    public void addWord (String word, String meaning) throws Exception {
        if (dictionary.containsKey(word)) {
            System.err.println(word + " is already registered.");
            Exception alreadyAddedException = new Exception("Error: Word already included");
            throw alreadyAddedException;   
        }
        dictionary.put(word, meaning);
        System.out.println(word + " was successfully added");
    }

    public void removeWord (String word) throws Exception {
        if (dictionary.containsKey(word)) {
            System.err.println(word + " is not registered.");
            Exception wordNonExistentException = new Exception("Error: Word not in dictionary");
            throw wordNonExistentException;
        }
        dictionary.remove(word);
        System.out.println(word + " was successfully removed");
    }

    public String searchWordMeaning (String word) throws Exception {
        if (word.isEmpty()) {
            System.err.println("Empty field: Type a word.");
            Exception emptyFieldException = new Exception("Error: empty field.");
            throw emptyFieldException;

        }
        if (!dictionary.containsKey(word)) {
            System.err.println(word + " not found");
            Exception wordNotFound = new Exception("Error: word not found.");
            throw wordNotFound;
        }
        return dictionary.get(word);
    }

}
