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
import javafx.scene.effect.DropShadow;
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
    private Label header1;
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
    	
        header = new Label("Studiengang");
        header.getStyleClass().add("headerOne");
        
        header1 = new Label("wählen");
        header1.getStyleClass().add("header");

        Pane platzhalter = new Pane();
        platzhalter.setPrefSize(1000, 300);
        platzhalter.setMaxHeight(0);
        platzhalter.setMaxWidth(130);

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
        backgroundPane.setBackground(new Background(new BackgroundFill(Color.rgb(246, 246, 246,1), new CornerRadii(0), new Insets(0))));

        AnchorPane.setTopAnchor(header, 80.0); 
        AnchorPane.setLeftAnchor(header, 100.0);
        
        AnchorPane.setTopAnchor(header1, 140.0);
        AnchorPane.setLeftAnchor(header1, 100.0);

        AnchorPane.setTopAnchor(header2, 430.0);
        AnchorPane.setLeftAnchor(header2, 200.0);
        
        AnchorPane.setTopAnchor(drag_drop_field, 520.0);
        AnchorPane.setLeftAnchor(drag_drop_field, 200.0);
        AnchorPane.setBottomAnchor(drag_drop_field, 50.0);
        AnchorPane.setRightAnchor(drag_drop_field, 200.0);

        AnchorPane.setTopAnchor(scrollPane, 230.0); 
		AnchorPane.setLeftAnchor(scrollPane, 0.0);
		AnchorPane.setRightAnchor(scrollPane, 0.0);
		
        AnchorPane.setTopAnchor(backButton, 30.0);
        AnchorPane.setRightAnchor(backButton, 30.0);

        AnchorPane.setTopAnchor(backgroundPane, 380.0);
        AnchorPane.setLeftAnchor(backgroundPane, 0.0);
        AnchorPane.setRightAnchor(backgroundPane, 0.0);
        AnchorPane.setBottomAnchor(backgroundPane, 0.0);
        
        this.getStyleClass().add("BackgroundWhite");
        this.setEffect(new DropShadow(204,0,2, Color.rgb(49, 49, 64)));
        this.getStylesheets().add(getClass().getResource("/css/introView.css").toExternalForm());
        this.getChildren().addAll(backgroundPane, header, header1, header2, drag_drop_field, scrollPane, backButton);
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
    public Label getHeader1() {
        return header1;
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
