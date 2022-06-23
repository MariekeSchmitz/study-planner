package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class ExamView extends AnchorPane{

    private Label header;
    private ListView<String> listView;

    private Button backbutton; 

    public ExamView() {

        backbutton = new Button("->");
        backbutton.setPrefSize(100, 100);
        backbutton.setMaxSize(50, 50);
        backbutton.getStyleClass().add("backbutton");

        header = new Label("Klausur \nhinzufügen");
        header.getStyleClass().add("header");

        listView = new ListView<>();

        AnchorPane.setTopAnchor(header, 50.0);
        AnchorPane.setLeftAnchor(header, 50.0);

        AnchorPane.setTopAnchor(backbutton, 30.0);
        AnchorPane.setRightAnchor(backbutton, 50.0);

        AnchorPane.setTopAnchor(listView, 200.0);
        AnchorPane.setLeftAnchor(listView, 50.0);
        AnchorPane.setRightAnchor(listView, 50.0);
        AnchorPane.setBottomAnchor(listView, 50.0);

        this.getStylesheets().add(getClass().getResource("MainView.css").toExternalForm());
        this.getChildren().addAll(header, backbutton, listView);
        this.getStyleClass().add("test-border-red");
        this.setMaxWidth(500);
    }

    public Label getHeader() {
        return header;
    }

    public ListView<String> getListView() {
        return listView;
    }

    
}
