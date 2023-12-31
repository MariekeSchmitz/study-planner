package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.UIcomponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Small Visual Component for flagging Module as passed and filling in grade
 */
public class CoursesRowView extends HBox{

	private Label courseName = new Label();
	private CheckBox passedCheck = new CheckBox();
	private TextField gradeInput = new TextField();
	
	public CoursesRowView() {
		
		courseName = new Label();
		courseName.setStyle("-fx-font-size: 13px;"
				+ "-fx-font-family: 'Open Sans Bold', sans-serif;");
		
		courseName.setPrefWidth(3000);

		passedCheck = new CheckBox();
		passedCheck.setPadding(new Insets(0, 15, 0, 15));
		
		gradeInput = new TextField();
		gradeInput.setPrefWidth(50);
		gradeInput.setMinWidth(50);
		
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setPrefHeight(50);
		this.setMinHeight(50);
		this.setSpacing(25);
		this.getChildren().addAll(courseName, passedCheck, gradeInput);
		this.setStyle("-fx-background-color: rgb(246,246,246);");

	}


	public Label getCourseName() {
		return courseName;
	}


	public void setCourseName(Label courseName) {
		this.courseName = courseName;
	}


	public CheckBox getPassedCheck() {
		return passedCheck;
	}


	public void setPassedCheck(CheckBox passedCheck) {
		this.passedCheck = passedCheck;
	}


	public TextField getGradeInput() {
		return gradeInput;
	}


	public void setGradeInput(TextField gradeInput) {
		this.gradeInput = gradeInput;
	}	
	
}
