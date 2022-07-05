package de.hsrm.mi.swt.SPAsS.business.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
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
        
        int semDiff = myPlan.getNumberSemester()-myPlan.getNumberSemesterDefault();
        if(semDiff<0){
            for (int i = 0; i > semDiff; i--) {
                commands.add(new AddSemesterCommand(p));
            }
        }

        for (Integer semester : moduleMap.keySet()){
            
            for (Module module: moduleMap.get(semester)){
                if (module.getSemesterCurrent() != module.getSemesterDefault()){
                    commands.add(new MoveSemesterCommand(module, module.getSemesterDefault()));
                }      
                for (Course c : module.getCourses()) {
                    if(c.getExam().isGradeAvailable()) commands.add(new SetGradeCommand(c.getExam(), 0));
                    else commands.add(new SetPassedForNonExamCommand(c.getExam(), false));
                }       
            }
        }
        if(semDiff>0){
            for (int i = 0; i < semDiff; i++) {
                commands.add(new RemoveSemesterCommand(p));
            }
        }
    }

    @Override
    public void execute() {
        for (ICommand iCommand : commands) {
            iCommand.execute();
        }
        myPlan.setNumberSemester(myPlan.getNumberSemester());
    }

    @Override
    public void undo() {
        for (int i = commands.size()-1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

    @Override
    public String describe() {
      return "Reset Plan";
    }
}


