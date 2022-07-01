package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.DragDropViewController;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class UploadView extends AnchorPane {

    private Label header;

    private Pane drag_drop_field;

    public UploadView() {
        header = new Label("Eigenen Plan \nhochladen");
        header.getStyleClass().add("header");
        
        drag_drop_field = new DragDropViewController().getRootView();

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
    
    

}
