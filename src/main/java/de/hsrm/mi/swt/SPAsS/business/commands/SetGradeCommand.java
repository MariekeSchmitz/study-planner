package de.hsrm.mi.swt.SPAsS.business.commands;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Exam;

/**
 * command for setting the grade of an exam
 */
public class SetGradeCommand implements ICommand
{
  private Exam myExam;
  private float grade;
  private float oldGrade;


  public SetGradeCommand(Exam e, float g) {
	 myExam = e;
	 grade = g;
	 oldGrade = myExam.getGrade();
	 
  }

  @Override
  public void execute() {
		oldGrade = myExam.getGrade();
	  myExam.setGrade(grade);
	  if (grade == 0) {
		  myExam.setPassed(false);

	  } else {
		  myExam.setPassed(true);
	  }
  }

  @Override
  public void undo() {
	  myExam.setGrade(oldGrade);
	  if (oldGrade == 0) {
		  myExam.setPassed(false);
	  } else {
		  myExam.setPassed(true);
	  }
	  
  }

  @Override
  public String describe() {
    return "Set Grade";
  }
}
