package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class TopCenterView extends AnchorPane{

    private double height;
    private double average;
    
    private Label header;
    private Label pointAverage;

    private VBox buttonsBox;

    private Button reset;
    private Button clear;


    public TopCenterView(){
        height = 250.0;
        average = 2.3;
        
        header = new Label("Dein Studienplan");
        header.getStyleClass().add("header");

        pointAverage = new Label("Aktueller Notendurchschnitt: " + average);
        pointAverage.getStyleClass().add("pointAverage");

        buttonsBox = new VBox();
        buttonsBox.setSpacing(10);

        reset = new Button("Zurücksetzen");
        reset.setPrefSize(150, 40);
        reset.getStyleClass().add("buttons");

        clear = new Button("Plan leeren");
        clear.setPrefSize(150, 40);
        clear.getStyleClass().add("buttons");

        buttonsBox.getChildren().addAll(reset, clear);

        AnchorPane.setBottomAnchor(buttonsBox, 75.0);
        AnchorPane.setRightAnchor(buttonsBox, 50.0);

        AnchorPane.setTopAnchor(header, 75.0);
        AnchorPane.setLeftAnchor(header, 100.0);

        AnchorPane.setTopAnchor(pointAverage, 150.0);
        AnchorPane.setLeftAnchor(pointAverage, 100.0);

        this.getStyleClass().add("topcenter");

        this.setPrefHeight(height);
        this.getChildren().addAll(header, pointAverage, buttonsBox);
    }
}
