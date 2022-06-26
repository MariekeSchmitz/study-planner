package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class TopCenterView extends AnchorPane{

    private double height;
    
    private Label header;
    private Label pointAverage;

    private VBox buttonsBox;

    private Button reset;
    private Button clear;


    public TopCenterView(){
        height = 250.0;
        
        header = new Label("Dein Studienplan");
        header.getStyleClass().add("header");

        pointAverage = new Label("Aktueller Notendurchschnitt:");
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



	public void setHeight(double height) {
		this.height = height;
	}



	public Label getHeader() {
		return header;
	}


	public void setHeader(Label header) {
		this.header = header;
	}


	public Label getPointAverage() {
		return pointAverage;
	}


	public void setPointAverage(Label pointAverage) {
		this.pointAverage = pointAverage;
	}


	public VBox getButtonsBox() {
		return buttonsBox;
	}


	public void setButtonsBox(VBox buttonsBox) {
		this.buttonsBox = buttonsBox;
	}


	public Button getReset() {
		return reset;
	}


	public void setReset(Button reset) {
		this.reset = reset;
	}


	public Button getClear() {
		return clear;
	}


	public void setClear(Button clear) {
		this.clear = clear;
	}
    
    
}
