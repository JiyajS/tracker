//package com.example.tracker.panes;
//
//
//import static com.example.tracker.database.Const.*;
//import static com.example.tracker.database.DBConst.*;
//
//import com.example.tracker.budgetTracker;
//import com.example.tracker.database.Database;
//import com.example.tracker.scenes.userFormScene;
//import javafx.scene.layout.BorderPane;
//import javafx.animation.FadeTransition;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.*;
//import javafx.scene.paint.Color;
//import javafx.util.Duration;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class loginPane extends BorderPane {
//    public loginPane(){
//
//
//        VBox loginForm = new VBox();
//        loginForm.setSpacing(14);
//        loginForm.setPadding(new Insets(20));
//        loginForm.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.4), new CornerRadii(16), Insets.EMPTY)));
//        loginForm.setAlignment(Pos.CENTER);
//        loginForm.setMaxSize(430, 400);
//
//        TextField usernameField = new TextField();
//        usernameField.setPromptText("Username");
//        usernameField.setStyle("-fx-font-size: 17px;");
//
//
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPromptText("Password");
//        passwordField.setStyle("-fx-font-size: 17px;");
//
//        TextField databseNameField = new TextField();
//
//
//
//
//
//        loginForm.getChildren().addAll(usernameField, passwordField, databseNameField);
//
//        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), loginForm);
//        fadeTransition.setFromValue(0.0);
//        fadeTransition.setToValue(1.0);
//        fadeTransition.play();
//
//        Button login = new Button("login");
//        login.setStyle("-fx-background-color: #ff6347; -fx-text-fill: black; -fx-font-size: 16px;");
//        loginForm.getChildren().add(login);
//        login.setOnAction(e -> {
//            DB_USER = usernameField.getText();
//            DB_PASS = passwordField.getText();
//            DB_NAME = databseNameField.getText();
//
//            if (connectToDatabase()) {
//                budgetTracker.mainStage.setScene(new userFormScene());
//            } else {
//                System.err.println("Invalid credentials. Please try again.");
//            }
//        });
//
//        this.setCenter(loginForm);
//    }
//
//    private boolean connectToDatabase() {
//        try {
//            Database db = Database.getInstance();
//            if (db != null) {
//                System.out.println("Database connected successfully.");
//                return true;
//            }
//        } catch (Exception e) {
//            System.err.println("Database connection failed: ");
//        }
//        return false;
//    }
//    private void saveCredentials(String username, String password, String databaseName) {
//        Properties properties = new Properties();
//        try (FileOutputStream fos = new FileOutputStream("credits.txt")) {
//            properties.setProperty("username", username);
//            properties.setProperty("password", password);
//            properties.setProperty("database", databaseName);
//            properties.store(fos, "User credentials");
//        } catch (IOException e) {
//            System.err.println("Error saving credentials: " + e.getMessage());
//        }
//    }
//
//    private void loadSavedCredentials(TextField usernameField, PasswordField passwordField, TextField databaseNameField) {
//        Properties properties = new Properties();
//        try (FileInputStream fis = new FileInputStream("credits.txt")) {
//            properties.load(fis);
//            String savedUsername = properties.getProperty("username");
//            String savedPassword = properties.getProperty("password");
//            String savedDatabase = properties.getProperty("database");
//
//            // If credentials exist, auto-fill the fields
//            if (savedUsername != null && savedPassword != null && savedDatabase != null) {
//                usernameField.setText(savedUsername);
//                passwordField.setText(savedPassword);
//                databaseNameField.setText(savedDatabase);
//
//                // Skip login and directly go to the next page
//                if (connectToDatabase()) {
//                    budgetTracker.mainStage.setScene(new userFormScene());
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error loading saved credentials: " + e.getMessage());
//        }
//    }
//}

package com.example.tracker.panes;

import static com.example.tracker.database.Const.*;
import static com.example.tracker.database.DBConst.*;

import com.example.tracker.budgetTracker;
import com.example.tracker.database.Database;
import com.example.tracker.scenes.userFormScene;
import javafx.scene.layout.BorderPane;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class loginPane extends BorderPane {
    private static final String CREDENTIALS_FILE = "config.properties";

    public loginPane() {
        VBox loginForm = new VBox();
        loginForm.setSpacing(14);
        loginForm.setPadding(new Insets(20));
        loginForm.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.4), new CornerRadii(16), Insets.EMPTY)));
        loginForm.setAlignment(Pos.CENTER);
        loginForm.setMaxSize(430, 400);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setStyle("-fx-font-size: 17px;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-font-size: 17px;");

        TextField databaseNameField = new TextField();

        // Check if credentials are saved and fill them automatically
        loadSavedCredentials(usernameField, passwordField, databaseNameField);

        loginForm.getChildren().addAll(usernameField, passwordField, databaseNameField);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), loginForm);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);
        fadeTransition.play();

        Button login = new Button("Login");
        login.setStyle("-fx-background-color: #ff6347; -fx-text-fill: black; -fx-font-size: 16px;");
        loginForm.getChildren().add(login);
        login.setOnAction(e -> {
            DB_USER = usernameField.getText();
            DB_PASS = passwordField.getText();
            DB_NAME = databaseNameField.getText();

            // Save credentials for future logins
            saveCredentials(DB_USER, DB_PASS, DB_NAME);

            if (connectToDatabase()) {
                budgetTracker.mainStage.setScene(new userFormScene());
            } else {
                System.err.println("Invalid credentials. Please try again.");
            }
        });

        this.setCenter(loginForm);
    }

    private boolean connectToDatabase() {
        try {
            Database db = Database.getInstance();
            if (db != null) {
                System.out.println("Database connected successfully.");
                return true;
            }
        } catch (Exception e) {
            System.err.println("Database connection failed: ");
        }
        return false;
    }

    private void saveCredentials(String username, String password, String databaseName) {
        Properties properties = new Properties();
        try (FileOutputStream fos = new FileOutputStream(CREDENTIALS_FILE)) {
            properties.setProperty("username", username);
            properties.setProperty("password", password);
            properties.setProperty("database", databaseName);
            properties.store(fos, "User credentials");
        } catch (IOException e) {
            System.err.println("Error saving credentials: " + e.getMessage());
        }
    }

    private void loadSavedCredentials(TextField usernameField, PasswordField passwordField, TextField databaseNameField) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CREDENTIALS_FILE)) {
            properties.load(fis);
            String savedUsername = properties.getProperty("username");
            String savedPassword = properties.getProperty("password");
            String savedDatabase = properties.getProperty("database");

            // If credentials exist, auto-fill the fields
            if (savedUsername != null && savedPassword != null && savedDatabase != null) {
                usernameField.setText(savedUsername);
                passwordField.setText(savedPassword);
                databaseNameField.setText(savedDatabase);

                // Skip login and directly go to the next page
                if (connectToDatabase()) {
                    budgetTracker.mainStage.setScene(new userFormScene());
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading saved credentials: " + e.getMessage());
        }
    }
}
