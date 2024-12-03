package com.example.tracker.scenes;

import com.example.tracker.constants;
import com.example.tracker.panes.savingFormPane;
import javafx.scene.Scene;

public class savingFormScene extends Scene {
    public savingFormScene() {
        super(new savingFormPane(), constants.height, constants.width);
    }

}
