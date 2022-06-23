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

    private Label studyLabel;
    private Label titelLabel;
    private Label lastOpenLabel;

    private Button studyViewButton;

    public TitelPlanView(String titel, String study) {
        
        studyViewButton = new Button();
        studyViewButton.getStyleClass().add("studyViewButton");

        studyLabel = new Label(study);
        studyLabel.getStyleClass().add("studyLabel");

        titelLabel = new Label(titel);
        titelLabel.getStyleClass().add("campusLabel");

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

        AnchorPane.setLeftAnchor(studyLabel, 10.0);
        AnchorPane.setBottomAnchor(studyLabel, 50.0);

        AnchorPane.setLeftAnchor(lastOpenLabel, 10.0);
        AnchorPane.setBottomAnchor(lastOpenLabel, 10.0);

        AnchorPane.setBottomAnchor(studyViewButton, 0.0);
        AnchorPane.setRightAnchor(studyViewButton, 0.0);

        AnchorPane.setLeftAnchor(studyViewButton, 0.0);
        AnchorPane.setTopAnchor(studyViewButton, 0.0);
        AnchorPane.setBottomAnchor(studyViewButton, 0.0);
        AnchorPane.setRightAnchor(studyViewButton, 0.0);

        AnchorPane.setLeftAnchor(platzhalterPane, 0.0);
        AnchorPane.setBottomAnchor(platzhalterPane, 130.0);
        AnchorPane.setRightAnchor(platzhalterPane, 0.0);
        AnchorPane.setTopAnchor(platzhalterPane, 0.0);


        this.getChildren().addAll(platzhalterPane, studyLabel, titelLabel, lastOpenLabel, studyViewButton);
        this.setPrefSize(1000, 300);
        this.setMaxHeight(350);
        this.setMaxWidth(350);
    }
    
}
