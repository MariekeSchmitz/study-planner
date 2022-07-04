package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
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
    private ListView<ExamModule> listView;
    private Map<Integer, List<Module>> moduleMap;
    private List<Module> allModuleList;
    private ObservableList<ExamModule> list;

    
    private List<ExamModule> relevantModules;

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
    	
        
        listView.setCellFactory(new Callback<ListView<ExamModule>, ListCell<ExamModule>>() {

            @Override
            public ListCell<ExamModule> call(ListView<ExamModule> param) {
                
            	ExamListCell examListCell = new ExamListCell();
            	
            	examListCell.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {

						// relation examModule – actualModule
						ExamModule examModule = examListCell.getItem();
						examModule.addPropertyChangeListener(viewManager.getMainViewController().getPlanViewController().getCenterViewController());
						
						Module actualModule = examModule.getAssociatedActualModule();
						actualModule.setAssociatedExamModule(examModule);
						actualModule.setHasExamModule(true);
						
						Course examCourse = examModule.getCourses().get(0);
						examCourse.setHasExtraExam(true);
						
						// remove examModule from list in examView + add it to plan
    					int semester = examModule.getSemesterDefault();
    					list.remove(examModule);
    					plan.addModule(semester, examModule);
    					
    					viewManager.getMainViewController().getPlanViewController().getCenterViewController().generateListView();
    		        	viewManager.getMainViewController().transitionOut(Scenes.EXAM_VIEW);

					}
				});   
            	
            	return examListCell;
            }
                
        });
        
        backButton.addEventHandler(ActionEvent.ACTION, e -> {
    		
        	viewManager.getMainViewController().transitionOut(Scenes.EXAM_VIEW);

    	});
        
    }
    
    
    public void generateListView(){

    	ExamModule tempModule;
    	moduleMap = plan.getModuleMap();
        relevantModules = new LinkedList<>();

    	
        for (List<Module> modulelist : moduleMap.values()) {
        	
        	for (Module module : modulelist) {
        		
        		if (module.getCourses().size() > 1) {
        			
        			for (Course course : module.getCourses()) {
        				
        				if (course.getExam().isGradeAvailable()) {
        					
        					tempModule = new ExamModule("Klausur - "+module.getName(), module.getDescription(), module.getSemesterDefault(), module.getSemesterCurrent(), OfferedTime.BI_YEARLY, Arrays.asList(course), module.getNeededCompetences(), module.getTaughtCompetences(), module.getCategory(), true, "", module);
        					relevantModules.add(tempModule);
        					
        				}
        				
        			}
        			
        		}
        		
        	}
        	
        	
        }
        
        list = FXCollections.observableList(relevantModules);
        listView.setItems(list);
        
    }
}
