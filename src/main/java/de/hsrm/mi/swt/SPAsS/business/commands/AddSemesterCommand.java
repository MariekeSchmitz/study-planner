package de.hsrm.mi.swt.SPAsS.business.commands;

import java.util.LinkedList;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

/**
 * Command for adding an additional semester
 */
public class AddSemesterCommand implements ICommand
{
  private Plan myPlan;

  public AddSemesterCommand(Plan p) {
    myPlan = p;
  }

  @Override
  public void execute() {
    int x = myPlan.getNumberSemester()+1;
    myPlan.getModuleMap().put(x, new LinkedList<>());
    myPlan.setNumberSemester(x);
  }

  @Override
  public void undo() {
    int x = myPlan.getNumberSemester()-1;
	  myPlan.getModuleMap().remove(myPlan.getNumberSemester());
    myPlan.setNumberSemester(x);
  }

  @Override
  public String describe() {
    return "Add Semester";
  }
}
