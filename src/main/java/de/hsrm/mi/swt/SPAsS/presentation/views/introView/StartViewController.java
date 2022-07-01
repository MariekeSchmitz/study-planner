package de.hsrm.mi.swt.SPAsS.presentation.views.introView;


import java.util.List;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.TitelPlanViewController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class StartViewController extends ViewController {

    private StartView sv;

    private ScrollPane scrollPane;
    private Button addButton;
    private Label secondHeader;
    private FileManager fileManager;
    private Boolean plansAvailable;

    private HBox hbox;

    public StartViewController(ViewManager viewManager, App app) {
        this.fileManager = app.getFileManager();
    	sv = new StartView();
        rootView = sv;
        scrollPane = sv.getScrollPane();
        addButton = sv.getAddButton();
        secondHeader = sv.getSecondHeader();
        hbox = sv.getHbox();
        initialise();
    }

    @Override
    public void initialise() {
    	
    	List<String> fileNames = fileManager.planScan();
    	
    	if (fileNames.isEmpty()) {
    		plansAvailable = false;
    	} else {
    		plansAvailable = true;
    	}
    	
        swapView(plansAvailable);

        if(plansAvailable) {
        	
        	for (String plan : fileNames) {
        		 Pane tempPane = new TitelPlanViewController(plan, "Medieninformatik (B.Sc.)", "HochschuleRheinMain").getRootView();
            	 hbox.getChildren().add(tempPane); 
        	}
        	
        }
        	
        
        
    	
//        for (int i = 0; i < 5 ; i++) {
//            Pane test1 = new TitelPlanViewController("Test Plan" + i, "Medieninformatik (B.Sc.)").getRootView();
//            hbox.getChildren().add(test1);
//        }
    }
    
    public void swapView(boolean plansAvailable){
        if(!plansAvailable){
            scrollPane.setVisible(false);
            secondHeader.setText("Neuen Plan hinzufügen");
            AnchorPane.setTopAnchor(addButton, 450.0);
            AnchorPane.setLeftAnchor(addButton, 300.0);
        } else {
            scrollPane.setVisible(true);
            secondHeader.setText("Deine Pläne:");
            AnchorPane.setTopAnchor(addButton, 500.0);
            AnchorPane.setLeftAnchor(addButton, 125.0);
            addButton.setMaxSize(150, 150);
        }
    }

}
