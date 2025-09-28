package org.example.model;

import java.util.LinkedHashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Notebook {
    private final ObservableMap<String, String> notes =
            FXCollections.observableMap(new LinkedHashMap<>());

    public Notebook () {}

    public ObservableMap<String, String> getNotes() {
        return notes;
    }
    
    public void put(String title, String note) {
        notes.put(title, note);
    }

    public String get(String title) {
        return notes.get(title);
    }

    public void remove(String title) {
        notes.remove(title);
    }

    public void clear() {
        notes.clear();
    }
}
