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

    myPlan.getModuleMap().remove(myPlan.getNumberSemester());
    myPlan.setNumberSemester(myPlan.getNumberSemester()-1);
    

  }

  @Override
  public void undo() {
    myPlan.setNumberSemester(myPlan.getNumberSemester()+1);
    myPlan.getModuleMap().put(myPlan.getNumberSemester(), new LinkedList<>());
  }
}
