package de.hsrm.mi.swt.SPAsS.business.commands;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Exam;

/**
 * command for setting the grade of an exam
 */
public class SetPassedForNonExamCommand implements ICommand
{
  private Exam myExam;
  private boolean passed;
  private boolean oldValue;


  public SetPassedForNonExamCommand(Exam e, boolean b) {
	 myExam = e;
	 passed = b;
	 oldValue = myExam.isPassed();
	 
  }

  @Override
  public void execute() {
	oldValue = myExam.isPassed();
	myExam.setPassed(passed);
  }

  @Override
  public void undo() {
	myExam.setPassed(oldValue);
  }

  @Override
  public String describe() {
    return "Set passed";
  }
}
