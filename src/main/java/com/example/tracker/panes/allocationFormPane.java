package com.example.tracker.panes;

import com.example.tracker.budgetTracker;
import com.example.tracker.scenes.allocationFormScene;
import com.example.tracker.scenes.loginScene;
import com.example.tracker.scenes.savingFormScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class allocationFormPane extends BorderPane {
    public allocationFormPane(){
        Label idLabel = new Label("ID:");
        TextField idField = new TextField();
        idField.setPrefWidth(200); // Increase the size of the text field

        Label rentLabel = new Label("Rent:");
        TextField rentField = new TextField();
        rentField.setPrefWidth(200); // Increase the size of the text field

        Label installmentLabel = new Label("Installment:");
        TextField installmentField = new TextField();
        installmentField.setPrefWidth(200); // Increase the size of the text field

        Label groceryLabel = new Label("Grocery:");
        TextField groceryField = new TextField();
        groceryField.setPrefWidth(200); // Increase the size of the text field

        Label billsLabel = new Label("Bills:");
        TextField billsField = new TextField();
        billsField.setPrefWidth(200); // Increase the size of the text field

        Label othersLabel = new Label("Others:");
        TextField othersField = new TextField();
        othersField.setPrefWidth(200); // Increase the size of the text field

        Label inputAmountLabel = new Label("Input Amount:");
        TextField inputAmountField = new TextField();
        inputAmountField.setPrefWidth(200); // Increase the size of the text field

        // Create the "Next" button
        Button nextButton = new Button("Next");
        nextButton.setOnAction(e->{
            budgetTracker.mainStage.setScene(new savingFormScene());
        });

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

        gridPane.add(rentLabel, 0, 1);
        gridPane.add(rentField, 1, 1);

        gridPane.add(installmentLabel, 0, 2);
        gridPane.add(installmentField, 1, 2);

        gridPane.add(groceryLabel, 0, 3);
        gridPane.add(groceryField, 1, 3);

        gridPane.add(billsLabel, 0, 4);
        gridPane.add(billsField, 1, 4);

        gridPane.add(othersLabel, 0, 5);
        gridPane.add(othersField, 1, 5);

        gridPane.add(inputAmountLabel, 0, 6);
        gridPane.add(inputAmountField, 1, 6);

        gridPane.add(nextButton, 1, 7);

        // Center the GridPane inside the BorderPane
        gridPane.setAlignment(Pos.CENTER);

        // Add the navigation bar to the top of the BorderPane
        this.setTop(navBar);

        // Add the gridPane to the center of the BorderPane
        this.setCenter(gridPane);


    }
}
