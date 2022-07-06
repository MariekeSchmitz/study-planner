package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import javafx.scene.layout.AnchorPane;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Visual component for curriculum selection
 */
public class StudyView extends AnchorPane{

    private Label studyLabel;
    private Label campusLabel;

    private Button studyViewButton;
    private ImageView ivIconaddButton;

    public StudyView(String study, String campus) {

        studyViewButton = new Button();
        studyViewButton.getStyleClass().add("studyViewButton");

        studyLabel = new Label(study);
        studyLabel.getStyleClass().add("studyLabel1");

        campusLabel = new Label(campus);
        campusLabel.getStyleClass().add("campusLabel1");

		ivIconaddButton = new ImageView(new Image(File.separator+"images" + File.separator +"pfeilgruen.png"));
		ivIconaddButton.setFitHeight(21);
		ivIconaddButton.setFitWidth(40);

        AnchorPane.setLeftAnchor(studyLabel, 10.0);
        AnchorPane.setTopAnchor(studyLabel, 10.0);

        AnchorPane.setLeftAnchor(campusLabel, 10.0);
        AnchorPane.setTopAnchor(campusLabel, 40.0);

        AnchorPane.setLeftAnchor(ivIconaddButton, 270.0);
        AnchorPane.setTopAnchor(ivIconaddButton, 27.0);
        AnchorPane.setBottomAnchor(ivIconaddButton, 27.0);

        AnchorPane.setLeftAnchor(studyViewButton, 0.0);
        AnchorPane.setTopAnchor(studyViewButton, 0.0);
        AnchorPane.setBottomAnchor(studyViewButton, 0.0);
        AnchorPane.setRightAnchor(studyViewButton, 0.0);
        
        this.setId("StudyHover");
        this.getChildren().addAll(studyLabel, campusLabel, ivIconaddButton, studyViewButton);
        this.setPrefSize(1000, 300);
        this.setMaxHeight(75);
        this.setMaxWidth(325);
    }

	public Button getStudyViewButton() {
		return studyViewButton;
	}

	public void setStudyViewButton(Button studyViewButton) {
		this.studyViewButton = studyViewButton;
	}
    
    
    
}
