package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
/**
 * Visual Component for Plan Selection if previously saved plans are available
 */
public class TitelPlanView extends AnchorPane{

    private Pane imagePane;
    private ImageView image;

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

        imagePane = new StackPane();
        image = new ImageView("/images/Kacheln.png");
        image.setFitHeight(100);
    	image.setFitWidth(200);
    	image.setOpacity(0.5);
        imagePane.getChildren().add(image);
        imagePane.setId("mainColor");
        imagePane.setPrefSize(200, 200);
        imagePane.setMaxHeight(200);
        imagePane.setMaxWidth(400);

        AnchorPane.setLeftAnchor(titelLabel, 0.0);
        AnchorPane.setBottomAnchor(titelLabel, 90.0);

        AnchorPane.setLeftAnchor(degreeProgramLabel, 0.0);
        AnchorPane.setBottomAnchor(degreeProgramLabel, 50.0);
        
        AnchorPane.setLeftAnchor(institutionLabel, 0.0);
        AnchorPane.setBottomAnchor(institutionLabel, 35.0);

        AnchorPane.setLeftAnchor(lastOpenLabel, 0.0);
        AnchorPane.setBottomAnchor(lastOpenLabel, 0.0);

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


        this.getChildren().addAll(imagePane, degreeProgramLabel, titelLabel, institutionLabel, lastOpenLabel, openPlanButton);
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
