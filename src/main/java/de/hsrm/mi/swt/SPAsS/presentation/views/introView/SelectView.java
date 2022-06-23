package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.DragDropViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SelectView extends AnchorPane{
    
    private Pane backgroundPane;

    private Label header;
    private Label header2;

    private Pane drag_drop_field;

    private ScrollPane scrollPane;
	private HBox hbox;

    public SelectView() {
        header = new Label("Eigenen Plan \nhochladen");
        header.getStyleClass().add("header");

        Pane platzhalter = new Pane();
        platzhalter.setPrefSize(1000, 300);
        platzhalter.setMaxHeight(0);
        platzhalter.setMaxWidth(200);

        hbox = new HBox(30, platzhalter);
		hbox.setPadding(new Insets(30));
		scrollPane = new ScrollPane();
		scrollPane.setContent(hbox);
		scrollPane.fitToHeightProperty().set(true);
        scrollPane.fitToWidthProperty().set(false);
		scrollPane.setPannable(true);
        scrollPane.setPrefSize(10000, 1000);
        scrollPane.setMaxHeight(150);

        scrollPane.getStyleClass().add("test-border-red");
        
        drag_drop_field = new DragDropViewController().getRootView();

        header2 = new Label("Neue Studiengangsdatei \nhinzufügen");
        header2.getStyleClass().add("header_2");

        backgroundPane = new Pane();
        backgroundPane.setPrefSize(10000, 1000);
        backgroundPane.setMaxHeight(700);
        backgroundPane.setBackground(new Background(new BackgroundFill(new Color(0.9,0.9,0.9, 0.5), new CornerRadii(0), new Insets(0))));
        backgroundPane.getStyleClass().add("test-border-red");

        AnchorPane.setTopAnchor(header, 100.0); 
        AnchorPane.setLeftAnchor(header, 150.0);

        AnchorPane.setTopAnchor(header2, 500.0);
        AnchorPane.setLeftAnchor(header2, 200.0);

        AnchorPane.setTopAnchor(drag_drop_field, 600.0);
        AnchorPane.setLeftAnchor(drag_drop_field, 200.0);
        AnchorPane.setBottomAnchor(drag_drop_field, 50.0);
        AnchorPane.setRightAnchor(drag_drop_field, 200.0);

        AnchorPane.setTopAnchor(scrollPane, 300.0); 
		AnchorPane.setLeftAnchor(scrollPane, 0.0);
		AnchorPane.setRightAnchor(scrollPane, 0.0);

        AnchorPane.setTopAnchor(backgroundPane, 400.0);
        AnchorPane.setLeftAnchor(backgroundPane, 0.0);
        AnchorPane.setBottomAnchor(backgroundPane, 0.0);
        AnchorPane.setRightAnchor(backgroundPane, 0.0);

        this.getStylesheets().add(getClass().getResource("introView.css").toExternalForm());
        this.getChildren().addAll(backgroundPane, header, header2, drag_drop_field, scrollPane);
    }

    public HBox getHbox() {
		return hbox;
	}
}
