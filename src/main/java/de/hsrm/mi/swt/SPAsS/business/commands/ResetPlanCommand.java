package de.hsrm.mi.swt.SPAsS.business.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;


/**
 * Command for resetting Plan to default state
 */
public class ResetPlanCommand implements ICommand{
    private Plan myPlan;
    List<ICommand> commands = new ArrayList<ICommand>();
    Map <Integer, List<Module>> moduleMap;

    public ResetPlanCommand(Plan p) {
        myPlan = p;
        moduleMap = myPlan.getModuleMap();
        
        int maxSemester = myPlan.getNumberSemesterDefault();
        for (Integer semester : moduleMap.keySet()){
            
            for (Module module: moduleMap.get(semester)){
                if (module.getSemesterCurrent() != module.getSemesterDefault()){
                    commands.add(new MoveSemesterCommand(module, module.getSemesterDefault()));
                }             
            }

            if (semester > maxSemester){
                commands.add(new RemoveSemesterCommand(myPlan));
            }
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


