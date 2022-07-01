package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TitelPlanView extends AnchorPane{

    private Pane platzhalterPane;

    private Label degreeProgramLabel;
    private Label titelLabel;
    private Label institutionLabel;

    private Label lastOpenLabel;

    private Button openPlanButton;

    public TitelPlanView(String titel, String degreeProgram, String institution) {
        
    	openPlanButton = new Button();
    	openPlanButton.getStyleClass().add("studyViewButton");

        titelLabel = new Label(titel);
        titelLabel.getStyleClass().add("campusLabel");
        
        degreeProgramLabel = new Label(degreeProgram);
        degreeProgramLabel.getStyleClass().add("studyLabel");

        institutionLabel = new Label(institution);
        institutionLabel.getStyleClass().add("institution");
        
        lastOpenLabel = new Label("zuletzt geöffnet am 12.12.2012");
        lastOpenLabel.getStyleClass().add("campusLabel");

        //platzhalter
        platzhalterPane = new StackPane();
        Label platzhalter = new Label("Platzhalter");
        platzhalterPane.getChildren().add(platzhalter);
        platzhalterPane.setBackground(new Background(new BackgroundFill(new Color(0.9,0.9,0.9, 0.5), new CornerRadii(0), new Insets(0))));
        platzhalterPane.setPrefSize(200, 200);
        platzhalterPane.setMaxHeight(200);
        platzhalterPane.setMaxWidth(400);

        AnchorPane.setLeftAnchor(titelLabel, 10.0);
        AnchorPane.setBottomAnchor(titelLabel, 90.0);

        AnchorPane.setLeftAnchor(degreeProgramLabel, 10.0);
        AnchorPane.setBottomAnchor(degreeProgramLabel, 50.0);
        
        AnchorPane.setLeftAnchor(institutionLabel, 10.0);
        AnchorPane.setBottomAnchor(institutionLabel, 35.0);

        AnchorPane.setLeftAnchor(lastOpenLabel, 10.0);
        AnchorPane.setBottomAnchor(lastOpenLabel, 10.0);

        AnchorPane.setBottomAnchor(openPlanButton, 0.0);
        AnchorPane.setRightAnchor(openPlanButton, 0.0);

        AnchorPane.setLeftAnchor(openPlanButton, 0.0);
        AnchorPane.setTopAnchor(openPlanButton, 0.0);
        AnchorPane.setBottomAnchor(openPlanButton, 0.0);
        AnchorPane.setRightAnchor(openPlanButton, 0.0);

        AnchorPane.setLeftAnchor(platzhalterPane, 0.0);
        AnchorPane.setBottomAnchor(platzhalterPane, 130.0);
        AnchorPane.setRightAnchor(platzhalterPane, 0.0);
        AnchorPane.setTopAnchor(platzhalterPane, 0.0);


        this.getChildren().addAll(platzhalterPane, degreeProgramLabel, titelLabel, institutionLabel, lastOpenLabel, openPlanButton);
        this.setPrefSize(1000, 300);
        this.setMaxHeight(350);
        this.setMaxWidth(350);
    }

	public Button getChooseCurriculumButton() {
		return openPlanButton;
	}

	public void setChooseCurriculumButton(Button chooseCurriculumButton) {
		this.openPlanButton = chooseCurriculumButton;
	}
    
    
    
}
