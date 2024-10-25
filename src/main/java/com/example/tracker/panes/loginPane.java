package com.example.tracker.panes;

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class loginPane extends BorderPane {
    public loginPane(){


            VBox loginForm = new VBox();
            loginForm.setSpacing(14);
            loginForm.setPadding(new Insets(20));
            loginForm.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.4), new CornerRadii(16), Insets.EMPTY)));
            loginForm.setAlignment(Pos.CENTER);
            loginForm.setMaxSize(430, 400);

            TextField usernameField = new TextField();
            usernameField.setPromptText("Username");

            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("Password");

            loginForm.getChildren().addAll(usernameField, passwordField);

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), loginForm);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.play();
            Button login = new Button("login");
            loginForm.getChildren().add(login);g
            this.setCenter(loginForm);


    }
}
