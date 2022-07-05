package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
/**
 * Visual Component for Logo
 */
public class LogoView extends BorderPane{

    private ImageView logo;

    public LogoView(boolean flag, int size) {
    	
    	if(flag) {
        	logo = new ImageView("/images/logo.png");
    	} else {
        	logo = new ImageView("/images/logo_ohne.png");

    	}
    	
    	logo.setFitHeight(size);
    	logo.setFitWidth(size);

        this.setCenter(logo);
        
        this.setPrefSize(100,100);
        this.setMaxHeight(100);
        this.setMaxWidth(100);        
    }
    
}
