package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LeftSideView extends AnchorPane {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Pane logo;
    
    public LeftSideView() {

        this.setMinWidth(75);
        this.setMaxWidth(75);
        this.getStyleClass().add("left-side-pane");

        button1 = new Button("->");
        button2 = new Button("<-");
        button3 = new Button("S");
        button4 = new Button("L");
        button5 = new Button("E");

        logo = new Pane();
        logo.setMinSize(50,50);
        logo.setStyle("-fx-background-color: darkgrey;");

        button1.setMinSize(40, 40);
        button2.setMinSize(40, 40);
        button2.setPadding(new Insets(0, 0, 5, 0));
        button3.setMinSize(40, 40);
        button4.setMinSize(40, 40);
        button5.setMinSize(40, 40);

        this.getChildren().addAll(logo, button5,button3, button4, button1, button2);   
        
        AnchorPane.setBottomAnchor(button1, 17.5);
        AnchorPane.setLeftAnchor(button1, 17.5);
        AnchorPane.setBottomAnchor(button2, 75.0);
        AnchorPane.setLeftAnchor(button2, 17.5);
        AnchorPane.setBottomAnchor(button3, 167.5);
        AnchorPane.setLeftAnchor(button3, 17.5);
        AnchorPane.setBottomAnchor(button4, 225.0);
        AnchorPane.setLeftAnchor(button4, 17.5);

        AnchorPane.setLeftAnchor(button5, 17.5);
        AnchorPane.setTopAnchor(button5, 85.0);
        AnchorPane.setLeftAnchor(logo, 12.5);
        AnchorPane.setTopAnchor(logo, 17.5);

        this.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(0), new Insets(0))));


    }
}
