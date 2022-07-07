package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import java.io.File;

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
        	logo = new ImageView(File.separator+"images"+File.separator+"logo.png");
    	} else {
        	logo = new ImageView(File.separator+"images"+File.separator+"logo_ohne.png");

    	}
    	
    	logo.setFitHeight(size);
    	logo.setFitWidth(size);

        this.setCenter(logo);
        
        this.setPrefSize(size,size);
        this.setMaxHeight(size);
        this.setMaxWidth(size);        
    }
    
}
