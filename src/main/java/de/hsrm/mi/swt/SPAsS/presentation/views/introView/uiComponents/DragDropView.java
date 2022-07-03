package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class DragDropView extends AnchorPane{

    private VBox drag_drop_vbox;
    private Button fileOpen;
    private Label drag_drop_label1;
    private Label drag_drop_label2;

    public DragDropView() {

        fileOpen = new Button("Datei wählen");
        fileOpen.setPrefSize(200, 50);
        fileOpen.setMaxSize(200, 50);
        fileOpen.getStyleClass().add("fileOpenButton");
        drag_drop_label1 = new Label("Drag & Drop");
        drag_drop_label1.getStyleClass().add("drapdropLabel1");
        drag_drop_label2 = new Label("oder");

        drag_drop_vbox = new VBox(10, drag_drop_label1, drag_drop_label2, fileOpen);
        drag_drop_vbox.setAlignment(Pos.CENTER);

        AnchorPane.setTopAnchor(drag_drop_vbox, 0.0);
        AnchorPane.setLeftAnchor(drag_drop_vbox, 0.0);
        AnchorPane.setBottomAnchor(drag_drop_vbox, 0.0);
        AnchorPane.setRightAnchor(drag_drop_vbox, 0.0);

        this.getStyleClass().add("dragdropField");
        this.getChildren().add(drag_drop_vbox);
    }

	public Button getFileOpen() {
		return fileOpen;
	}

	public void setFileOpen(Button fileOpen) {
		this.fileOpen = fileOpen;
	}
    
    
    
}
