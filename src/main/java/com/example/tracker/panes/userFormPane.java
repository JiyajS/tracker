package com.example.tracker.panes;

import com.example.tracker.budgetTracker;
import com.example.tracker.scenes.allocationFormScene;
import com.example.tracker.scenes.loginScene;
import com.example.tracker.scenes.savingFormScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class userFormPane extends BorderPane { // Pascal case for class name
    public userFormPane() {
        // Create labels, fields, and buttons
        Label idLabel = new Label("ID:");
        TextField idField = new TextField();
        idField.setPrefWidth(200); // Increase the size of the text field

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        nameField.setPrefWidth(200); // Increase the size of the text field

        Label dateLabel = new Label("Date:");
        DatePicker datePicker = new DatePicker();
        datePicker.setPrefWidth(200); // Increase the size of the date picker

        Label typeOfMoneyLabel = new Label("Type of Money:");
        TextField moneyField = new TextField();
        moneyField.setPrefWidth(200); // Increase the size of the text field

        // Create the "Next" button
        Button nextButton = new Button("Next");

        // Create the navigation bar with buttons
        Button users = new Button("Users");

        Button allocation = new Button("Allocation");
        allocation.setOnAction(e->
        {
            budgetTracker.mainStage.setScene(new allocationFormScene());});

        Button savings = new Button("Savings");
        savings.setOnAction(e->{
            budgetTracker.mainStage.setScene(new savingFormScene());
        });

        Button logout = new Button("Logout");
        logout.setOnAction(e->{
            budgetTracker.mainStage.setScene(new loginScene());
        });

        HBox navBar = new HBox(20, users, allocation, savings, logout); // 20px gap between buttons
        navBar.setAlignment(Pos.CENTER); // Center the buttons in the HBox

        // Layout setup for the form
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20)); // Padding around the grid
        gridPane.setHgap(20); // Horizontal gap between columns
        gridPane.setVgap(20); // Vertical gap between rows

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

        // Center the GridPane inside the BorderPane
        gridPane.setAlignment(Pos.CENTER);

        // Add the navigation bar to the top of the BorderPane
        this.setTop(navBar);

        // Add the gridPane to the center of the BorderPane
        this.setCenter(gridPane);
    }
}
