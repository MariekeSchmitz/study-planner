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
    private Button addKlausur;
    private Button removeSemester;

    public CenterView(){
        this.getStyleClass().add("center");

        vboxNumber = new VBox();
        vboxNumber.setPrefWidth(60);
        vboxNumber.setSpacing(15);
        vboxNumber.setAlignment(Pos.BOTTOM_CENTER);

        planPane = new VBox();
        this.getStyleClass().add("test-border-red");
        planPane.setAlignment(Pos.BOTTOM_LEFT);

        hBoxAdd = new HBox();
        hBoxAdd.setPrefHeight(40);
        hBoxAdd.setSpacing(10);

        addSemester = new Button("Semester hinzufügen");
        addSemester.getStyleClass().add("addSemester");
        addSemester.setMaxSize(1000, 40);

        removeSemester = new Button("Semester löschen");
        removeSemester.getStyleClass().add("removeSemester");
        removeSemester.setMaxSize(1000, 40);

        addKlausur = new Button("Zurücksetzen");
        addKlausur.setPrefSize(200,40);
        addKlausur.getStyleClass().add("buttons");

        HBox.setHgrow(addSemester, Priority.ALWAYS);
        HBox.setHgrow(addKlausur, Priority.ALWAYS);
        HBox.setHgrow(removeSemester, Priority.ALWAYS);
        hBoxAdd.getChildren().addAll(addSemester,removeSemester, addKlausur);

        AnchorPane.setLeftAnchor(hBoxAdd, 125.0);
        AnchorPane.setTopAnchor(hBoxAdd, 50.0);
        AnchorPane.setRightAnchor(hBoxAdd, 50.0);

        AnchorPane.setLeftAnchor(addSemester, 125.0);
        AnchorPane.setTopAnchor(addSemester, 50.0);
        AnchorPane.setRightAnchor(addSemester, 50.0);
        
        AnchorPane.setLeftAnchor(planPane, 125.0);
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
		return addKlausur;
	}

	public void setAddKlausur(Button addKlausur) {
		this.addKlausur = addKlausur;
	}
	
	
    
   
}
