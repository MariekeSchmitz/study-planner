package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class StudyViewController extends ViewController{
	
	private Button goToPlanButton;
	private StudyView studyView;
	private String degreeProgram;
	private FileManager filemanager;
	private App app; 
	private ViewManager viewManager;
	private String name;

    public StudyViewController(String name, String degreeProgram, String campus, FileManager filemanager, App app, ViewManager viewManager) {
    
    	this.degreeProgram = degreeProgram;
    	this.name = name;
    	this.filemanager = filemanager;
    	this.app = app;
    	this.viewManager = viewManager;
    	
    	studyView = new StudyView(degreeProgram, campus);
    	rootView = studyView;
    	
    	goToPlanButton = studyView.getStudyViewButton();
    	
    	initialise();
    	
    }

    @Override
    public void initialise() {
        
    	goToPlanButton.addEventHandler(ActionEvent.ACTION, e -> {

        	Plan plan = filemanager.fileRead(FileType.CURRICULA, name.replace(" ", "-"));
    		
			plan.initialize();
			app.setPlan(plan);
			viewManager.switchScene(Scenes.MAIN_VIEW);

		});
        
    }
    
}
