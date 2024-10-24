package com.example.tracker;

import com.example.tracker.scenes.introScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class budgetTracker extends Application {
    public static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        mainStage.setTitle("Budget Tracker");
        mainStage.setScene(new introScene());
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}