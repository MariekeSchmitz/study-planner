package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.DragDropViewController;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class UploadView extends AnchorPane {

    private Label header;

    private BorderPane drag_drop_field;

    public UploadView() {
        header = new Label("Eigenen Plan \nhochladen");
        header.getStyleClass().add("header");
        
        drag_drop_field = new BorderPane();

        AnchorPane.setTopAnchor(header, 100.0);
        AnchorPane.setLeftAnchor(header, 150.0);

        AnchorPane.setTopAnchor(drag_drop_field, 300.0);
        AnchorPane.setLeftAnchor(drag_drop_field, 200.0);
        AnchorPane.setBottomAnchor(drag_drop_field, 100.0);
        AnchorPane.setRightAnchor(drag_drop_field, 200.0);

        this.getStylesheets().add(getClass().getResource("/css/introView.css").toExternalForm());
        this.setStyle("-fx-background-color: rgb(255,255,255)");
        this.getChildren().addAll(header, drag_drop_field);
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
    
	
	
	
	
    
    

}
