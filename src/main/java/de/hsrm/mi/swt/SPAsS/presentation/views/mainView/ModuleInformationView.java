package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ModuleInformationView extends BorderPane{
    private Label testLabel;

    public ModuleInformationView() {
        testLabel = new Label("ModuleInformationView");
        this.getChildren().add(testLabel);
    }

}
