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

public class TitelPlanViewController extends ViewController{
	
	
	private Button openPlanButton;
	private TitelPlanView titelPlanView;
	private ViewManager viewManager;
	private Plan plan;
	private FileManager fileManager;
	private String titel;
	private App app;
	
    public TitelPlanViewController(String titel, String degreeProgram, String institution, ViewManager viewManager, App app, FileManager fileManager) {
    	this.titel = titel;
    	this.app = app;
    	this.viewManager = viewManager;
    	this.fileManager = fileManager;
    	titelPlanView = new TitelPlanView(titel, degreeProgram, institution);
    	rootView = titelPlanView;
    	
    	openPlanButton = titelPlanView.getChooseCurriculumButton();
    	
    	initialise();
    }

    @Override
    public void initialise() {
       
    	openPlanButton.addEventHandler(ActionEvent.ACTION, e -> {

			plan = fileManager.fileRead(FileType.PLAN, titel);
			app.setPlan(plan);
			viewManager.switchScene(Scenes.MAIN_VIEW);

		});
        
    }
    
}
