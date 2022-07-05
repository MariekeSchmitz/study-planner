package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;

import java.io.File;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
/**
 * Curriculum Selection view
 */
public class SelectView extends AnchorPane{
	
	private Button backButton;
    
    private Pane backgroundPane;

    private Label header;
    private Label header2;

    private BorderPane drag_drop_field;

    private ScrollPane scrollPane;
	private HBox hbox;

    private ListView<Pane> listView;

    public SelectView() {
    	
		ImageView ivIcon = new ImageView(new Image(File.separator+"images" + File.separator +"X.png"));
		ivIcon.setFitHeight(50);
		ivIcon.setFitWidth(50);
		backButton = new Button();
		backButton.setGraphic(ivIcon);
		backButton.getStyleClass().add("backButton");
    	
        header = new Label("Studiengang \nwählen");
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
        
        drag_drop_field = new BorderPane();

        header2 = new Label("Neue Studiengangsdatei \nhinzufügen");
        header2.getStyleClass().add("header_2");

        backgroundPane = new Pane();
        //backgroundPane.setBackground(new Background(new BackgroundFill(new Color(0.9,0.9,0.9, 0.5), new CornerRadii(0), new Insets(0))));

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
		
        AnchorPane.setTopAnchor(backButton, 30.0);
        AnchorPane.setRightAnchor(backButton, 30.0);

        AnchorPane.setTopAnchor(backgroundPane, 450.0);
        AnchorPane.setLeftAnchor(backgroundPane, 0.0);
        AnchorPane.setRightAnchor(backgroundPane, 0.0);
        AnchorPane.setBottomAnchor(backgroundPane, 0.0);
        
        this.getStyleClass().add("BackgroundWhite");
        this.getStylesheets().add(getClass().getResource("/css/introView.css").toExternalForm());
        this.getChildren().addAll(backgroundPane, header, header2, drag_drop_field, scrollPane, backButton);
    }

    public HBox getHbox() {
		return hbox;
	}

    public Pane getBackgroundPane() {
        return backgroundPane;
    }

    public Label getHeader() {
        return header;
    }

    public Label getHeader2() {
        return header2;
    }

    public Pane getDrag_drop_field() {
        return drag_drop_field;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public ListView<Pane> getListView() {
        return listView;
    }

	public void setDrag_drop_field(Pane drag_drop_field) {
		this.drag_drop_field.setCenter(drag_drop_field);
	}

	public Button getBackButton() {
		return backButton;
	}

    
    
    
}
