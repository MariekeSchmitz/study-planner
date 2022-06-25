package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ModuleInformationView extends AnchorPane{
    private Label testLabel;

    private Label header;
    private Label kategorie;
    private Label CP;

    private Pane warnhinweise;

    private Label moduldescription;
    private Text modultext;

    private Button backButton;

    public ModuleInformationView() {
        testLabel = new Label("ModuleInformationView");
        
        backButton = new Button("back");
        this.getChildren().addAll(testLabel, backButton);

        
    }

}
