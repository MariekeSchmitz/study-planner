package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;
/**
 * Controller for dynamically filling Centerview
 * Reacts to User Input and changes in Module-Object by refreshing visual components
 */
public class CenterViewController extends ViewController implements PropertyChangeListener {

	private CenterView centerView;
	private Plan plan;
	private Map<Integer, List<Module>> moduleMap;
	private int numSemester;
	private VBox planBox;
	private Button resetButton;
	private Button addSemesterButton;
	private Button removeSemesterButton;
	private Button addExamButton;
	private Button savePlanButton;
	private Button backButton;
	private Button newPlan;
	private Label gradeAverage;
	private Button save;
	private TextField nameInput;
	private Label header;
	
	private DataFormat dataFormat = new DataFormat("moduleCell");
	private List<SemesterList> semesterListViews;
	private List<ModuleView> moduleViews;
	private Map<Integer, ObservableList<Module>> moduleMapWithObservables;

	private double mouseX;
	private double mouseY;
	private ViewManager viewManager;
	private App app;

	public CenterViewController(Plan plan, ViewManager viewManager, App app) {

		centerView = new CenterView();
		rootView = centerView;

		this.plan = plan;
		this.app = app;
		plan.addPropertyChangeListener(this);

		this.moduleMap = plan.getModuleMap();

		this.semesterListViews = new LinkedList<>();
		this.moduleViews = new LinkedList<>();
		this.viewManager = viewManager;

		planBox = centerView.getPlanPane();

		resetButton = centerView.getResetPlan();
		addSemesterButton = centerView.getAddSemester();
		removeSemesterButton = centerView.getRemoveSemester();
		addExamButton = centerView.getAddExam();
		gradeAverage = centerView.getPointAverage();
		savePlanButton = centerView.getSavePlan();
		backButton = centerView.getBackButton();
		newPlan = centerView.getNewPlanButton();
		save = new Button("save");
		header = centerView.getHeader();


		initialise();

	}

	@Override
	public void initialise() {

		header.setText(plan.getName());
		
		
		generateListView();
		
		newPlan.addEventHandler(ActionEvent.ACTION, e -> {

			app.getFileManager().fileSave(FileType.PLAN, plan);
			viewManager.switchScene(Scenes.START_VIEW);

		});

		resetButton.addEventHandler(ActionEvent.ACTION, e -> {

			plan.resetPlan();
			plan.updateModuleMap();
			generateListView();

		});
		
		backButton.addEventHandler(ActionEvent.ACTION, e -> {
			centerView.getPlanNameInputPane().setVisible(false);
		});

		addExamButton.addEventHandler(ActionEvent.ACTION, e -> {

			viewManager.getMainViewController().putExamViewOnStack();

		});
		
		savePlanButton.addEventHandler(ActionEvent.ACTION, e -> {
			
			AnchorPane savePane = new AnchorPane();
			savePane.setStyle("-fx-background-color: rgb(255,255,255)");
			savePane.getStyleClass().add("test-border-red");
			savePane.setMaxSize(200, 500);
			savePane.setPrefSize(200, 500);
			
			
			
			Label title = new Label("Wie soll dein Plan heißen?");
			title.getStyleClass().add("header");
			title.setWrapText(true);
			title.getStyleClass().add("test-border-red");
			title.setAlignment(Pos.CENTER);
			title.setTextAlignment(TextAlignment.CENTER);

			HBox inputSaveBox = new HBox(20);
			nameInput = new TextField(plan.getName());
			inputSaveBox.getChildren().addAll(nameInput,save);
			inputSaveBox.setAlignment(Pos.CENTER);
			
			AnchorPane.setTopAnchor(title, 150.0);
			AnchorPane.setLeftAnchor(title, 100.0);
			AnchorPane.setRightAnchor(title, 100.0);
			
			AnchorPane.setTopAnchor(inputSaveBox, 300.0);
			AnchorPane.setLeftAnchor(inputSaveBox, 100.0);
			AnchorPane.setRightAnchor(inputSaveBox, 100.0);

			savePane.getChildren().addAll(title,inputSaveBox);
			
			centerView.setPlanNameInputPane(savePane);
			
			

		});
		
		save.addEventHandler(ActionEvent.ACTION, e -> {
			
			plan.setName(nameInput.getText());

			FileManager fileManager = app.getFileManager();
			fileManager.fileSave(FileType.PLAN, plan);
			System.out.println("Plan saved");
			
			centerView.getPlanNameInputPane().setVisible(false);

		});


		addSemesterButton.addEventHandler(ActionEvent.ACTION, e -> {

			plan.addSemester();
			//generateListView();

			System.out.println(moduleMap);

			System.out.println("addSemester");

		});

		removeSemesterButton.addEventHandler(ActionEvent.ACTION, e -> {

			plan.removeSemester();
			//generateListView();

			System.out.println(moduleMap);

			System.out.println("removeSemester");

		});

		for (List<Module> moduleList : moduleMap.values()) {

			for (Module module : moduleList) {

				module.addPropertyChangeListener(this);

				for (Course course : module.getCourses()) {

					course.getExam().addPropertyChangeListener(this);

				}
			}
		}

		for (ModuleView moduleView : moduleViews) {
			moduleView.getItem().addPropertyChangeListener(this);
		}

		if (plan.getAverageGrade() == 0.0f) {
    		gradeAverage.setText("Sobald du eine Prüfung bestanden hast, findest du hier deinen Notendurchschnitt.");
    	} else {
        	gradeAverage.setText("Aktueller Notendurchschnitt: " + Float.toString(plan.getAverageGrade()));
    	}

	}


	/**
 * Creates ListView for each each Semester and fills each with Modules Views
 * In the end all Modules will be correctly shown on screen
 * Also makes all Modules drag - and - clickable
 */
	public void generateListView() {

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

			semesterListView.setCellFactory(new Callback<ListView<Module>, ListCell<Module>>() {

				@Override
				public ListCell<Module> call(ListView<Module> param) {

					ModuleView moduleView = new ModuleView();

					
					
					moduleViews.add(moduleView);

//					moduleView.getItem().addPropertyChangeListener(this);

					moduleView.setOnDragDetected((MouseEvent event) -> {
						System.out.println("listcell setOnDragDetected");
						Dragboard db = moduleView.startDragAndDrop(TransferMode.MOVE);
						ClipboardContent content = new ClipboardContent();
//		                moduleView.setTranslateX(moduleView.getTranslateX() + event.getX());
//		                moduleView.setTranslateY(moduleView.getTranslateY() + event.getY());

						Module module = moduleView.getItem();

						content.putString(module.getName());

						System.out.println(content);

						db.setContent(content);
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
								if(moduleView.getItem()==null) return;
								viewManager.getMainViewController().putModuleViewOnStack(moduleView.getItem());
								System.out.println("Maus geklickt auf Modul");
							}

						}
					});

					return moduleView;
				}
			});

			Label semesterLabel = new Label(Integer.toString(i));
			semesterLabel.setStyle("-fx-font-family: 'Open Sans Bold', sans-serif");			
		    semesterLabel.getStyleClass().add("numberSemester");
			semesterLabel.setMinSize(50, 50);
			semesterLabel.setAlignment(Pos.CENTER);
			semesterRow = new HBox(semesterLabel, semesterListView);
			semesterRow.setAlignment(Pos.CENTER);
			semesterRow.setSpacing(20);


			HBox.setHgrow(semesterListView, Priority.ALWAYS);
			
			semesterListViews.add(semesterListView);

			planBox.getChildren().add(semesterRow);


		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {

		switch (event.getPropertyName()) {
		case "semesterCurrent":

			Module module = (Module) event.getSource();

			System.out.println("currentSemester Update " + event);
			moduleMapWithObservables.get(event.getOldValue()).remove(module);
			moduleMapWithObservables.get(event.getNewValue()).add(module);

			plan.validate();

			break;

		case "passed":
			plan.calculateAverage();
			generateListView();

			break;

		case "valid":
			
			Module m = (Module) event.getSource();
			
//			if (m instanceof ExamModule) {
//				m.getAssociatedExamModule().setValid((Boolean)event.getNewValue());
//			} else if (m.isHasExamModule()) {
//				m.getAssociatedExamModule().setValid((Boolean)event.getNewValue());
//			}
			
			for (SemesterList listView: semesterListViews) {
				listView.refresh();
			}
//			ModuleView mView = null;
//			
//			for (ModuleView moduleView : moduleViews) {
//				if (moduleView.getItem() == m) {
//					mView = moduleView;
//					break;
//				} 
//			}
//			
//			if ((Boolean)event.getNewValue()) {
//				mView.setId("valid");
//			} else {
//				mView.setId("invalid");
//			}
			
		break;
		case "average":
			System.out.println("AverageGrade Update " + event);
			if (plan.getAverageGrade() == 0.0f) {
				gradeAverage.setText("Sobald du eine Prüfung bestanden hast, findest du hier deinen Notendurchschnitt.");
			} else {
				gradeAverage.setText("Aktueller Notendurchschnitt: " + Float.toString(plan.getAverageGrade()));
			}
		break;
		case "semestercountChange":
			this.generateListView();
		break;
		default:
			throw new IllegalArgumentException("UnbehandeltesEvent " + event);
		}
		

		


	}

}
