package de.hsrm.mi.swt.SPAsS.business.commands;

import java.util.LinkedList;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

public class AddSemesterCommand implements ICommand
{
  private Plan myPlan;

  public AddSemesterCommand(Plan p) {
    myPlan = p;
  }

  @Override
  public void execute() {
    myPlan.setNumberSemester(myPlan.getNumberSemester()+1);
    myPlan.getModuleMap().put(myPlan.getNumberSemester(), new LinkedList<>());
  }

  @Override
  public void undo() {
	myPlan.getModuleMap().remove(myPlan.getNumberSemester());
    myPlan.setNumberSemester(myPlan.getNumberSemester()-1);

  }
}
