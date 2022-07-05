package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
/**
 * Middle part of the visual representation of a plan.
 */
public class CenterView extends AnchorPane{
    
    private VBox vboxNumber;
    private HBox hBoxAdd;
    private VBox planPane;
    private Button addSemester;
    private Button resetPlan;
    private Button savePlan;
    private Button removeSemester;
    private Button addExam;
    private Button backButton;
    private Button newPlanButton;
    
    private Label header;
    private Label pointAverage;

    private VBox buttonsBox;

    private Pane backgroundPane;
    private AnchorPane planNameInputPane;
    private ScrollPane scrollPane;

    public CenterView(){
    	
        //NameInputPane 
        planNameInputPane = new AnchorPane();
        planNameInputPane.setVisible(false);
        planNameInputPane.setStyle("-fx-background-color: transparent");
        
        newPlanButton = new Button();
        newPlanButton.getStyleClass().add("newPlanButton");
        newPlanButton.setId("secondColor");
        newPlanButton.setPrefSize(60,60);
        newPlanButton.setMaxSize(60,60);
		ImageView ivIconaddButton = new ImageView(new Image(File.separator+"images" + File.separator +"plus.png"));
		ivIconaddButton.setFitHeight(30);
		ivIconaddButton.setFitWidth(30);
		newPlanButton.setGraphic(ivIconaddButton);
        
        backButton = new Button();
        backButton.getStyleClass().add("BackgroundBackButton");
        
        planNameInputPane.getChildren().add(backButton);
        
        AnchorPane.setLeftAnchor(backButton, 0.0);
        AnchorPane.setTopAnchor(backButton, 0.0);
        AnchorPane.setRightAnchor(backButton,0.0);
        AnchorPane.setBottomAnchor(backButton, 0.0);

        // TopCenterView
        backgroundPane = new Pane();
        backgroundPane.getStyleClass().add("backgroundcenter");
        backgroundPane.setPrefHeight(500);
        backgroundPane.setMaxHeight(325);
        

        
        header = new Label("Dein Studienplan");
        header.getStyleClass().add("header");
	    header.setStyle("-fx-font-family: 'Open Sans Bold', sans-serif");

        pointAverage = new Label("Aktueller Notendurchschnitt:");
        pointAverage.getStyleClass().add("pointAverage");

        buttonsBox = new VBox();
        buttonsBox.setSpacing(10);

        resetPlan = new Button("Plan zurücksetzen");
        resetPlan.setPrefSize(200,40);
        resetPlan.getStyleClass().add("buttons");

        savePlan = new Button("Plan speichern");
        savePlan.setPrefSize(200,40);
        savePlan.getStyleClass().add("buttons");

        buttonsBox.getChildren().addAll(savePlan, resetPlan);

        this.getStyleClass().add("topcenter");
        
        //CenterView
        this.getStyleClass().add("center");

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
        
        addExam = new Button("Klausur hinzufügen");
        addExam.setPrefSize(200,40);
        addExam.getStyleClass().add("buttons");

        HBox.setHgrow(addSemester, Priority.ALWAYS);
        HBox.setHgrow(resetPlan, Priority.ALWAYS);
        HBox.setHgrow(removeSemester, Priority.ALWAYS);
        HBox.setHgrow(addExam, Priority.ALWAYS);
    
        hBoxAdd.getChildren().addAll(addSemester,removeSemester, addExam);

        scrollPane = new ScrollPane();
		scrollPane.setContent(planPane);
		scrollPane.fitToHeightProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
		scrollPane.setPannable(true);

        planPane.getStyleClass().add("backgroundtransparent");
        planPane.setSpacing(10);
        
        AnchorPane.setLeftAnchor(hBoxAdd, 155.0);
        AnchorPane.setTopAnchor(hBoxAdd, 330.0);
        AnchorPane.setRightAnchor(hBoxAdd, 50.0);

        AnchorPane.setLeftAnchor(scrollPane, 75.0);
        AnchorPane.setTopAnchor(scrollPane, 400.0);
        AnchorPane.setBottomAnchor(scrollPane, 50.0);
        AnchorPane.setRightAnchor(scrollPane, 50.0);

        AnchorPane.setLeftAnchor(backgroundPane, 0.0);
        AnchorPane.setTopAnchor(backgroundPane, 250.0);
        AnchorPane.setRightAnchor(backgroundPane,0.0);
        AnchorPane.setBottomAnchor(backgroundPane, 0.0);
        
        AnchorPane.setLeftAnchor(planNameInputPane, 0.0);
        AnchorPane.setTopAnchor(planNameInputPane, 0.0);
        AnchorPane.setRightAnchor(planNameInputPane,0.0);
        AnchorPane.setBottomAnchor(planNameInputPane, 0.0);

        AnchorPane.setTopAnchor(buttonsBox, 75.0);
        AnchorPane.setRightAnchor(buttonsBox, 50.0);

        AnchorPane.setTopAnchor(header, 75.0);
        AnchorPane.setLeftAnchor(header, 155.0);

        AnchorPane.setTopAnchor(pointAverage, 150.0);
        AnchorPane.setLeftAnchor(pointAverage, 155.0);
        
        AnchorPane.setRightAnchor(newPlanButton, 50.0);
        AnchorPane.setBottomAnchor(newPlanButton, 50.0);

        this.getChildren().addAll(backgroundPane, scrollPane, hBoxAdd, header, pointAverage, buttonsBox, planNameInputPane ,newPlanButton);
        this.getStylesheets().add(getClass().getResource("/css/mainView.css").toExternalForm());
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


    public VBox getPlanPane() {
        return planPane;
    }


    public void setPlanPane(VBox planPane) {
        this.planPane = planPane;
    }


    public Button getAddSemester() {
        return addSemester;
    }


    public void setAddSemester(Button addSemester) {
        this.addSemester = addSemester;
    }


    public Button getResetPlan() {
        return resetPlan;
    }


    public void setResetPlan(Button resetPlan) {
        this.resetPlan = resetPlan;
    }


    public Button getRemoveSemester() {
        return removeSemester;
    }


    public void setRemoveSemester(Button removeSemester) {
        this.removeSemester = removeSemester;
    }


    public Button getAddExam() {
        return addExam;
    }


    public void setAddExam(Button addExam) {
        this.addExam = addExam;
    }


    public Label getHeader() {
        return header;
    }


    public void setHeader(Label header) {
        this.header = header;
    }


    public Label getPointAverage() {
        return pointAverage;
    }


    public void setPointAverage(Label pointAverage) {
        this.pointAverage = pointAverage;
    }


    public VBox getButtonsBox() {
        return buttonsBox;
    }


    public void setButtonsBox(VBox buttonsBox) {
        this.buttonsBox = buttonsBox;
    }


    public Button getClear() {
        return savePlan;
    }


    public void setClear(Button clear) {
        this.savePlan = clear;
    }


	public Button getSavePlan() {
		return savePlan;
	}


	public void setSavePlan(Button savePlan) {
		this.savePlan = savePlan;
	}


	public AnchorPane getPlanNameInputPane() {
		return planNameInputPane;
	}


	public void setPlanNameInputPane(Pane planNameInputPane) {
		this.planNameInputPane.getChildren().add(planNameInputPane); 

        AnchorPane.setLeftAnchor(planNameInputPane, 350.0);
        AnchorPane.setTopAnchor(planNameInputPane, 200.0);
        AnchorPane.setRightAnchor(planNameInputPane,350.0);
        AnchorPane.setBottomAnchor(planNameInputPane, 200.0);
        
		this.planNameInputPane.setVisible(true);
	}


	public Button getBackButton() {
		return backButton;
	}


	public Button getNewPlanButton() {
		return newPlanButton;
	}
    
}
