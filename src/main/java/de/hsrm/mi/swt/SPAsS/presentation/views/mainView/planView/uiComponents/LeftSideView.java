package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.LogoView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
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
    private Button settingsButton;
    private Pane logo;
    
    public LeftSideView() {

        this.setMinWidth(100);
        this.setMaxWidth(100);
        this.getStyleClass().add("left-side-pane");

        redoButton = new Button();
        undoButton = new Button();
        settingsButton = new Button();

        logo = new LogoView(false, 60);
        logo.setMinSize(50,50);

        redoButton.setMinSize(50, 50);
        redoButton.setPadding(new Insets(0, 0, 5, 0));
        redoButton.getStyleClass().add("Button");
        redoButton.setId("redoButton");
        redoButton.setTooltip(new Tooltip("Redo"));

        undoButton.setMinSize(50, 50);
        undoButton.setPadding(new Insets(0, 0, 5, 0));
        undoButton.getStyleClass().add("Button");
        undoButton.setId("undoButton");
        undoButton.setTooltip(new Tooltip("Undo"));

        settingsButton.setMinSize(50, 50);
        settingsButton.setPadding(new Insets(0, 0, 5, 0));
        settingsButton.getStyleClass().add("Button");
        settingsButton.setId("settingsButtonOut");
        settingsButton.setTooltip(new Tooltip("Settings"));

        this.getChildren().addAll(logo, settingsButton, redoButton, undoButton);   
        
        AnchorPane.setBottomAnchor(redoButton, 100.0);
        AnchorPane.setLeftAnchor(redoButton, 25.0);
        AnchorPane.setBottomAnchor(undoButton, 175.0);
        AnchorPane.setLeftAnchor(undoButton, 25.0);
        AnchorPane.setBottomAnchor(settingsButton, 250.0);
        AnchorPane.setLeftAnchor(settingsButton, 25.0);

        AnchorPane.setLeftAnchor(logo, 20.0);
        AnchorPane.setTopAnchor(logo, 20.0);

        this.getStylesheets().add(getClass().getResource("/css/leftSideView.css").toExternalForm());
        this.setId("secondColor");
    }

    public Button getRedoButton() {
        return redoButton;
    }

    public Button getUndoButton() {
        return undoButton;
    }
    
    public Button getSettingsButton() {
        return settingsButton;
    }

    
}
