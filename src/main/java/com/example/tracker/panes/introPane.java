package com.example.tracker.panes;

import com.example.tracker.budgetTracker;
import com.example.tracker.scenes.loginScene;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
        Text intro = new Text(350,100,"Keep Track of");
        Text intro2 = new Text(380,150,"Budget");
        Font font = Font.font("Arial", 35);
        intro.setFont(font);
        intro2.setFont(new Font("Arial",45));
        this.getChildren().add(intro);
        this.getChildren().add(intro2);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), intro2);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        fadeTransition.play();

        ImageView img = new ImageView("icons8-budget-64.png");
        img.setX(300);
        img.setY(240);
        img.setFitWidth(100);
        img.setFitHeight(100);
        this.getChildren().add(img);

        ImageView img2 = new ImageView("icon.png");
        img2.setY(220);
        img2.setX(500);
        img2.setFitWidth(150);
        img2.setFitHeight(150);
        this.getChildren().add(img2);

        TranslateTransition image1 = new TranslateTransition();
        image1.setDuration(Duration.seconds(1));
        image1.setToY(0);
        image1.setNode(img);
        image1.setFromY(300);
        image1.setCycleCount(1);
        image1.play();

        TranslateTransition image2 = new TranslateTransition();
        image2.setDuration(Duration.seconds(1));
        image2.setNode(img2);
        image2.setToY(0);
        image2.setFromY(300);
        image2.setCycleCount(1);
        image2.play();

        Button b1 = new Button("Start Tracking");
        this.setBottom(b1);

        b1.setOnMouseClicked(e->{
            budgetTracker.mainStage.setScene(new loginScene());
        });





    }
}
