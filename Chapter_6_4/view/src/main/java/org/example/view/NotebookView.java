package org.example.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class NotebookView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/notebook_view.fxml"));

        Parent root = fxmlLoader.load();
        fxmlLoader.setRoot(root);

        stage.setScene(new Scene(root));
        stage.show();
    }
}
