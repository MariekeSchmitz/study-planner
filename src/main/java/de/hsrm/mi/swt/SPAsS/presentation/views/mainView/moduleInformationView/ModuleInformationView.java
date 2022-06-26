package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView;

import java.awt.Color;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ModuleInformationView extends AnchorPane{

	private VBox box;
	
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
    private Text taughtCompetencesText;
    
    private Label neededCompetencesHeadline;
    private Text neededCompetencesText;
    
    private Label coursesHeadline;


    private Button backButton;

    public ModuleInformationView() {
        
    	
    	
    	moduleName = new Label("Modulname");
    	category = new Label("category");
    	cp = new Label("cp");
    	
    	noteWarningHeadline = new Label("Warnhinweise");
    	noteWarningText = new Text("warnhinweiseText");
    	warningBox = new VBox(noteWarningHeadline,noteWarningText);
    	
    	coursesHeadline = new Label("Lehrveranstaltung");
    	coursesBox = new VBox();
    	
    	modulDescriptionHeadline = new Label("Modulbeschreibung");
    	moduleDescriptionText = new Text("moduldescriptionTest");
    	
    	taughtCompetencesHeadline = new Label("Vermittelte Kompetenzen");
    	taughtCompetencesText = new Text("taughtCompetencesText");
    	
    	neededCompetencesHeadline = new Label("Benötigte Kompetenzen");
    	neededCompetencesText = new Text("neededCompetencesText");

        backButton = new Button("back");
        
        
        box = new VBox(moduleName, category, cp, warningBox, coursesHeadline,coursesBox, moduleDescriptionText, taughtCompetencesHeadline, taughtCompetencesText, neededCompetencesHeadline, neededCompetencesText, backButton);

        this.getChildren().add(box);
        
        
        
        this.setStyle( "-fx-background-color:rgb(255,255,255)");	
        
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

	public Text getTaughtCompetencesText() {
		return taughtCompetencesText;
	}

	public void setTaughtCompetencesText(Text taughtCompetencesText) {
		this.taughtCompetencesText = taughtCompetencesText;
	}

	public Label getNeededCompetencesHeadline() {
		return neededCompetencesHeadline;
	}

	public void setNeededCompetencesHeadline(Label neededCompetencesHeadline) {
		this.neededCompetencesHeadline = neededCompetencesHeadline;
	}

	public Text getNeededCompetencesText() {
		return neededCompetencesText;
	}

	public void setNeededCompetencesText(Text neededCompetencesText) {
		this.neededCompetencesText = neededCompetencesText;
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
	
	
	
	
    
    

}
