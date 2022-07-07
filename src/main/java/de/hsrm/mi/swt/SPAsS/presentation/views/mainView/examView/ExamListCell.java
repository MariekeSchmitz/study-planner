package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView;

import java.io.File;

import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ExamListCell extends ListCell<ExamModule>{
/**
 * Visual Description of a single Exam-Cell
 */

    private HBox mainPane;
    private VBox vbox;

    private Label header;
    private Label cp;
    
    private ImageView ivIcon;
    private StackPane imagePane;

    public ExamListCell() {
        mainPane = new HBox();
        mainPane.setPrefHeight(30);
        mainPane.setSpacing(10);

        header = new Label("");
        header.getStyleClass().add("examListHeader");
        header.setId("secondColorFont");
        header.setStyle("-fx-font-size: 15px; -fx-font-family: 'Open Sans bold', sans-serif;");


        cp = new Label("");
        cp.getStyleClass().add("examListCp");
        cp.setId("secondColorFont");
 
        vbox = new VBox(header, cp);
        vbox.setAlignment(Pos.CENTER_LEFT);
        vbox.setPadding(new Insets(10, 10, 10, 20));
        
        HBox.setHgrow(vbox, Priority.ALWAYS);
        
        ivIcon = new ImageView(new Image(File.separator+"images" + File.separator +"plusBlack.png"));
        ivIcon.setFitHeight(25);
        ivIcon.setFitWidth(25);
       
        imagePane = new StackPane(ivIcon);
        imagePane.setPadding(new Insets(0,30,0,0));
		
        mainPane.getChildren().addAll(vbox, imagePane);
        mainPane.setAlignment(Pos.CENTER_LEFT);
        mainPane.setSpacing(20);
        mainPane.setPrefWidth(500);
        mainPane.setMaxWidth(500);

        this.getChildren().addAll(mainPane);
        this.setPrefSize(30, 100);
        this.setMaxWidth(500);
        this.setMaxHeight(30);
        this.setStyle("-fx-background-color: transparent;");
        mainPane.getStyleClass().add("listCellExamModule");
        

    }

    @Override
	public void updateItem(ExamModule item, boolean empty) {
		super.updateItem(item, empty);
		
		if(!empty) {
            header.setText(item.getName());
            cp.setText(Integer.toString(item.getCp()) + " CP");
            mainPane.getStyleClass().add("backgroundcenter");
			this.setGraphic(mainPane);
		} else {
			this.setGraphic(null);
		}
	}
}
