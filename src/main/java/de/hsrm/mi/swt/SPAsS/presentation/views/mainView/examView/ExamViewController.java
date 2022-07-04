package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamType;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.OfferedTime;
import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
/**
 * Reacts to User Selection of an Exam. Puts new Exam-Module into Plan
 */
public class ExamViewController extends ViewController{


    private ViewManager viewManager;
    private App app;
    private ExamView examView;
    private Button backButton;
    private Plan plan;
    private ListView<Module> listView;
    private Map<Integer, List<Module>> moduleMap;
    private ObservableList<Module> list;
    
    private List<Module> relevantModules;

    public ExamViewController(ViewManager viewManager, App app) {
        
        examView = new ExamView();
        rootView = examView;

        this.viewManager = viewManager;
        this.app = app;
        this.plan = app.getPlan();
        this.moduleMap = plan.getModuleMap();
        this.listView = examView.getListView();
        relevantModules = new LinkedList<>();
        backButton = examView.getBackbutton();

        
        initialise();

        

    }

    @Override
    public void initialise() {
    	
    	generateListView();
    	list = FXCollections.observableList(relevantModules);
        listView.setItems(list);
        
        listView.setCellFactory(new Callback<ListView<Module>, ListCell<Module>>() {

            @Override
            public ListCell<Module> call(ListView<Module> param) {
                
            	ExamListCell examListCell = new ExamListCell();
            	
            	examListCell.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {

						Module module = examListCell.getItem();
    					module.getAssociatedModule().getCourse(module.getCourses().get(0)).setHasExtraExam(true);
    					int semester = module.getSemesterDefault();
    					list.remove(module);
    					plan.addModule(semester, module);
    					viewManager.getMainViewController().getPlanViewController().getCenterViewController().generateListView();
    		        	viewManager.getMainViewController().transitionOut(Scenes.EXAM_VIEW);

    					System.out.println("on click");

					}
				});   
            	
            	return examListCell;
            }
                
        });
        
        backButton.addEventHandler(ActionEvent.ACTION, e -> {
    		
        	viewManager.getMainViewController().transitionOut(Scenes.EXAM_VIEW);
    		

    	});
        
    }
    private void generateListView(){

    	Module tempModule;
    	
        for (List<Module> modulelist : moduleMap.values()) {
        	
        	for (Module module : modulelist) {
        		
        		if (module.getCourses().size() > 1) {
        			
        			for (Course course : module.getCourses()) {
        				
        				if (course.getExam().getExamType() == ExamType.EXAM) {
        					
        					tempModule = new Module("Klausur - "+module.getName(), module.getDescription(), module.getSemesterDefault(), module.getSemesterCurrent(), OfferedTime.BI_YEARLY, Arrays.asList(course), module.getNeededCompetences(), module.getTaughtCompetences(), module.getCategory(), true, "", module);
        					relevantModules.add(tempModule);
        					
        				}
        				
        			}
        			
        		}
        		
        	}
        	
        	
        }
        
    }
}
