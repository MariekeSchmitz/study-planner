package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class SettingsView extends BorderPane {

    private Label testLabel;

    public SettingsView() {
        testLabel = new Label("SettingsView");
        this.getChildren().addAll(testLabel);
    }

}
