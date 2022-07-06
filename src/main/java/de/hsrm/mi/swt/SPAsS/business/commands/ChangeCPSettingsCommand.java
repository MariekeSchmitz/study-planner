package de.hsrm.mi.swt.SPAsS.business.commands;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.CpLimitValidator;

/**
 * Command for moving a module into another semester.
 */
public class ChangeCPSettingsCommand implements ICommand {

    private CpLimitValidator myCpValidator;
    private Plan myPlan;
    private int cpOld;
    private int cpNew;

    public ChangeCPSettingsCommand(Plan p, CpLimitValidator c,int cpLimit) {
		myCpValidator = c;
        cpOld = myCpValidator.getCpLimit();
        cpNew = cpLimit;
        myPlan = p;
	}

    @Override
    public void execute() {
        cpOld = myCpValidator.getCpLimit();
        myCpValidator.setCpLimit(cpNew);
        myPlan.validate();
    }

    @Override
    public void undo() {
        myCpValidator.setCpLimit(cpOld);
        myPlan.validate();
    }

    @Override
    public String describe() {
      return "Move Semester";
    }
    
}
