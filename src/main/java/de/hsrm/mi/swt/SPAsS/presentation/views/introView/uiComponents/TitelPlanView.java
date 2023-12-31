package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
/**
 * Visual Component for Plan Selection if previously saved plans are available
 */
public class TitelPlanView extends AnchorPane{

    private Pane imagePane;
    private ImageView image;

    private Label degreeProgramLabel;
    private Label titelLabel;
    private Label institutionLabel;

    private Button openPlanButton;

    public TitelPlanView(String titel, String degreeProgram, String institution) {
        
    	openPlanButton = new Button();
    	openPlanButton.getStyleClass().add("studyViewButton");

        titelLabel = new Label(titel);
        titelLabel.getStyleClass().add("campusLabel");
        titelLabel.setId("mainColorFont");
        
        degreeProgramLabel = new Label(degreeProgram);
        degreeProgramLabel.getStyleClass().add("studyLabel");

        institutionLabel = new Label(institution);
        institutionLabel.getStyleClass().add("studyLabel");

        imagePane = new StackPane();
        image = new ImageView(new Image(File.separator+"images" + File.separator +"kacheln.png"));
        image.setFitHeight(90);
    	image.setFitWidth(180);
    	image.setOpacity(0.5);
        imagePane.getChildren().add(image);
        imagePane.setId("mainColor");
        imagePane.setPrefSize(200, 200);
        imagePane.setMaxHeight(200);
        imagePane.setMaxWidth(400);

        AnchorPane.setLeftAnchor(titelLabel, 0.0);
        AnchorPane.setBottomAnchor(titelLabel, 80.0);

        AnchorPane.setLeftAnchor(degreeProgramLabel, 0.0);
        AnchorPane.setBottomAnchor(degreeProgramLabel, 45.0);
        
        AnchorPane.setLeftAnchor(institutionLabel, 0.0);
        AnchorPane.setBottomAnchor(institutionLabel, 15.0);

        AnchorPane.setBottomAnchor(openPlanButton, 0.0);
        AnchorPane.setRightAnchor(openPlanButton, 0.0);

        AnchorPane.setLeftAnchor(openPlanButton, 0.0);
        AnchorPane.setTopAnchor(openPlanButton, 0.0);
        AnchorPane.setBottomAnchor(openPlanButton, 0.0);
        AnchorPane.setRightAnchor(openPlanButton, 0.0);

        AnchorPane.setLeftAnchor(imagePane, 0.0);
        AnchorPane.setBottomAnchor(imagePane, 130.0);
        AnchorPane.setRightAnchor(imagePane, 0.0);
        AnchorPane.setTopAnchor(imagePane, 0.0);

        this.setId("StudyHover");
        this.getChildren().addAll(imagePane, degreeProgramLabel, titelLabel, institutionLabel, openPlanButton);
        this.setPrefSize(1000, 300);
        this.setMaxHeight(400);
        this.setMaxWidth(350);
    }

	public Button getChooseCurriculumButton() {
		return openPlanButton;
	}

	public void setChooseCurriculumButton(Button chooseCurriculumButton) {
		this.openPlanButton = chooseCurriculumButton;
	}
    
    
    
}
