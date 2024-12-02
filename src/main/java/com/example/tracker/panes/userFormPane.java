package com.example.tracker.panes;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class userFormPane extends BorderPane { // Class name should follow Pascal case convention
    public userFormPane() {
        Label idLabel = new Label("ID:");
        TextField idField = new TextField();

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label dateLabel = new Label("Date:");
        DatePicker datePicker = new DatePicker();

        Label typeOfMoneyLabel = new Label("Type of Money:");
        TextField moneyField = new TextField();

        // Create a button
        Button nextButton = new Button("Next");

        // Layout setup
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 30, 40));
        gridPane.setHgap(20); // Increased spacing for better visibility
        gridPane.setVgap(20);

        // Add components to the grid
        gridPane.add(idLabel, 0, 0);
        gridPane.add(idField, 1, 0);

        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameField, 1, 1);

        gridPane.add(dateLabel, 0, 2);
        gridPane.add(datePicker, 1, 2);

        gridPane.add(typeOfMoneyLabel, 0, 3);
        gridPane.add(moneyField, 1, 3);

        gridPane.add(nextButton, 1, 4);

        // Add the gridPane to the center of the BorderPane
        this.setCenter(gridPane);
    }
}
