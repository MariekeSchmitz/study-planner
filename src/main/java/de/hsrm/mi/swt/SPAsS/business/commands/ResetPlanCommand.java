package de.hsrm.mi.swt.SPAsS.business.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

public class ResetPlanCommand implements ICommand{
    private Plan myPlan;
    List<ICommand> commands = new ArrayList<ICommand>();
    Map <Integer, List<Module>> moduleMap;

    public ResetPlanCommand(Plan p) {
        myPlan = p;
        moduleMap = myPlan.getModuleMap();
        
        int size;
        for (List <Module> semester : moduleMap.values()){
            size = semester.size();
            for (Module module: semester){
                if (module.getSemesterCurrent() != module.getSemesterDefault()){
                    commands.add(new MoveSemesterCommand(module, module.getSemesterDefault()));
                    size--;
                }             
            }

            if (size == 0){
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


