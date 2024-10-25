package com.example.tracker.panes;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class introPane extends BorderPane {
    public introPane(){
        Text intro = new Text("Keep Track of");
        Font font = Font.font("New Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 35);
        intro.setFont(font);
        this.setTop(intro);

        VBox title = new VBox(intro);
        title.setAlignment(Pos.CENTER);
        title.setPrefHeight(100);

        this.getChildren().add(title);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), intro);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        fadeTransition.play();


    }
}
