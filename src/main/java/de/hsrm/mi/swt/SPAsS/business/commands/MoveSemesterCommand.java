package de.hsrm.mi.swt.SPAsS.business.commands;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

/**
 * Command for moving a module into another semester.
 */
public class MoveSemesterCommand implements ICommand {

    private Module myModule;
    private int semsterOld;
    private int semsterNew;

    public MoveSemesterCommand(Module m,int newSemester) {
		myModule = m;
        semsterNew = newSemester;
        semsterOld = m.getSemesterCurrent();
	}

    @Override
    public void execute() {
        semsterOld = myModule.getSemesterCurrent();
        myModule.setSemesterCurrent(semsterNew);
    }

    @Override
    public void undo() {
        myModule.setSemesterCurrent(semsterOld);
    }

    @Override
    public String describe() {
      return "Move Semester";
    }
    
}
