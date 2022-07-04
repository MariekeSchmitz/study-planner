package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Left Side of the visual representation of a plan.
 */
public class LeftSideView extends AnchorPane {

    private Button redoButton;
    private Button undoButton;
    private Button saveButton;
    private Button referenceButton;
    private Button settingsButton;
    private Pane logo;
    
    public LeftSideView() {

        this.setMinWidth(75);
        this.setMaxWidth(75);
        this.getStyleClass().add("left-side-pane");

        redoButton = new Button("->");
        undoButton = new Button("<-");
        saveButton = new Button("S");
        referenceButton = new Button("L");
        settingsButton = new Button("E");

        logo = new Pane();
        logo.setMinSize(50,50);
        logo.setStyle("-fx-background-color: darkgrey;");

        redoButton.setMinSize(40, 40);
        undoButton.setMinSize(40, 40);
        undoButton.setPadding(new Insets(0, 0, 5, 0));
        saveButton.setMinSize(40, 40);
        referenceButton.setMinSize(40, 40);
        settingsButton.setMinSize(40, 40);

        this.getChildren().addAll(logo, settingsButton,saveButton, referenceButton, redoButton, undoButton);   
        
        AnchorPane.setBottomAnchor(redoButton, 17.5);
        AnchorPane.setLeftAnchor(redoButton, 17.5);
        AnchorPane.setBottomAnchor(undoButton, 75.0);
        AnchorPane.setLeftAnchor(undoButton, 17.5);
        AnchorPane.setBottomAnchor(saveButton, 167.5);
        AnchorPane.setLeftAnchor(saveButton, 17.5);
        AnchorPane.setBottomAnchor(referenceButton, 225.0);
        AnchorPane.setLeftAnchor(referenceButton, 17.5);

        AnchorPane.setLeftAnchor(settingsButton, 17.5);
        AnchorPane.setTopAnchor(settingsButton, 85.0);
        AnchorPane.setLeftAnchor(logo, 12.5);
        AnchorPane.setTopAnchor(logo, 17.5);

        this.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(0), new Insets(0))));


    }

    public Button getRedoButton() {
        return redoButton;
    }

    public Button getUndoButton() {
        return undoButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getReferenceButton() {
        return referenceButton;
    }

    public Button getSettingsButton() {
        return settingsButton;
    }

    
}
