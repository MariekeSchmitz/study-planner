package de.hsrm.mi.swt.SPAsS.presentation.views.introView;


import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.MetaEnum;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.TitelPlanViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
/**
 * Reacts to User Input depending on plans beeing available for selection
 */
public class StartViewController extends ViewController {

    private StartView startView;
    private ViewManager viewManager;

    private ScrollPane scrollPane;
    private Button addButton;
    private Button ownPlanButton;
    private Label secondHeader;
    private FileManager fileManager;
    private Boolean plansAvailable;
    private App app;

    private HBox hbox;

    public StartViewController(ViewManager viewManager, App app) {
    	this.app = app;
        this.fileManager = app.getFileManager();
        this.viewManager = viewManager;
    	startView = new StartView();
        rootView = startView;
        scrollPane = startView.getScrollPane();
        addButton = startView.getAddButton();
        ownPlanButton = startView.getOwnPlanButton();
        secondHeader = startView.getSecondHeader();
        hbox = startView.getHbox();
        initialise();
    }

    @Override
    public void initialise() {
    	
    	List<String> fileNames = fileManager.planScan();
    	HashMap<String, String> metaData;
    	
    	if (fileNames.isEmpty()) {
    		plansAvailable = false;
    	} else {
    		plansAvailable = true;
    	}
    	
        swapView(plansAvailable);

        if(plansAvailable) {
        	
        	for (String plan : fileNames) {
        		
        		String name;
        		String institution;
        		String degreeProgram;
        		
        		try {
					metaData = fileManager.readMeta(FileType.PLAN, plan);
					name = metaData.get(MetaEnum.NAME.toString());
	        		institution = metaData.get(MetaEnum.HOCHSCHULE.toString());
	        		degreeProgram = metaData.get(MetaEnum.STUDIENGANG.toString());
				} catch (FileNotFoundException e1) {
					name = plan;
	        		institution = "";
	        		degreeProgram = "";
				}
        		
        		
        
	    		 Pane tempPane = new TitelPlanViewController(name, institution, degreeProgram, viewManager, app, fileManager).getRootView();
	        	 hbox.getChildren().add(tempPane); 
        	}
        	
        }
        
        addButton.addEventHandler(ActionEvent.ACTION, e -> {

        	List<String> curricula = fileManager.curriculumScan();
        	
        	if (curricula.isEmpty()) {
        		viewManager.switchScene(Scenes.UPLOAD_CURRICULUM_VIEW);
        	} else {
        		viewManager.switchScene(Scenes.SELECT_VIEW);

        	}
        	
			startView.getUploadPane().setVisible(true);

			
		});
        
        ownPlanButton.addEventHandler(ActionEvent.ACTION, e -> {

        	viewManager.switchScene(Scenes.UPLOAD_PLAN_VIEW);
			startView.getUploadPane().setVisible(true);

		});
        	
     
    }
    
    public void swapView(boolean plansAvailable){
        if(!plansAvailable){
            scrollPane.setVisible(false);
            secondHeader.setText("Neuen Plan hinzufügen");
            AnchorPane.setTopAnchor(addButton, 500.0);
            AnchorPane.setLeftAnchor(addButton, 350.0);
        } else {
            scrollPane.setVisible(true);
            secondHeader.setText("Deine Pläne:");
            AnchorPane.setTopAnchor(addButton, 500.0);
            AnchorPane.setLeftAnchor(addButton, 150.0);
            addButton.setMaxSize(150, 150);
        }
    }
    
    
    
    

}
