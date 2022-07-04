package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView;

import java.util.List;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Competence;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.MainViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.UIcomponents.CoursesRowController;import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * Reacts to User Input on ModuleInformationView. Fills View with Module Information.
 */
public class ModuleInformationViewController extends ViewController{

	private App app;
	private Module module;
	private Button backButton;
	private Button deleteButton;
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
    	deleteButton = moduleInformationView.getDeleteExam();
    	
    	System.out.println(moduleInformationView.getWidth());
     
    	initialise();
    }

    @Override
    public void initialise() {
       
    	backButton.addEventHandler(ActionEvent.ACTION, e -> {
    		mainViewController.transitionOut(Scenes.MODULE_INFORMATION_VIEW);
    		Scenes.MODULE_INFORMATION_VIEW.setIn(false);
    	});  
    	
    	deleteButton.addEventHandler(ActionEvent.ACTION, e -> {
    		
    		app.getPlan().removeModule(module.getSemesterCurrent(), module);
    		
    		Module associatedModule = ((ExamModule)module).getAssociatedActualModule();
    		associatedModule.setAssociatedExamModule(null);
    		associatedModule.setHasExamModule(false);
    		
    		Course examCourse = module.getCourses().get(0);
    		examCourse.setHasExtraExam(false);
    		
			app.getPlan().validate();

    		
    		// update List in ExamView
    		mainViewController.getExamViewController().generateListView();
    		
    		mainViewController.getPlanViewController().getCenterViewController().generateListView();
    		mainViewController.transitionOut(Scenes.MODULE_INFORMATION_VIEW);
    		Scenes.MODULE_INFORMATION_VIEW.setIn(false);


    	}); 
    	
    }
    
    public void setModuleInformation(Module module) {
    	
    	this.module = module;
    	
    	moduleInformationView.getModuleName().setText(module.getName());
    	moduleInformationView.getCategory().setText(module.getCategory().getName());
    	moduleInformationView.getCp().setText(Integer.toString(module.getCp()) + " CP");
    	
    	if (module.isValid()) {
    		moduleInformationView.getWarningBox().setVisible(false);
			AnchorPane.setTopAnchor(moduleInformationView.getBox(), 200.0);
			AnchorPane.setTopAnchor(moduleInformationView.getLabelHbox(), 220.0);

    	} else {
    		moduleInformationView.getWarningBox().setVisible(true);
    		moduleInformationView.getNoteWarningText().setText(module.getNote());
			AnchorPane.setTopAnchor(moduleInformationView.getBox(), 300.0);
			AnchorPane.setTopAnchor(moduleInformationView.getLabelHbox(), 320.0);
    	}
    	
    	coursesBox = moduleInformationView.getCoursesBox();
    	coursesBox.getChildren().clear();
    	
    	
    	List<Course> courses = module.getCourses();
    	
    	for (Course course : courses) {
   
    		courseHBox = (HBox)new CoursesRowController(course, app.getPlan(), course.isHasExtraExam(), module).getRootView();
    		
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
    	
    	if (module instanceof ExamModule) {
    		deleteButton.setVisible(true);
    	} else {
    		deleteButton.setVisible(false);
    	}
    	
    }

}
