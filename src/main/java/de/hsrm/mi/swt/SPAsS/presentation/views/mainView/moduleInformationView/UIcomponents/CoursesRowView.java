package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.UIcomponents;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CoursesRowView extends HBox{

	Label courseName = new Label();
	CheckBox passedCheck = new CheckBox();
	TextField gradeInput = new TextField();
	
	
	public CoursesRowView() {
		courseName = new Label();
		passedCheck = new CheckBox();
		gradeInput = new TextField();
		
		this.getChildren().addAll(courseName,passedCheck,gradeInput);
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
