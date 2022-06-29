package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.commands.CommandManager;
import de.hsrm.mi.swt.SPAsS.business.commands.ResetPlanCommand;
import de.hsrm.mi.swt.SPAsS.business.planManagement.CategoryEnum;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Competence;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Exam;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamType;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.OfferedTime;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


public class CenterViewController extends ViewController implements PropertyChangeListener{

    private CenterView centerView;
    private Plan plan;
    private Map<Integer,List<Module>> moduleMap;
    private int numSemester;
    private VBox planBox;
    private Button resetButton;
    private Button addSemesterButton;
	private Button removeSemesterButton;
	private Button addExamButton;


    private DataFormat dataFormat =  new DataFormat("moduleCell");
    private List<SemesterList> semesterListViews;
	private Map<Integer,ObservableList<Module>> moduleMapWithObservables;
	
	private double mouseX;
	private double mouseY;
	private ViewManager viewManager;
	
	




    public CenterViewController(Plan plan, ViewManager viewManager) {
        
    	centerView = new CenterView();
    	rootView = centerView;
    	
    	this.plan = plan;
    	this.moduleMap = plan.getModuleMap();
    	
    	this.semesterListViews = new LinkedList<>();
    	this.viewManager = viewManager;
    	
        

    	
    	
    	planBox = centerView.getPlanBox();
    	
    	resetButton = centerView.getAddKlausur();
    	addSemesterButton = centerView.getAddSemester();
		removeSemesterButton = centerView.getRemoveSemester();
		addExamButton = centerView.getAddExam();
    	
    	generateListView();
    	
    	
    	
    	
    	initialise();
    	
    	
    	
    	
    }

    @Override
    public void initialise() {
    	
    
        
    	resetButton.addEventHandler(ActionEvent.ACTION, e -> {
    		
    		plan.resetPlan();
    		plan.updateModuleMap();
			generateListView();
			

    	});
    	
    	addExamButton.addEventHandler(ActionEvent.ACTION, e -> {
    		
    		viewManager.getMainViewController().putExamViewOnStack();

    	});
    	
    	
    	
//    	addSemesterButton.addEventHandler(ActionEvent.ACTION, e -> {
//    		
//    		moduleMap.get(1).get(2).setPassed(true);
//    		moduleMap.get(2).get(2).setPassed(true);
//    		
//    	});
    	

    	addSemesterButton.addEventHandler(ActionEvent.ACTION, e -> {
    		
    		plan.addSemester();
    		generateListView();
    		
    		System.out.println(moduleMap);
    		
    		System.out.println("addSemester");
    		
    		
    		
    		
    	});

    	removeSemesterButton.addEventHandler(ActionEvent.ACTION, e -> {
    		
    		plan.removeSemester();
    		generateListView();
    		
    		System.out.println(moduleMap);
    		
    		System.out.println("removeSemester");
    		
    		
    		
    		
    	});
    	
    	
    	for(List<Module> moduleList : moduleMap.values()) {
    		
    		for (Module module : moduleList) {
    			
    			module.addPropertyChangeListener(this);
    			
    			
    			for (Course course : module.getCourses()) {
    				
    				
    				
    				course.getExam().addPropertyChangeListener(this);
    				
    				
    			}
    			
    			
    			
    			
    			
    		}
    	}
    	
    	
    	
    	
    		
    	
    	
    }   
    
    
    private void generateListView() {
    	
    	SemesterList semesterListView;

    	ObservableList<Module> moduleListObservable;
    	moduleMapWithObservables = new HashMap<>();
    	HBox semesterRow;
    	
		planBox.getChildren().clear();

    	this.numSemester = plan.getNumberSemester();

		
    	for (int i = numSemester; i > 0; i--) {
    		
    		
    		moduleListObservable = FXCollections.observableList(moduleMap.get(i));
    		moduleMapWithObservables.put(i, moduleListObservable);

    		semesterListView = new SemesterList(moduleListObservable, i, dataFormat, plan);
    		semesterListView.setItems(moduleListObservable);
    		semesterListView.setOrientation(Orientation.HORIZONTAL);
    		
    		moduleListObservable.addListener(new ListChangeListener<Module> (){

				@Override
				public void onChanged(Change<? extends Module> c) {
					
					
					
				}

	
			});

    		
    		semesterListView.setCellFactory(new Callback<ListView<Module>, ListCell<Module>>() {

				@Override
				public ListCell<Module> call(ListView<Module> param) {
					
					ModuleView moduleView = new ModuleView();
					
			
					
					
					moduleView.setOnDragDetected(( MouseEvent event ) ->
		            {
		                System.out.println( "listcell setOnDragDetected" );
		                Dragboard db = moduleView.startDragAndDrop(TransferMode.MOVE);
		                ClipboardContent content = new ClipboardContent();
//		                moduleView.setTranslateX(moduleView.getTranslateX() + event.getX());
//		                moduleView.setTranslateY(moduleView.getTranslateY() + event.getY());
		                
		                Module module = moduleView.getItem();
		             
		                content.putString(module.getName());
		                
		                System.out.println(content);
	
		                db.setContent( content );
		                event.consume();
		            });
					
					moduleView.setOnMousePressed(new EventHandler<MouseEvent>() {
				        @Override
				        public void handle(MouseEvent event) {
				          
				        	mouseX = event.getX();
				        	mouseY = event.getY();
				        	
				        }
				    });
					
					moduleView.setOnMouseReleased(new EventHandler<MouseEvent>() {
				        @Override
				        public void handle(MouseEvent event) {
				          
				        	if (event.getX() == mouseX && event.getY() == mouseY) {
					        	
				        		viewManager.getMainViewController().putModuleViewOnStack(moduleView.getItem());
				        		
				        	}
				        	
				        }
				    });
			
					return moduleView;
				}   			
    		});
    	    			
    		Label semesterLabel = new Label(Integer.toString(i));
			semesterLabel.getStyleClass().add("numberSemester");
			semesterLabel.setMinSize(50, 50);
			semesterLabel.setAlignment(Pos.CENTER);
    		semesterRow = new HBox(semesterLabel,semesterListView);
			semesterRow.setAlignment(Pos.CENTER);
			semesterRow.setSpacing(20);
    		// semesterListView.getStyleClass().add("test-border-red");
    		// semesterRow.getStyleClass().add("test-border-red");
    		
    		HBox.setHgrow(semesterListView, Priority.ALWAYS);
    		
    		semesterListViews.add(semesterListView);
    		
    		planBox.getChildren().add(semesterRow);
    		
    	}
    	
    }

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		
		
		switch (event.getPropertyName()) {
			case "semesterCurrent":
				
				Module module = (Module)event.getSource();

				System.out.println("currentSemester Update " + event);
				moduleMapWithObservables.get(event.getOldValue()).remove(module);
				moduleMapWithObservables.get(event.getNewValue()).add(module);	
			break;
			
			case "bestanden": 
				plan.calculateAverage();
				generateListView();
				
			break;
			
			default:
				throw new IllegalArgumentException("UnbehandeltesEvent " + event);
		}
		
		
	
		
	}

}
 