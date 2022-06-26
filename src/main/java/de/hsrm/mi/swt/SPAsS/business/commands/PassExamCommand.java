package de.hsrm.mi.swt.SPAsS.business.commands;

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
		  myExam.getPassed().set(true); 
	  } else {
		  myExam.getPassed().set(false);
		  myExam.setGrade(0);
	  }
  }

  @Override
  public void undo() {
	  if (passed) {
		  myExam.getPassed().set(false);
		  myExam.setGrade(0);

	  } else {
		  myExam.getPassed().set(true); 
		  myExam.setGrade(oldGrade);

	  }
  }
}
