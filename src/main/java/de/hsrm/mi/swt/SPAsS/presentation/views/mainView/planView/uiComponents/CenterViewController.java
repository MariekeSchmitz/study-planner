package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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
	private Button savePanebackButton;

	
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
		save = new Button("Plan speichern");
		savePanebackButton = new Button();
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
		savePanebackButton.addEventHandler(ActionEvent.ACTION, e -> {
			centerView.getPlanNameInputPane().setVisible(false);
		});

		addExamButton.addEventHandler(ActionEvent.ACTION, e -> {

			viewManager.getMainViewController().putExamViewOnStack();

		});
		
		savePlanButton.addEventHandler(ActionEvent.ACTION, e -> {
			
			BorderPane borderPane = new BorderPane();
			borderPane.setStyle("-fx-background-color: transparent;");
			AnchorPane savePane = new AnchorPane();
			savePane.setStyle("-fx-background-color: rgb(255,255,255)");
			savePane.setMinHeight(300);
			savePane.setMaxHeight(500);
			savePane.setPrefHeight(500);
			
			ImageView ivIcon = new ImageView(new Image(File.separator+"images" + File.separator +"x.png"));
			ivIcon.setFitHeight(50);
			ivIcon.setFitWidth(50);
			savePanebackButton.setGraphic(ivIcon);
			savePanebackButton.getStyleClass().add("backButton");
			
			Label title = new Label("Wie soll dein");
			Label title1 = new Label("Plan heißen?");
			title.getStyleClass().add("header");
			title.setStyle("-fx-font-family: 'Open Sans Light', sans-serif; -fx-font-size: 45px;");
			title.setId("secondColorFont");

			title1.getStyleClass().add("header");
			title1.setStyle("-fx-font-family: 'Open Sans Bold', sans-serif; -fx-font-size: 45px;");
			title1.setId("secondColorFont");

			title.setWrapText(true);
			title.setTextAlignment(TextAlignment.LEFT);

			HBox inputSaveBox = new HBox(20);
			nameInput = new TextField(plan.getName());
			nameInput.setPrefSize(250, 50);
			nameInput.setMaxSize(250, 50);
			nameInput.getStyleClass().add("nameInput");
			
			save.getStyleClass().add("SaveButton");
			save.setPrefSize(200, 50);
			save.setMaxSize(200, 50);

			inputSaveBox.getChildren().addAll(nameInput,save);
			inputSaveBox.setAlignment(Pos.CENTER_LEFT);
			inputSaveBox.setPadding(new Insets(0,0,80,0));
			
			AnchorPane.setTopAnchor(title, 120.0);
			AnchorPane.setLeftAnchor(title, 100.0);
			AnchorPane.setRightAnchor(title, 100.0);
			
			AnchorPane.setTopAnchor(title1, 190.0);
			AnchorPane.setLeftAnchor(title1, 100.0);
			AnchorPane.setRightAnchor(title1, 100.0);
			
			AnchorPane.setTopAnchor(inputSaveBox, 310.0);
			AnchorPane.setLeftAnchor(inputSaveBox, 100.0);
			AnchorPane.setRightAnchor(inputSaveBox, 100.0);
			
			AnchorPane.setTopAnchor(savePanebackButton, 30.0);
	        AnchorPane.setRightAnchor(savePanebackButton, 30.0);
			
			savePane.getChildren().addAll(title,title1,inputSaveBox, savePanebackButton);
			borderPane.setCenter(savePane);
			//borderPane.setMinSize(600, 300);

			centerView.setPlanNameInputPane(borderPane);
			
			

		});
		
		save.addEventHandler(ActionEvent.ACTION, e -> {
			
			plan.setName(nameInput.getText());
			header.setText(plan.getName());

			FileManager fileManager = app.getFileManager();
			fileManager.fileSave(FileType.PLAN, plan);
			
			centerView.getPlanNameInputPane().setVisible(false);

		});


		addSemesterButton.addEventHandler(ActionEvent.ACTION, e -> {

			plan.addSemester();

		});

		removeSemesterButton.addEventHandler(ActionEvent.ACTION, e -> {

			plan.removeSemester();

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

			semesterListView = new SemesterList(moduleListObservable, i, plan);
			semesterListView.setItems(moduleListObservable);
			semesterListView.setOrientation(Orientation.HORIZONTAL);

			semesterListView.setCellFactory(new Callback<ListView<Module>, ListCell<Module>>() {

				@Override
				public ListCell<Module> call(ListView<Module> param) {

					ModuleView moduleView = new ModuleView();

					
					
					moduleViews.add(moduleView);


					moduleView.setOnDragDetected((MouseEvent event) -> {
						Dragboard db = moduleView.startDragAndDrop(TransferMode.MOVE);
						ClipboardContent content = new ClipboardContent();


						Module module = moduleView.getItem();

						content.putString(module.getName());

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
			
			
			for (SemesterList listView: semesterListViews) {
				listView.refresh();
			}

			
		break;
		case "average":
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
