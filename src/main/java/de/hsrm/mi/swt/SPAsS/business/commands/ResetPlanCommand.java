package de.hsrm.mi.swt.SPAsS.business.commands;

import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

public class ResetPlanCommand implements ICommand{
    private Plan myPlan;
    List<ICommand> commands = new ArrayList<ICommand>();

    public ResetPlanCommand(Plan p) {
        myPlan = p;
        for(Module m : p.getModuleList()){
            commands.add(new MoveSemesterCommand(m, m.getSemesterDefault()));
        }
    }

    @Override
    public void execute() {
        for (ICommand iCommand : commands) {
            iCommand.execute();
        }
    }

    @Override
    public void undo() {
        for (int i = commands.size()-1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
