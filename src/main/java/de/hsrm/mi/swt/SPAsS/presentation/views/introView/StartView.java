package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import java.io.File;

import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.LogoView;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.OwnbuttonView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Visual Component for Drag and Drop
 */
public class StartView extends AnchorPane {

    private LogoView logo;

    private VBox headerVBox;
    private Label header1;
    private Label header2;
    private Label secondHeader;

    private Button addButton;
    private OwnbuttonView ownPlanButton;

    private HBox hbox;
    private ScrollPane scrollPane;
    
    private AnchorPane uploadPane;

    /**
 * Startscreen
 */
    public StartView() {

    	uploadPane = new AnchorPane();
    	uploadPane.getStyleClass().add("BackgroundBackButton");
    	uploadPane.setVisible(false);
    	
        headerVBox = new VBox(5);
        
        logo = new LogoView(true,200);
        header1 = new Label("Willkommen zum");
        header1.getStyleClass().add("header");
        header2 = new Label("Studienverlaufplaner");
        header2.getStyleClass().add("headerOne");

        secondHeader = new Label("Neuen Plan anlegen");
        secondHeader.getStyleClass().add("secondHeader");

        headerVBox.getChildren().addAll(header1, header2);

        addButton = new Button();
        addButton.getStyleClass().add("addbutton");
        addButton.setPrefSize(75, 75);
        addButton.setMaxSize(75, 75);
		ImageView ivIconaddButton = new ImageView(new Image(File.separator+"images" + File.separator +"plus.png"));
		ivIconaddButton.setFitHeight(35);
		ivIconaddButton.setFitWidth(35);
		addButton.setGraphic(ivIconaddButton);

        ownPlanButton = new OwnbuttonView();
    
        hbox = new HBox(20);
		hbox.setPadding(new Insets(30));
		scrollPane = new ScrollPane();
		scrollPane.setContent(hbox);
		scrollPane.fitToHeightProperty().set(true);
        scrollPane.fitToWidthProperty().set(false);
		scrollPane.setPannable(true);
        scrollPane.setPrefSize(10000, 1000);
        scrollPane.setMaxHeight(750);
        scrollPane.setVisible(false);

        AnchorPane.setTopAnchor(logo, 50.0);
        AnchorPane.setLeftAnchor(logo, 50.0);

        AnchorPane.setTopAnchor(headerVBox, 130.0);
        AnchorPane.setLeftAnchor(headerVBox, 330.0);

        AnchorPane.setTopAnchor(secondHeader, 300.0);
        AnchorPane.setLeftAnchor(secondHeader, 330.0);

        AnchorPane.setTopAnchor(addButton, 450.0);
        AnchorPane.setLeftAnchor(addButton, 330.0);

        AnchorPane.setBottomAnchor(ownPlanButton, 30.0);
        AnchorPane.setRightAnchor(ownPlanButton, 70.0);

        AnchorPane.setTopAnchor(scrollPane, 330.0); 
		AnchorPane.setLeftAnchor(scrollPane, 300.0);
		AnchorPane.setRightAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 100.0);  
        
        AnchorPane.setTopAnchor(uploadPane, 0.0); 
		AnchorPane.setLeftAnchor(uploadPane, 0.0);
		AnchorPane.setRightAnchor(uploadPane, 0.0);
        AnchorPane.setBottomAnchor(uploadPane, 0.0);   

        this.setStyle("-fx-background-color:white;");
        this.getStylesheets().add(getClass().getResource("/css/introView.css").toExternalForm());
        this.getChildren().addAll(headerVBox, logo, secondHeader, scrollPane, addButton, ownPlanButton, uploadPane);
    }

    public LogoView getLogo() {
        return logo;
    }

    public VBox getHeaderVBox() {
        return headerVBox;
    }

    public Label getHeader1() {
        return header1;
    }

    public Label getHeader2() {
        return header2;
    }

    public Label getSecondHeader() {
        return secondHeader;
    }

    public Button getAddButton() {
        return addButton;
    }

    public OwnbuttonView getOwnPlanButton() {
        return ownPlanButton;
    }

    public HBox getHbox() {
        return hbox;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

	public AnchorPane getUploadPane() {
		return uploadPane;
	}
    

}
