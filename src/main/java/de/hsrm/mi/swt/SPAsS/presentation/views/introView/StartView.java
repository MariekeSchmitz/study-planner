package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.LogoView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StartView extends AnchorPane {

    private LogoView logo;

    private VBox headerVBox;
    private Label header1;
    private Label header2;
    private Label secondHeader;

    private Button addButton;
    private Button ownPlanButton;

    private HBox hbox;
    private ScrollPane scrollPane;

    public StartView() {

        headerVBox = new VBox(10);

        logo = new LogoView();
        header1 = new Label("Willkommen zum");
        header1.getStyleClass().add("header");
        header2 = new Label("Studienverlaufplaner");
        header2.getStyleClass().add("headerOne");

        secondHeader = new Label("Neuen Plan anlegen");
        secondHeader.getStyleClass().add("secondHeader");

        headerVBox.getChildren().addAll(header1, header2);

        addButton = new Button("+");
        addButton.getStyleClass().add("addbutton");
        addButton.setPrefSize(300, 300);
        addButton.setMaxSize(300, 300);

        ownPlanButton = new Button("Eigener Plan \nimportieren");
        ownPlanButton.getStyleClass().add("ownButton");
        ownPlanButton.setPrefSize(300, 300);
        ownPlanButton.setMaxSize(200, 50);

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

        AnchorPane.setTopAnchor(headerVBox, 175.0);
        AnchorPane.setLeftAnchor(headerVBox, 300.0);

        AnchorPane.setTopAnchor(secondHeader, 350.0);
        AnchorPane.setLeftAnchor(secondHeader, 300.0);

        AnchorPane.setTopAnchor(addButton, 450.0);
        AnchorPane.setLeftAnchor(addButton, 300.0);

        AnchorPane.setBottomAnchor(ownPlanButton, 25.0);
        AnchorPane.setRightAnchor(ownPlanButton, 50.0);

        AnchorPane.setTopAnchor(scrollPane, 400.0); 
		AnchorPane.setLeftAnchor(scrollPane, 300.0);
		AnchorPane.setRightAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 75.0);        

        this.getStylesheets().add(getClass().getResource("/css/introView.css").toExternalForm());
        this.getChildren().addAll(headerVBox, logo, secondHeader, scrollPane, addButton, ownPlanButton);
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

    public Button getOwnPlanButton() {
        return ownPlanButton;
    }

    public HBox getHbox() {
        return hbox;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }
    

}
