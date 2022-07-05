package de.hsrm.mi.swt.SPAsS.business.commands;

import java.util.LinkedList;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

/**
 * Command for removing highest Semester from Plan
 */
public class RemoveSemesterCommand implements ICommand
{
  private Plan myPlan;

  public RemoveSemesterCommand(Plan p) {
    myPlan = p;
  }

  @Override
  public void execute() {
    int x = myPlan.getNumberSemester()-1;
	  myPlan.getModuleMap().remove(myPlan.getNumberSemester());
    myPlan.setNumberSemester(x);
  }

  @Override
  public void undo() {
    int x = myPlan.getNumberSemester()+1;
    myPlan.getModuleMap().put(x, new LinkedList<>());
    myPlan.setNumberSemester(x);
  }

  @Override
  public String describe() {
    return "Remove Semester";
  }
}
