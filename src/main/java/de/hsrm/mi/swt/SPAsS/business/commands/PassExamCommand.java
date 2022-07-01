package de.hsrm.mi.swt.SPAsS.business.commands;

import java.beans.PropertyChangeSupport;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Exam;

public class PassExamCommand implements ICommand
{
  private Exam myExam;
  private Boolean passed;
  private float oldGrade;

  public PassExamCommand(Exam e, Boolean p) {
	 myExam = e;
	 passed = p;
	 oldGrade = myExam.getGrade();
  }

  @Override
  public void execute() {
	  
	  

	  if (passed) {
		  myExam.firePassedEvent(true);
	  } else {
		  myExam.firePassedEvent(false);
		  myExam.setGrade(0);
	  }
	  
	  
	  
  }

  @Override
  public void undo() {
	  
	  if (passed) {
		  myExam.firePassedEvent(false);
	  } else {
		  myExam.firePassedEvent(true);
		  myExam.setGrade(0);
	  }
  }
}
