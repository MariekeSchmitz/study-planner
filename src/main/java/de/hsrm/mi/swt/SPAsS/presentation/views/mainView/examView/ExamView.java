package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView;

import java.io.File;

import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
/**
 * Visualizes all Exams as List
 */
public class ExamView extends AnchorPane{

    private Label header;
    private ListView<ExamModule> listView;

    private Button backbutton; 

    public ExamView() {

		ImageView ivIcon = new ImageView(new Image(File.separator+"images" + File.separator +"X.png"));
		ivIcon.setFitHeight(50);
		ivIcon.setFitWidth(50);
		backbutton = new Button();
		backbutton.setGraphic(ivIcon);
		backbutton.getStyleClass().add("backButton");

        header = new Label("Klausur \nhinzufügen");
        header.getStyleClass().add("headerExamView");

        listView = new ListView<>();

        AnchorPane.setTopAnchor(header, 100.0);
        AnchorPane.setLeftAnchor(header, 80.0);

        AnchorPane.setTopAnchor(backbutton, 30.0);
        AnchorPane.setRightAnchor(backbutton, 30.0);

        AnchorPane.setTopAnchor(listView, 220.0);
        AnchorPane.setLeftAnchor(listView, 80.0);
        AnchorPane.setRightAnchor(listView, 50.0);
        AnchorPane.setBottomAnchor(listView, 0.0);

        this.getStylesheets().add(getClass().getResource("/css/MainView.css").toExternalForm());
        this.getChildren().addAll(header, backbutton, listView);
        this.setMaxWidth(680);
        this.setEffect(new DropShadow(204,0,2, Color.rgb(49, 49, 64)));
        this.setStyle("-fx-background-color:rgb(255,255,255)");	
    }

    public Label getHeader() {
        return header;
    }

    public ListView<ExamModule> getListView() {
        return listView;
    }

	public Button getBackbutton() {
		return backbutton;
	}
    
    

    
}
