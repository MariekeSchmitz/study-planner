package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.UIcomponents;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class CoursesRowController extends ViewController{

	private CoursesRowView coursesRowView;
	private CheckBox passedCheckbox;
	private TextField gradeInput;
	private Course course;
	private Plan plan;
	private boolean hasExtraExam;
	private Module module;
	
	
	public CoursesRowController (Course course, Plan plan, boolean hasExtraExam, Module module) {
		
		this.module = module;
		this.course = course;
		this.plan = plan;
		this.hasExtraExam = hasExtraExam;
		
		coursesRowView = new CoursesRowView();
		rootView = coursesRowView;
		
		passedCheckbox = coursesRowView.getPassedCheck();
		gradeInput = coursesRowView.getGradeInput();
		
		initialise();
		
	}
	
	@Override
	public void initialise() {
		
		coursesRowView.getCourseName().setText(course.getName());
		passedCheckbox.setSelected(course.getExam().getPassed());
		
		
		if (module.getAssociatedModule() != null) {
			gradeInput.setVisible(true);
			passedCheckbox.setVisible(false);
		} else {
			if (hasExtraExam) {
				gradeInput.setVisible(false);
				passedCheckbox.setVisible(false);
				
			} else {
				if (course.getExam().isGradeAvailable()) {
					if (course.getExam().getGrade() != 0) {
						gradeInput.setText(Float.toString(course.getExam().getGrade()));
					} else {
						gradeInput.setText("");
					}		
					passedCheckbox.setVisible(false);
					gradeInput.setVisible(true);
			
				} else {
					gradeInput.setVisible(false);
					passedCheckbox.setVisible(true);
				}
			}
		}
		
		
		
		
		
		
		
		
				
		passedCheckbox.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				
				course.getExam().setPassed(newValue);
				
				if (!newValue) {
					gradeInput.setText("");
				}
				
			}
		});
		
		
		
		
		
		// TODO changeGradeCommand pattern einzeln und in Change Passed pattern einbauen
//		
		gradeInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
			
			if (!newValue) {
				
				if (gradeInput.getText().isEmpty() || gradeInput.getText().equals("0")) {
					passedCheckbox.setSelected(false);
				} else {
					
					try {
						course.getExam().setGrade(Float.parseFloat(gradeInput.getText()));
						passedCheckbox.setSelected(true);
						plan.calculateAverage();
					} catch(Exception e) {
						gradeInput.setText("");
					}
					
				}
			}
		});
		
		passedCheckbox.focusedProperty().addListener((observable, oldValue, newValue) -> {
			
			if (!newValue) {
				
				if (course.getExam().isGradeAvailable()) {
					
					if (gradeInput.getText().isEmpty() || gradeInput.getText().equals("0")|| !passedCheckbox.isSelected()) {
						passedCheckbox.setSelected(false);
						gradeInput.setText("");
					
					} else {
						
						try {
							course.getExam().setGrade(Float.parseFloat(gradeInput.getText()));
							passedCheckbox.setSelected(true);
							plan.calculateAverage();

							
						} catch(Exception e) {
							gradeInput.setText("");
						}
						
					}
				}
				
				
			}
			
		});
	}

}
