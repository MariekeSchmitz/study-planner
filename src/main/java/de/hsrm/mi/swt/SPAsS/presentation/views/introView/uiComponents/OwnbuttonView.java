/**
 * 
 */
package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/*
 * Visual Component for Ownbutton
 */
public class OwnbuttonView extends AnchorPane{
	
	private HBox hbox;
	
    private Label headerLabel;

    private Button button;
    private ImageView ivIconaddButton;

	public OwnbuttonView() {
		hbox = new HBox();
		
        button = new Button();
        button.getStyleClass().add("ownButton");

        headerLabel = new Label("Eigenen Plan importieren");
        headerLabel.setWrapText(true);
        headerLabel.getStyleClass().add("studyLabel1");
        
		ivIconaddButton = new ImageView(new Image(File.separator+"images" + File.separator +"pfeilgruen.png"));
		ivIconaddButton.setFitHeight(21);
		ivIconaddButton.setFitWidth(40);
        
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.getChildren().addAll(ivIconaddButton, headerLabel, button);
		hbox.setPrefSize(1000, 300);
		hbox.setMaxHeight(75);
		hbox.setMaxWidth(250);
		hbox.setSpacing(20);
		hbox.setPadding(new Insets(0, 0, 0, 20));
		this.getStyleClass().add("ownButton");
		
        AnchorPane.setTopAnchor(hbox, 0.0); 
		AnchorPane.setLeftAnchor(hbox, 0.0);
		AnchorPane.setRightAnchor(hbox, 0.0);
        AnchorPane.setBottomAnchor(hbox, 0.0);
        
        AnchorPane.setTopAnchor(button, 0.0); 
		AnchorPane.setLeftAnchor(button, 0.0);
		AnchorPane.setRightAnchor(button, 0.0);
        AnchorPane.setBottomAnchor(button, 0.0);
        
		this.getChildren().addAll(hbox, button);

	}

	public Button getButton() {
		return button;
	}

}
