package com.example.tracker.panes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class loginPane extends BorderPane {
    public loginPane() {
        // Create the menu bar
        MenuBar menu = new MenuBar();
        Menu credits = new Menu("Credits");
        MenuItem exit = new MenuItem("Exit");

        credits.getItems().add(exit);
        menu.getMenus().add(credits);

        // Set the menu bar at the top of the BorderPane
        this.setTop(menu);

        // Create a TabPane with tabs
        TabPane tabPane = new TabPane();

        Tab addItem = new Tab("Add Item");
        addItem.setClosable(false);

        Tab removeItem = new Tab("Remove Item");
        removeItem.setClosable(false);

        tabPane.getTabs().addAll(addItem, removeItem);

        // Set the TabPane in the center of the BorderPane
        this.setCenter(tabPane);
    }
}
