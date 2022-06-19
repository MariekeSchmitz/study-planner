package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.LogoView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class StartView extends AnchorPane {

    private LogoView logo;

    private VBox headerVBox;
    private Label header1;
    private Label header2;
    private Label secondHeader;

    private Button addButton;
    private Button ownPlanButton;

    public StartView() {

        headerVBox = new VBox(10);

        logo = new LogoView();
        header1 = new Label("Willkommen zum");
        header1.getStyleClass().add("header");
        header2 = new Label("Studienverlaufplaner");
        header2.getStyleClass().add("headerOne");

        secondHeader = new Label("Neuen Plan anlegen");
        secondHeader.getStyleClass().add("secondHeader");

        headerVBox.getChildren().addAll(header1, header2);

        addButton = new Button("+");
        addButton.getStyleClass().add("addbutton");
        addButton.setPrefSize(300, 300);
        addButton.setMaxSize(300, 300);

        ownPlanButton = new Button("Eigener Plan \nimportieren");
        ownPlanButton.getStyleClass().add("ownButton");
        ownPlanButton.setPrefSize(300, 300);
        ownPlanButton.setMaxSize(200, 50);
        
    
        AnchorPane.setTopAnchor(logo, 50.0);
        AnchorPane.setLeftAnchor(logo, 50.0);

        AnchorPane.setTopAnchor(headerVBox, 175.0);
        AnchorPane.setLeftAnchor(headerVBox, 300.0);

        AnchorPane.setTopAnchor(secondHeader, 380.0);
        AnchorPane.setLeftAnchor(secondHeader, 300.0);

        AnchorPane.setTopAnchor(addButton, 450.0);
        AnchorPane.setLeftAnchor(addButton, 300.0);

        AnchorPane.setBottomAnchor(ownPlanButton, 50.0);
        AnchorPane.setRightAnchor(ownPlanButton, 50.0);

        this.getStylesheets().add(getClass().getResource("introView.css").toExternalForm());
        this.getChildren().addAll(headerVBox, secondHeader, logo, addButton, ownPlanButton);
    }

}
