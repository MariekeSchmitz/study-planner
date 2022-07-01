package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ModuleInformationView extends AnchorPane{

	private VBox box;
	
	private VBox labelVBox;
    private Label moduleName;
    private Label category;
    private Label cp;

    private VBox warningBox;
    private Label noteWarningHeadline;
    private Text noteWarningText;
    
    private VBox coursesBox;

    private Label modulDescriptionHeadline;
    private Text moduleDescriptionText;
    
    private Label taughtCompetencesHeadline;
	private VBox taughtCompetencesVbox;
    
    private Label neededCompetencesHeadline;
	private VBox neededCompetencesVbox;
    
    private Label coursesHeadline;

    private Button backButton;

    public ModuleInformationView() {
        
    	moduleName = new Label("Modulname");
		moduleName.getStyleClass().add("ModuleHeader");
//		moduleName.autosize();
//		moduleName.setMinWidth(Region.USE_PREF_SIZE);

    	category = new Label("category");
		category.getStyleClass().add("categoryLabel");
    	cp = new Label("cp");
		cp.getStyleClass().add("categoryLabel");

    	noteWarningHeadline = new Label("Warnhinweise");
    	noteWarningText = new Text("warnhinweiseText");
    	warningBox = new VBox(noteWarningHeadline,noteWarningText);
		warningBox.setSpacing(10);
		warningBox.setPrefHeight(75);
		warningBox.setPadding(new Insets(5, 5, 5, 5));
		warningBox.getStyleClass().add("border-red");
    	
    	coursesHeadline = new Label("Lehrveranstaltung");
		coursesHeadline.getStyleClass().add("coursesHeadline");
    	coursesBox = new VBox(5);
    	
    	modulDescriptionHeadline = new Label("Modulbeschreibung");
		modulDescriptionHeadline.getStyleClass().add("coursesHeadline");
    	moduleDescriptionText = new Text("moduldescriptionTest");
    	
    	taughtCompetencesHeadline = new Label("Vermittelte Kompetenzen");
		taughtCompetencesHeadline.getStyleClass().add("coursesHeadline");
		taughtCompetencesVbox = new VBox();
    	
    	neededCompetencesHeadline = new Label("Benötigte Kompetenzen");
		neededCompetencesHeadline.getStyleClass().add("coursesHeadline");
		neededCompetencesVbox = new VBox();

        backButton = new Button("back");
		backButton.getStyleClass().add("backbutton");
		backButton.setPrefSize(100, 100);
        backButton.setMaxSize(50, 50);

		box = new VBox(coursesHeadline, coursesBox, modulDescriptionHeadline, moduleDescriptionText, taughtCompetencesHeadline, taughtCompetencesVbox, neededCompetencesHeadline, neededCompetencesVbox);
		box.setMaxWidth(400);
		box.setSpacing(10);
		box.setAlignment(Pos.TOP_LEFT);
		box.setPadding(new Insets(10, 10, 10, 10));

		labelVBox = new VBox(category, cp);
		labelVBox.setSpacing(5);

		AnchorPane.setTopAnchor(moduleName, 75.0);
        AnchorPane.setLeftAnchor(moduleName, 60.0);
		AnchorPane.setRightAnchor(moduleName, 150.0);
		moduleName.setMaxWidth(300);

		AnchorPane.setTopAnchor(labelVBox, 130.0);
        AnchorPane.setLeftAnchor(labelVBox, 60.0);
		AnchorPane.setRightAnchor(labelVBox, 150.0);

		AnchorPane.setTopAnchor(warningBox, 200.0);
        AnchorPane.setLeftAnchor(warningBox, 60.0);
		AnchorPane.setRightAnchor(warningBox, 50.0);

		AnchorPane.setTopAnchor(backButton, 30.0);
        AnchorPane.setRightAnchor(backButton, 50.0);
    
        AnchorPane.setTopAnchor(box, 300.0);
		AnchorPane.setLeftAnchor(box, 50.0);
		AnchorPane.setRightAnchor(box, 50.0);
		AnchorPane.setBottomAnchor(box, 0.0);

        this.getChildren().addAll(box, backButton, moduleName, labelVBox, warningBox);
        
		//this.getStylesheets().add(getClass().getResource("moduleInformationView.css").toExternalForm());
        this.setStyle( "-fx-background-color:rgb(255,255,255)");	
		this.getStyleClass().add("test-border-red");
        this.setMaxWidth(600);
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

	public Text getModuleDescriptionText() {
		return moduleDescriptionText;
	}

	public void setModuleDescriptionText(Text moduleDescriptionText) {
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

	public Text getNoteWarningText() {
		return noteWarningText;
	}

	public void setNoteWarningText(Text noteWarningText) {
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
	
	
	
	
    
    

}
