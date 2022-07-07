package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Visual Component for Drag and Drop
 */
public class DragDropView extends AnchorPane{
	
	private Button backButton;

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
        drag_drop_label1.setId("mainColorFont");
        drag_drop_label2 = new Label("oder");
        drag_drop_label2.getStyleClass().add("drapdropLabel2");
        drag_drop_label2.setPadding(new Insets(5, 0, 5, 0));

        drag_drop_vbox = new VBox(1, drag_drop_label1, drag_drop_label2, fileOpen);
        drag_drop_vbox.setAlignment(Pos.CENTER);

        AnchorPane.setTopAnchor(drag_drop_vbox, 0.0);
        AnchorPane.setLeftAnchor(drag_drop_vbox, 0.0);
        AnchorPane.setBottomAnchor(drag_drop_vbox, 0.0);
        AnchorPane.setRightAnchor(drag_drop_vbox, 0.0);

        this.getStyleClass().add("dragdropField");
        this.setPadding(new Insets(20));
        this.getChildren().addAll(drag_drop_vbox);
    }

	
    /** 
     * @return Button
     */
    public Button getFileOpen() {
		return fileOpen;
	}

	
    /** 
     * @param fileOpen
     */
    public void setFileOpen(Button fileOpen) {
		this.fileOpen = fileOpen;
	}
    
    
    
}
