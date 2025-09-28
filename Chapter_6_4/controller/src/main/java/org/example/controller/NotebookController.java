package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import org.example.model.Notebook;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NotebookController {
    Notebook model = new Notebook();
    private final ObservableList<String> titles = FXCollections.observableArrayList();

    @FXML
    public TextField titleField;

    @FXML
    public TextArea contentArea;

    @FXML
    public Button addButton;

    @FXML
    public ListView<String> notesList;

    @FXML
    public TextField noteContent;

    @FXML
    private void initialize() {
        // Bind the titles list to the ListView
        notesList.setItems(titles);

        notesList.getSelectionModel().selectedItemProperty().addListener((_, _, selectedTitle) -> {
            if (selectedTitle == null) {
                noteContent.clear();
            } else {
                String content = model.get(selectedTitle);
                noteContent.setText(content);
            }
        });

        // Keep titles in sync with map changes
        model.getNotes().addListener((MapChangeListener<String, String>) noteChanged -> {
            String key = noteChanged.getKey();
            if (noteChanged.wasAdded()) {
                titles.add(key);
            }
            if (noteChanged.wasRemoved()) {
                titles.remove(key);
            }
        });
    }

    @FXML
    public void handleAdd() {
        String titleFieldString = titleField.getText();
        String noteString = contentArea.getText();

        model.put(titleFieldString, noteString);
    }
    
    @FXML
    public void handleDelete() {
        String selectedTitle = notesList.getSelectionModel().getSelectedItem();
        model.remove(selectedTitle);
    }

    @FXML
    public void handleEdit() {
        String selectedTitle = notesList.getSelectionModel().getSelectedItem();
        String updatedContent = noteContent.getText();
        model.put(selectedTitle, updatedContent);
    }
}
