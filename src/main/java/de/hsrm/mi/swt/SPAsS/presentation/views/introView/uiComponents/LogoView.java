package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class LogoView extends BorderPane{

    private Label logoText;

    public LogoView() {

        logoText = new Label("Logo");

        this.setCenter(logoText);
        
        this.setPrefSize(100,100);
        this.setMaxHeight(100);
        this.setMaxWidth(100);        
        this.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(0), new Insets(0))));
    }
    
}
