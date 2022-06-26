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

	
	
	
    public ModuleInformationViewController(MainViewController mainViewController, App app) {
    	
    	this.mainViewController = mainViewController; 
    	this.app = app;
    	
    	moduleInformationView = new ModuleInformationView();
    	rootView = moduleInformationView;
    	backButton = moduleInformationView.getBackButton();
    	
     
    	initialise();
    }

    @Override
    public void initialise() {
       
    	backButton.addEventHandler(ActionEvent.ACTION, e -> {
    		mainViewController.removeView(Scenes.MODULE_INFORMATION_VIEW);
    		

    	});        
    }
    
    public void setModuleInformation(Module module) {
    	
    	this.module = module;
    	
    	moduleInformationView.getModuleName().setText(module.getName());
    	moduleInformationView.getCategory().setText(module.getCategory().getName());
    	moduleInformationView.getCp().setText(Integer.toString(module.getCp()) + " CP");
    	
    	if (module.isValid()) {
    		moduleInformationView.getWarningBox().setVisible(false);
    	} else {
    		moduleInformationView.getWarningBox().setVisible(true);
    		moduleInformationView.getNoteWarningText().setText(module.getNote());
    	}
    	
    	coursesBox = moduleInformationView.getCoursesBox();
    	coursesBox.getChildren().clear();
    	
    	
    	List<Course> courses = module.getCourses();
    	
    	for (Course course : courses) {
   
    		courseHBox = (HBox)new CoursesRowController(course, app.getPlan()).getRootView();
    		
    		coursesBox.getChildren().add(courseHBox);
    		
    		String s = course.getTaughtCompetences().toString().replace("[", "").replace("]", "");
    		
    		moduleInformationView.getTaughtCompetencesText().setText(s);
   
    	} 
    	
    	moduleInformationView.getModuleDescriptionText().setText(module.getDescription());
    	
		String x = module.getNeededCompetences().toString().replace("[", "").replace("]", "");

    	moduleInformationView.getNeededCompetencesText().setText(x);
    	
    	
    }

}
