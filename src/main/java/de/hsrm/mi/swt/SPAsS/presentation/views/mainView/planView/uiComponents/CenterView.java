package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CenterView extends AnchorPane{
    
    private VBox vboxNumber;
    private HBox hBoxAdd;
    private VBox planPane;
    private Button addSemester;
    private Button resetPlan;
    private Button removeSemester;
    private Button addExam;


    public CenterView(){
        this.getStyleClass().add("center");

        vboxNumber = new VBox();
        vboxNumber.setPrefWidth(60);
        vboxNumber.setSpacing(15);
        vboxNumber.setAlignment(Pos.BOTTOM_CENTER);

        planPane = new VBox();
        planPane.setAlignment(Pos.BOTTOM_LEFT);

        hBoxAdd = new HBox();
        hBoxAdd.setPrefHeight(40);
        hBoxAdd.setSpacing(10);

        addSemester = new Button("Semester hinzufügen");
        addSemester.getStyleClass().add("addSemester");
        addSemester.setMaxSize(1000, 40);

        removeSemester = new Button("Semester löschen");
        removeSemester.getStyleClass().add("addSemester");
        removeSemester.setMaxSize(1000, 40);

        resetPlan = new Button("Zurücksetzen");
        resetPlan.setPrefSize(200,40);
        resetPlan.getStyleClass().add("buttons");
        
        addExam = new Button("Klausur hinzufügen");
        addExam.setPrefSize(200,40);
        addExam.getStyleClass().add("buttons");

        HBox.setHgrow(addSemester, Priority.ALWAYS);
        HBox.setHgrow(resetPlan, Priority.ALWAYS);
        HBox.setHgrow(removeSemester, Priority.ALWAYS);
        HBox.setHgrow(addExam, Priority.ALWAYS);

        hBoxAdd.getChildren().addAll(addSemester,removeSemester, resetPlan, addExam);

        AnchorPane.setLeftAnchor(hBoxAdd, 125.0);
        AnchorPane.setTopAnchor(hBoxAdd, 50.0);
        AnchorPane.setRightAnchor(hBoxAdd, 50.0);

        AnchorPane.setLeftAnchor(addSemester, 125.0);
        AnchorPane.setTopAnchor(addSemester, 50.0);
        AnchorPane.setRightAnchor(addSemester, 50.0);
        
        AnchorPane.setLeftAnchor(planPane, 75.0);
        AnchorPane.setTopAnchor(planPane, 100.0);
        AnchorPane.setBottomAnchor(planPane, 50.0);
        AnchorPane.setRightAnchor(planPane, 50.0);

        AnchorPane.setLeftAnchor(vboxNumber, 50.0);
        AnchorPane.setTopAnchor(vboxNumber, 100.0);
        AnchorPane.setBottomAnchor(vboxNumber, 50.0);

        this.getChildren().addAll(vboxNumber, planPane, hBoxAdd);
    }

	public VBox getVboxNumber() {
		return vboxNumber;
	}

	public void setVboxNumber(VBox vboxNumber) {
		this.vboxNumber = vboxNumber;
	}

	public HBox gethBoxAdd() {
		return hBoxAdd;
	}

	public void sethBoxAdd(HBox hBoxAdd) {
		this.hBoxAdd = hBoxAdd;
	}

	public VBox getPlanBox() {
		return planPane;
	}

	public void setPlanPane(StackPane plan) {
		this.planPane = planPane;
	}

	public Button getAddSemester() {
		return addSemester;
	}

	public void setAddSemester(Button addSemester) {
		this.addSemester = addSemester;
	}

    public Button getRemoveSemester(){
        return removeSemester;
    }

	public Button getAddKlausur() {
		return resetPlan;
	}

	public void setAddKlausur(Button addKlausur) {
		this.resetPlan = addKlausur;
	}

	public VBox getPlanPane() {
		return planPane;
	}

	public Button getResetPlan() {
		return resetPlan;
	}

	public Button getAddExam() {
		return addExam;
	}
	
	
	
	
    
   
}
