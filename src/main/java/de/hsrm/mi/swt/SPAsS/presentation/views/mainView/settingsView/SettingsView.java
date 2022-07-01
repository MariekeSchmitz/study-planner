package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class SettingsView extends AnchorPane {

    private Label header;

    private Button backButton;


    public SettingsView() {        
        header = new Label("Modulname");
		header.getStyleClass().add("ModuleHeader");

        backButton = new Button("back");
		backButton.getStyleClass().add("backbutton");
		backButton.setPrefSize(100, 100);
        backButton.setMaxSize(50, 50);

        AnchorPane.setTopAnchor(backButton, 30.0);
        AnchorPane.setRightAnchor(backButton, 50.0);

        AnchorPane.setTopAnchor(header, 75.0);
        AnchorPane.setLeftAnchor(header, 160.0);
		AnchorPane.setRightAnchor(header, 150.0);
		header.setMaxWidth(300);

        this.getChildren().addAll(header, backButton);
        this.getStylesheets().add(getClass().getResource("/css/moduleInformationView.css").toExternalForm());
        this.setStyle( "-fx-background-color:rgb(255,255,255)");	
		this.getStyleClass().add("test-border-red");
        this.setMaxWidth(675);
    }


    public Label getHeader() {
        return header;
    }


    public Button getBackButton() {
        return backButton;
    }
    
}
