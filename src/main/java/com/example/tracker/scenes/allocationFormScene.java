package com.example.tracker.scenes;

import com.example.tracker.constants;
import com.example.tracker.panes.allocationFormPane;
import javafx.scene.Scene;

public class allocationFormScene extends Scene {
    public allocationFormScene() {
        super(new allocationFormPane(), constants.height, constants.width);
    }

}
