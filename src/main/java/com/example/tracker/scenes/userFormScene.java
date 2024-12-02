package com.example.tracker.scenes;

import com.example.tracker.constants;
import com.example.tracker.panes.userFormPane;
import javafx.scene.Scene;

public class userFormScene extends Scene {
    public userFormScene() {
        super(new userFormPane(), constants.height, constants.width);
    }

}