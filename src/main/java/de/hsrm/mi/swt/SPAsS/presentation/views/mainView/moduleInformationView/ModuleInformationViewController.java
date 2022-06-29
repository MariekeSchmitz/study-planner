package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView;

import java.util.List;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Competence;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.MainViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.UIcomponents.CoursesRowController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.ModuleViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModuleInformationViewController extends ViewController{

	private App app;
	private Module module;
	private Button backButton;
	private ModuleInformationView moduleInformationView;
	private MainViewController mainViewController;
	private VBox coursesBox;
	private HBox courseHBox;
	private VBox taughtCompetencesVbox;
	private VBox neededCompetencesVbox;

	
	
	
    public ModuleInformationViewController(MainViewController mainViewController, App app) {
    	
    	this.mainViewController = mainViewController; 
    	this.app = app;
    	
    	moduleInformationView = new ModuleInformationView();
    	rootView = moduleInformationView;
    	backButton = moduleInformationView.getBackButton();
    	
    	System.out.println(moduleInformationView.getWidth());
     
    	initialise();
    }

    @Override
    public void initialise() {
       
    	backButton.addEventHandler(ActionEvent.ACTION, e -> {
    		mainViewController.transitionOut(Scenes.MODULE_INFORMATION_VIEW);
    		Scenes.MODULE_INFORMATION_VIEW.setIn(false);
    	});        
    }
    
    public void setModuleInformation(Module module) {
    	
    	this.module = module;
    	
    	moduleInformationView.getModuleName().setText(Boolean.toString(module.isValid()));
    	moduleInformationView.getCategory().setText(module.getCategory().getName());
    	moduleInformationView.getCp().setText(Integer.toString(module.getCp()) + " CP");
    	
    	if (module.isValid()) {
    		moduleInformationView.getWarningBox().setVisible(false);
			AnchorPane.setTopAnchor(moduleInformationView.getBox(), 200.0);
    	} else {
    		moduleInformationView.getWarningBox().setVisible(true);
    		moduleInformationView.getNoteWarningText().setText(module.getNote());
			AnchorPane.setTopAnchor(moduleInformationView.getBox(), 300.0);

    	}
    	
    	coursesBox = moduleInformationView.getCoursesBox();
    	coursesBox.getChildren().clear();
    	
    	
    	List<Course> courses = module.getCourses();
    	
    	for (Course course : courses) {
   
    		courseHBox = (HBox)new CoursesRowController(course, app.getPlan()).getRootView();
    		
    		coursesBox.getChildren().add(courseHBox);
   
    	} 

		List<Competence> taughtCompetences = module.getTaughtCompetences();
		taughtCompetencesVbox = moduleInformationView.getTaughtCompetencesVbox();
		taughtCompetencesVbox.getChildren().clear();

		for (Competence competence : taughtCompetences) {
			taughtCompetencesVbox.getChildren().add(new Label("- " + competence.getName()));
		}

		List<Competence> neededCompetences = module.getNeededCompetences();
		neededCompetencesVbox = moduleInformationView.getNeededCompetencesVbox();
		neededCompetencesVbox.getChildren().clear();

		for (Competence competence : neededCompetences) {
			neededCompetencesVbox.getChildren().add(new Label("- " + competence.getName()));
		}
    		    	
    	moduleInformationView.getModuleDescriptionText().setText(module.getDescription());
    	
    }

}
