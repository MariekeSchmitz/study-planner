package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
/**
 * View for importing Plan file
 */
public class UploadView extends AnchorPane {
	
	private Button backButton;

    private Label header;

    private BorderPane drag_drop_field;

    public UploadView() {
    	
		ImageView ivIcon = new ImageView(new Image(File.separator+"images" + File.separator +"X.png"));
		ivIcon.setFitHeight(50);
		ivIcon.setFitWidth(50);
		backButton = new Button();
		backButton.setGraphic(ivIcon);
		backButton.getStyleClass().add("backButton");
    	
        header = new Label("Eigenen Plan \nhochladen");
        header.getStyleClass().add("header");
        
        drag_drop_field = new BorderPane();

        AnchorPane.setTopAnchor(header, 100.0);
        AnchorPane.setLeftAnchor(header, 150.0);
        
        AnchorPane.setTopAnchor(backButton, 30.0);
        AnchorPane.setRightAnchor(backButton, 30.0);

        AnchorPane.setTopAnchor(drag_drop_field, 300.0);
        AnchorPane.setLeftAnchor(drag_drop_field, 200.0);
        AnchorPane.setBottomAnchor(drag_drop_field, 100.0);
        AnchorPane.setRightAnchor(drag_drop_field, 200.0);

        this.getStylesheets().add(getClass().getResource("/css/introView.css").toExternalForm());
        this.setStyle("-fx-background-color: rgb(255,255,255)");
        this.getChildren().addAll(header, drag_drop_field, backButton);
    }

	public Label getHeader() {
		return header;
	}

	public void setHeader(Label header) {
		this.header = header;
	}

	public BorderPane getDrag_drop_field() {
		return drag_drop_field;
	}

	public void setDrag_drop_field(Pane drag_drop_field) {
		this.drag_drop_field.setCenter(drag_drop_field);
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}
    
	
	
	
	
    
    

}
