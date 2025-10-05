package org.example.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.example.controller.CurrencyController;

import java.sql.SQLException;
import java.util.Currency;
import java.util.List;

public class CurrencyView extends Application {

    public void start(Stage window) {
        GridPane layout = new GridPane();

        CurrencyController controller = new CurrencyController();

        TextField fromTextField = new TextField("1");
        TextField toTextField = new TextField();
        
        Label instructions = new Label("Choose the currencies from the choice boxes, and type the value for converting on the leftmost textbox.");
        instructions.setWrapText(true);
        Label convertFrom = new Label("Convert from: ");
        Label convertTo = new Label("Convert to: ");
        Label fromAmount = new Label("This amount: ");
        Label toAmount = new Label("Becomes this amount: ");

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setVisible(false);

        // Populate currenciesList with currencies from the controller.
        ObservableList<Currency> currenciesList = FXCollections.observableArrayList();
        if (!errorLabel.isVisible()) {
            currenciesList.addAll(controller.getCurrencies());
        }


        ChoiceBox<Currency> choiceBox1 = new ChoiceBox<>(currenciesList);
        choiceBox1.setValue(Currency.getInstance("EUR"));

        ChoiceBox<Currency> choiceBox2 = new ChoiceBox<>(currenciesList);
        choiceBox2.setValue(Currency.getInstance("USD"));

        VBox leftColumn = new VBox(10);
        leftColumn.getChildren().addAll(fromAmount, fromTextField, convertFrom, choiceBox1, errorLabel);
        VBox rightColumn = new VBox(10);
        rightColumn.getChildren().addAll(toAmount, toTextField, convertTo, choiceBox2);

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(new EventHandler <ActionEvent> () {
            public void handle (ActionEvent convertEvent) {
                if (fromTextField.getText().isEmpty()) {
                    errorLabel.setText("Field cannot be empty!");
                    errorLabel.setVisible(true);
                    return;
                } else {
                    errorLabel.setVisible(false);
                }
                
                System.out.println("Submitted: " + fromTextField.getText());
                double fromAmount = Double.parseDouble(fromTextField.getText());
                Currency from = choiceBox1.getValue();
                Currency to = choiceBox2.getValue();
                double convertedValue = 0.0;
                if (!errorLabel.isVisible()) {
                    convertedValue = controller.convertAmount(fromAmount, from, to);
                }
                toTextField.setText(String.valueOf(convertedValue));

                controller.addTransaction(from, to, convertedValue);
            }
        });

        Button addCurrencyButton = new Button("Add currency");
        addCurrencyButton.setOnAction(new EventHandler <ActionEvent> () {
            public void handle (ActionEvent addCurrencyEvent) {
                Label currencyNameLabel = new Label("Currency Name: ");
                TextField currencyNameTextField = new TextField("AED");

                Label currencyValueToUSDLabel = new Label("Current Value: ");
                TextField currencyValueToUSDTextField = new TextField("3.6725");

                Stage newStage = new Stage();

                Button addButton = new Button("Add");
                addButton.setOnAction(new EventHandler <ActionEvent> () {
                    public void handle (ActionEvent addEvent) {
                        if (currencyNameTextField.getText().isEmpty()) {
                            errorLabel.setText("Currency name cannot be empty!");
                            errorLabel.setVisible(true);
                            return;
                        } else {
                            errorLabel.setVisible(false);
                        }

                        try {
                            Currency.getInstance(currencyNameTextField.getText());
                        } catch (Exception e) {
                            errorLabel.setText("Currency name must be a valid 3-characters currency code!");
                            errorLabel.setVisible(true);
                            return;
                        }

                        if (currencyValueToUSDTextField.getText().isEmpty()) {
                            errorLabel.setText("Currency value cannot be empty!");
                            errorLabel.setVisible(true);
                            return;
                        } else {
                            errorLabel.setVisible(false);
                        }

                        try {
                            Double currencyValue = Double.parseDouble(currencyValueToUSDTextField.getText());
                        } catch (Exception e) {
                            errorLabel.setText("Currency value must be a valid floating point number!");
                            errorLabel.setVisible(true);
                            return;
                        }

                        controller.addCurrency(currencyNameTextField.getText(), currencyValueToUSDTextField.getText());

                        currenciesList.setAll(controller.getCurrencies());
                        choiceBox1.setValue(Currency.getInstance("EUR"));
                        choiceBox2.setValue(Currency.getInstance("USD"));

                        newStage.close();
                    }
                });

                GridPane currencyNameLayout = new GridPane();
                currencyNameLayout.add(currencyNameLabel, 0, 0);
                currencyNameLayout.add(currencyNameTextField, 0, 1);
                currencyNameLayout.add(currencyValueToUSDLabel, 0, 2);
                currencyNameLayout.add(currencyValueToUSDTextField, 0, 3);
                currencyNameLayout.add(addButton, 0, 4);
                currencyNameLayout.add(errorLabel, 0, 5);

                Scene stageScene = new Scene(currencyNameLayout);
                stageScene.getStylesheets().add("style.css");

                newStage.setScene(stageScene);
                newStage.showAndWait();
            }
        });

        
        layout.setPadding(new Insets(20)); 
        layout.add(instructions, 0, 0, 3, 1);
        GridPane.setMargin(instructions, new Insets(0, 0, 20, 0));
        layout.add(leftColumn, 0, 1);
        layout.add(rightColumn, 2, 1);
        layout.add(convertButton, 0, 2);
        layout.add(addCurrencyButton, 0, 3);
        GridPane.setHalignment(convertButton, HPos.CENTER);
        GridPane.setHalignment(addCurrencyButton, HPos.CENTER);

        Scene view = new Scene(layout);
        view.getStylesheets().add("style.css");
        window.setMinWidth(800);
        window.setMinHeight(400);

        window.setTitle("Currency Converter");
        window.setScene(view);
        window.show();
    }
}
