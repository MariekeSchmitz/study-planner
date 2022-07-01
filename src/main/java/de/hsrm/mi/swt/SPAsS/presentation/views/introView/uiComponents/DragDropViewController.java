package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.commands.MoveSemesterCommand;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

public class DragDropViewController extends ViewController {

	private Button fileOpenButton;
	private DragDropView dragDropView;
	private App app;
	private Pane dragDropPane;
	private FileManager fileManager;
	private ViewManager viewManager;
	private FileType fileType;
	
	
    public DragDropViewController(App app, FileType fileType) {
        
    	this.app = app;
    	this.fileManager = app.getFileManager();
    	this.viewManager = app.getViewManager();
    	this.fileType = fileType;
    	dragDropView = new DragDropView();
    	rootView = dragDropView;
    	
    	fileOpenButton = dragDropView.getFileOpen();
   
    	initialise();
        
    }

    @Override
    public void initialise() {
        
    	
    	fileOpenButton.addEventHandler(ActionEvent.ACTION, e -> {

        	FileChooser.ExtensionFilter fileFilter = new FileChooser.ExtensionFilter("JSON-Dateien", "*.json");
        	FileChooser fileChooser = new FileChooser();
        	fileChooser.getExtensionFilters().add(fileFilter);
        	fileChooser.setTitle("Datei hochladen");
        	File file = fileChooser.showOpenDialog(app.getPrimaryStage());
        	String fileName = file.getName().substring(0, file.getName().lastIndexOf('.'));

        	
        	try {
        		
        		if (fileType == FileType.CURRICULA) {
        			fileManager.duplicateFile(FileType.CURRICULA, file, fileName);				
    				Plan plan = fileManager.fileRead(FileType.CURRICULA,  fileName);
//    				fileManager.fileSave(FileType.CURRICULA, plan);
    				plan.initialize();
    				app.setPlan(plan);
    				
    				fileManager.createMetaFile("curricula", plan);			
    				viewManager.switchScene(Scenes.MAIN_VIEW);
        		}
        		
        		else if (fileType == FileType.PLAN) {
        			
        			fileManager.duplicateFile(FileType.PLAN, file, fileName);				
        			Plan plan = fileManager.fileRead(FileType.PLAN,  fileName);
        			Plan planCopy = fileManager.fileRead(FileType.PLAN,  fileName);

        			for (Module module : planCopy.getModuleList()) {
        				module.setSemesterCurrent(module.getSemesterDefault());
        				module.setValid(true);
        			}
        			
        			
    				plan.initialize();
    				app.setPlan(plan);
    				fileManager.createMetaFile("plans", plan);			
    				viewManager.switchScene(Scenes.MAIN_VIEW);
    				
    				// TODO: Curriculum daraus mit DefaultPlan abspeichern 
    				
        		}
        		
				
				
				
				
			} catch (IOException e1) {
				
				e1.printStackTrace();		
			}
        	

        	
        	
        	
		});
        
    }
    
}
