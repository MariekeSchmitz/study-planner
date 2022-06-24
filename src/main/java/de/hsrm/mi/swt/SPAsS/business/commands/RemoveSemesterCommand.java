package de.hsrm.mi.swt.SPAsS.business.commands;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

public class RemoveSemesterCommand implements ICommand
{
  private Plan myPlan;

  public RemoveSemesterCommand(Plan p) {
    myPlan = p;
  }

  @Override
  public void execute() {
    myPlan.setNumberSemester(myPlan.getNumberSemester()-1);
  }

  @Override
  public void undo() {
    myPlan.setNumberSemester(myPlan.getNumberSemester()+1);
  }
}
