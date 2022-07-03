package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StudyView extends AnchorPane{

    private Label studyLabel;
    private Label campusLabel;

    private Button studyViewButton;

    public StudyView(String study, String campus) {

        studyViewButton = new Button();
        studyViewButton.getStyleClass().add("studyViewButton");

        studyLabel = new Label(study);
        studyLabel.getStyleClass().add("studyLabel");

        campusLabel = new Label(campus);
        campusLabel.getStyleClass().add("campusLabel");

        //Test
        Label test = new Label("->");
        test.getStyleClass().add("test");

        AnchorPane.setLeftAnchor(studyLabel, 10.0);
        AnchorPane.setTopAnchor(studyLabel, 10.0);

        AnchorPane.setLeftAnchor(campusLabel, 10.0);
        AnchorPane.setTopAnchor(campusLabel, 40.0);

        AnchorPane.setLeftAnchor(test, 250.0);
        AnchorPane.setTopAnchor(test, 0.0);
        AnchorPane.setBottomAnchor(studyViewButton, 0.0);
        AnchorPane.setRightAnchor(studyViewButton, 0.0);

        AnchorPane.setLeftAnchor(studyViewButton, 0.0);
        AnchorPane.setTopAnchor(studyViewButton, 0.0);
        AnchorPane.setBottomAnchor(studyViewButton, 0.0);
        AnchorPane.setRightAnchor(studyViewButton, 0.0);

        this.getChildren().addAll(studyLabel, campusLabel, test, studyViewButton);
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
