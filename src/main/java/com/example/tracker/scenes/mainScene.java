package com.example.tracker.scenes;

import com.example.tracker.constants;
import com.example.tracker.panes.mainPane;
import javafx.scene.Scene;

public class mainScene extends Scene {
    public mainScene() {
        super(new mainPane(), constants.height, constants.width);
    }

}