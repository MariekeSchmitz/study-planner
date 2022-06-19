package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class UploadView extends BorderPane {

    private Label testLabel;

    public UploadView() {
        testLabel = new Label("StartView");
        this.setCenter(testLabel);
    }

}
