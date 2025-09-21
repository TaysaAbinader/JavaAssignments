package org.example.view;

import org.example.controller.DictionaryController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    public void start (Stage window) {

        DictionaryController controller = new DictionaryController();
        controller.addWordMeaning("apple", "A round fruit that is red, green, or yellow, and sweet to eat.");
        controller.addWordMeaning("book", "A set of pages with writing or pictures, held together in a cover.");
        controller.addWordMeaning("cat", "A small furry animal that people keep as a pet.");
        controller.addWordMeaning("dog", "A friendly animal with four legs, often kept as a pet.");
        controller.addWordMeaning("chair", "A piece of furniture you sit on.");
        controller.addWordMeaning("house", "A building where people live.");
        controller.addWordMeaning("sun", "The big bright star that gives us light and warmth.");
        controller.addWordMeaning("water", "The clear liquid we drink to stay alive.");
        controller.addWordMeaning("ball", "AA round object used in games or sports.");
        controller.addWordMeaning("tree", "A tall plant with a trunk, branches, and leaves.");

        Label meaningLabel = new Label();
        meaningLabel.setWrapText(true);
        
        TextField wordInput = new TextField("Word here...");
        VBox leftColumn = new VBox(10, wordInput, meaningLabel);
        VBox.setVgrow(meaningLabel, Priority.ALWAYS);

        Button searchButton = new Button("Search meaning");
        VBox rightColumn = new VBox(10, searchButton);

        HBox rootLayout = new HBox(20, leftColumn, rightColumn);
        HBox.setHgrow(leftColumn, Priority.ALWAYS);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent searchEvent) {
                String wordMeaning = controller.getWordMeaning(wordInput.getText());
                meaningLabel.setText(wordMeaning);
            }
        });

        Scene view = new Scene(rootLayout);

        window.setMinWidth(400);
        window.setMinHeight(200);

        window.setTitle("Dictionary");
        window.setScene(view);
        window.show();
    }

}
