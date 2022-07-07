package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * View for all details of single Module - opens after selection of Module on Plan
 */
public class ModuleInformationView extends AnchorPane{
	
	private VBox mainPane;
	private ScrollPane scrollPane;
	private AnchorPane anchorPane;

	private VBox box;
	
	private VBox labelVBox;
    private Label moduleName;
    private Label category;
    private Label cp;

    private VBox warningBox;
    private Label noteWarningHeadline;
    private Label noteWarningText;
    
    private VBox coursesBox;

    private Label modulDescriptionHeadline;
    private Label moduleDescriptionText;
    
    private Label taughtCompetencesHeadline;
	private VBox taughtCompetencesVbox;
    
    private Label neededCompetencesHeadline;
	private VBox neededCompetencesVbox;
    
    private Label coursesHeadline;

    private Button deleteExam;
    
    private Button backButton;
    
    private HBox labelHbox;
    private Label gradeLabel;
    
    private int topPadding = 30;
    private int leftPadding = 15;

   

    public ModuleInformationView() {
    	
    	mainPane = new VBox();
    	scrollPane = new ScrollPane();
    	anchorPane = new AnchorPane();
        
    	moduleName = new Label("Modulname");
		moduleName.getStyleClass().add("ModuleHeader");
		moduleName.setWrapText(true);
		moduleName.setPadding(new Insets(0, 0, 0, leftPadding));

    	category = new Label("category");
		category.getStyleClass().add("categoryLabel");
		category.setPadding(new Insets(10, 0, 0, leftPadding));

    	cp = new Label("cp");
		cp.getStyleClass().add("categoryLabel");
		cp.setPadding(new Insets(0, 0, 0, leftPadding));


    	noteWarningHeadline = new Label("Warnhinweise");
    	noteWarningHeadline.setId("noteWarningHeadline");
    	noteWarningText = new Label("warnhinweiseText");
    	noteWarningText.setId("noteWarningText");
		noteWarningText.setWrapText(true);
    	warningBox = new VBox(noteWarningHeadline,noteWarningText);
		warningBox.setSpacing(10);
		//warningBox.setPrefHeight(90);
		warningBox.setPadding(new Insets(15, 15, 15, 15));
		warningBox.getStyleClass().add("border-red");
		VBox.setMargin(warningBox, new Insets(topPadding, 60, 0, 0));
		
		gradeLabel = new Label("bestanden/Note");
		gradeLabel.getStyleClass().add("passedLabel");
		
		labelHbox = new HBox(gradeLabel);
		labelHbox.setAlignment(Pos.CENTER);
		
    	coursesHeadline = new Label("Modul besteht aus");
		coursesHeadline.getStyleClass().add("coursesHeadline");
    	coursesBox = new VBox(10);
    	
    	modulDescriptionHeadline = new Label("Modulbeschreibung");
		modulDescriptionHeadline.getStyleClass().add("coursesHeadline");
		modulDescriptionHeadline.setPadding(new Insets(topPadding, 0,0,0));
    	moduleDescriptionText = new Label("moduldescriptionTest");
		moduleDescriptionText.setWrapText(true);
    	
    	taughtCompetencesHeadline = new Label("Vermittelte Kompetenzen");
		taughtCompetencesHeadline.getStyleClass().add("coursesHeadline");
		taughtCompetencesHeadline.setPadding(new Insets(topPadding, 0,0,0));

		taughtCompetencesVbox = new VBox();
    	
    	neededCompetencesHeadline = new Label("Benötigte Kompetenzen");
		neededCompetencesHeadline.getStyleClass().add("coursesHeadline");
		neededCompetencesHeadline.setPadding(new Insets(topPadding, 0,0,0));
		neededCompetencesVbox = new VBox();
		

		ImageView ivIcon = new ImageView(new Image(File.separator+"images" + File.separator +"x.png"));
		ivIcon.setFitHeight(50);
		ivIcon.setFitWidth(50);
		backButton = new Button();
		backButton.setGraphic(ivIcon);
		backButton.getStyleClass().add("backButton");

        deleteExam = new Button("Klausur entfernen");
        deleteExam.setPrefSize(300, 100);
        deleteExam.setMaxSize(300, 50);
        deleteExam.getStyleClass().add("buttons");
        
        
        anchorPane.getChildren().addAll(coursesHeadline, labelHbox);
        
		box = new VBox(anchorPane, coursesBox, modulDescriptionHeadline, moduleDescriptionText, taughtCompetencesHeadline, taughtCompetencesVbox, neededCompetencesHeadline, neededCompetencesVbox, deleteExam);
		box.setMaxWidth(520);
		box.setSpacing(10);
		box.setAlignment(Pos.TOP_LEFT);
		box.setPadding(new Insets(topPadding ,0 ,0 ,leftPadding));
		VBox.setMargin(deleteExam, new Insets(30,0,30,0));

		labelVBox = new VBox(moduleName,category, cp);
		labelVBox.setSpacing(5);
		labelVBox.setMaxWidth(500);

		AnchorPane.setTopAnchor(labelHbox, 10.0);
		AnchorPane.setRightAnchor(labelHbox, 0.0);

		AnchorPane.setTopAnchor(warningBox, 270.0);
        AnchorPane.setLeftAnchor(warningBox, 40.0);
		AnchorPane.setRightAnchor(warningBox, 20.0); 

		AnchorPane.setTopAnchor(backButton, 30.0);
        AnchorPane.setRightAnchor(backButton, 30.0);
    
		mainPane.setPadding(new Insets(100, 0, 0, 65));
		
        AnchorPane.setTopAnchor(scrollPane, 0.0);
		AnchorPane.setLeftAnchor(scrollPane, 0.0);
		AnchorPane.setRightAnchor(scrollPane, 0.0);
		AnchorPane.setBottomAnchor(scrollPane, 0.0);

        mainPane.getChildren().addAll(labelVBox, box);
        mainPane.setMaxWidth(680);
        
        scrollPane.setContent(mainPane);
		scrollPane.fitToHeightProperty().set(false);
        scrollPane.fitToWidthProperty().set(true);
		scrollPane.setPannable(true);
		scrollPane.getStyleClass().add("scrollPane");

		
        this.getChildren().addAll(scrollPane, backButton);
        this.setEffect(new DropShadow(204,0,2, Color.rgb(49, 49, 64)));
		this.getStylesheets().add(getClass().getResource("/css/moduleInformationView.css").toExternalForm());
        this.setMaxWidth(680);
    }
    
   
 
	public Label getModuleName() {
		return moduleName;
	}

	public void setModuleName(Label moduleName) {
		this.moduleName = moduleName;
	}

	public Label getCategory() {
		return category;
	}

	public void setCategory(Label category) {
		this.category = category;
	}

	public Label getCp() {
		return cp;
	}

	public void setCp(Label cp) {
		this.cp = cp;
	}

	public Label getModulDescriptionHeadline() {
		return modulDescriptionHeadline;
	}

	public void setModulDescriptionHeadline(Label modulDescriptionHeadline) {
		this.modulDescriptionHeadline = modulDescriptionHeadline;
	}

	public Label getModuleDescriptionText() {
		return moduleDescriptionText;
	}

	public void setModuleDescriptionText(Label moduleDescriptionText) {
		this.moduleDescriptionText = moduleDescriptionText;
	}

	public Label getTaughtCompetencesHeadline() {
		return taughtCompetencesHeadline;
	}

	public void setTaughtCompetencesHeadline(Label taughtCompetencesHeadline) {
		this.taughtCompetencesHeadline = taughtCompetencesHeadline;
	}

	public Label getNeededCompetencesHeadline() {
		return neededCompetencesHeadline;
	}

	public void setNeededCompetencesHeadline(Label neededCompetencesHeadline) {
		this.neededCompetencesHeadline = neededCompetencesHeadline;
	}

	public Button getBackButton() {
		return backButton;
	}

	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}

	public VBox getBox() {
		return box;
	}

	public void setBox(VBox box) {
		this.box = box;
	}

	public VBox getWarningBox() {
		return warningBox;
	}

	public void setWarningBox(VBox warningBox) {
		this.warningBox = warningBox;
	}

	public Label getNoteWarningHeadline() {
		return noteWarningHeadline;
	}

	public void setNoteWarningHeadline(Label noteWarningHeadline) {
		this.noteWarningHeadline = noteWarningHeadline;
	}

	public Label getNoteWarningText() {
		return noteWarningText;
	}

	public void setNoteWarningText(Label noteWarningText) {
		this.noteWarningText = noteWarningText;
	}

	public VBox getCoursesBox() {
		return coursesBox;
	}

	public void setCoursesBox(VBox coursesBox) {
		this.coursesBox = coursesBox;
	}

	public Label getCoursesHeadline() {
		return coursesHeadline;
	}

	public void setCoursesHeadline(Label coursesHeadline) {
		this.coursesHeadline = coursesHeadline;
	}

	public VBox getLabelVBox() {
		return labelVBox;
	}

	public void setLabelVBox(VBox labelVBox) {
		this.labelVBox = labelVBox;
	}

	public VBox getTaughtCompetencesVbox() {
		return taughtCompetencesVbox;
	}

	public void setTaughtCompetencesVbox(VBox taughtCompetencesVbox) {
		this.taughtCompetencesVbox = taughtCompetencesVbox;
	}

	public VBox getNeededCompetencesVbox() {
		return neededCompetencesVbox;
	}

	public void setNeededCompetencesVbox(VBox neededCompetencesVbox) {
		this.neededCompetencesVbox = neededCompetencesVbox;
	}

	public Button getDeleteExam() {
		return deleteExam;
	}

	public void setDeleteExam(Button deleteExam) {
		this.deleteExam = deleteExam;
	}

	public HBox getLabelHbox() {
		return labelHbox;
	}

	public void setLabelHbox(HBox labelHbox) {
		this.labelHbox = labelHbox;
	}

	public VBox getMainPane() {
		return mainPane;
	}

	public void setMainPane(VBox mainPane) {
		this.mainPane = mainPane;
	}

}
