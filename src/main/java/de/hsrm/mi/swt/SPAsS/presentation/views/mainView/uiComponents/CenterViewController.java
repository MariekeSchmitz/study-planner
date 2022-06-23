package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.CategoryEnum;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Competence;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Exam;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamType;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.OfferedTime;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


public class CenterViewController extends ViewController{

    private CenterView centerView;
    private Plan plan;
    private Map<Integer,List<Module>> moduleMap;
    private int numSemester;
    private VBox planBox;
    private Button testButton;

    public CenterViewController(Plan plan) {
        
    	centerView = new CenterView();
    	rootView = centerView;
    	
    	this.plan = plan;
    	this.moduleMap = plan.getModuleMap();
    	
    	this.numSemester = plan.getNumberSemester();
    	
    	planBox = centerView.getPlanBox();
    	
    	testButton = centerView.getAddKlausur();
    
    	
    	generateListView();
    	
    	
    	
    	
    	initialise();
    	
    	
    	
    	
    }

    @Override
    public void initialise() {
    	
    	 List<Competence> neededCompetences = new ArrayList<>();
         Competence c = new Competence("KernKompetenz1");
         neededCompetences.add(c);

         List<Course> courses = new ArrayList<>();
         Exam a = new Exam(1, ExamType.EXAM, OfferedTime.BI_YEARLY, 2, true);
         Course course = new Course("", 3, a, neededCompetences);
         courses.add(course);
         

         CategoryEnum infl = CategoryEnum.GESTALTUNG;
         CategoryEnum gestl = CategoryEnum.INFORMATIK;
         CategoryEnum infgestl = CategoryEnum.SONSTIGES;
         CategoryEnum fql = CategoryEnum.INFORMATIK;
         CategoryEnum mathl = CategoryEnum.MATHE;
    	
    	testButton.addEventHandler(ActionEvent.ACTION, e -> {
    		
    		List<Module> testList = moduleMap.get(1);
    		testList.add(new Module("Programmieren 1", "Programmieren undso", 1, 1, OfferedTime.YEARLY, 7, courses, neededCompetences, infl, true, ""));
    		testList.get(2).setName("TOMW");
    		generateListView();    		
    		
    	});
    	
    	
    }   
    
    
    private void generateListView() {
    	
    	ObservableList<Module> moduleListObservable;
    	SemesterList semesterListView;
    	HBox semesterRow;
    	
		planBox.getChildren().clear();

    
    	for (int i = numSemester; i > 0; i--) {
    		
    		moduleListObservable = FXCollections.observableList(moduleMap.get(i));
    		moduleMap.put(i, moduleListObservable);
    		semesterListView = new SemesterList(moduleListObservable);
    		semesterListView.setItems(moduleListObservable);
    		semesterListView.setOrientation(Orientation.HORIZONTAL);
    		
    		semesterListView.setCellFactory(new Callback<ListView<Module>, ListCell<Module>>() {

				@Override
				public ListCell<Module> call(ListView<Module> param) {
					
					ModuleView moduleView = new ModuleView();
					
					moduleView.setOnDragDetected(( MouseEvent event ) ->
		            {
		                System.out.println( "listcell setOnDragDetected" );
		                Dragboard db = moduleView.startDragAndDrop( TransferMode.MOVE);
		                ClipboardContent content = new ClipboardContent();
		                //content.put(null, semesterRow)
		                db.setContent( content );
		                event.consume();
		            });
					
					return moduleView;
				}
    			
    		});
    		
    		semesterRow = new HBox(new Label(Integer.toString(i)),semesterListView);
    		semesterListView.getStyleClass().add("test-border-red");
    		semesterRow.getStyleClass().add("test-border-red");
    		
    		HBox.setHgrow(semesterListView, Priority.ALWAYS);
    		
    		planBox.getChildren().add(semesterRow);
    		
    	}
    	
    }

}
 