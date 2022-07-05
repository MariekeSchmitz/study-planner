package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.OfferedTime;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;


 /**
     * validates each Module in relation to their OfferedTime
    */
public class CorrectSemesterValidator implements Validator  {

    private String className;	
	private String name;
    private String message;
    private String description;


    public CorrectSemesterValidator(){
        this.className = getClass().getName();
		this.name = "Angebotsfrequenz der Module";
		this.description = "Module können auch unregelmäßig (z.B. nur alle zwei Semester) angeboten werden. Nach Verstoßen dieser Einschränkung wird dein Plan nach jeder Änderung geprüft.";
        this.message = "Das Modul wird nur jährlich angeboten. ";
    }
    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void validate(Plan plan) {
        
        List<Module> moduleList = plan.getModuleList();

        for (Module module:moduleList){
            OfferedTime offeredTime = module.getOfferedIn();
            int currentSemester = module.getSemesterCurrent();
            int defaultSemester = module.getSemesterDefault();

            if (offeredTime == OfferedTime.YEARLY){
                if ((currentSemester + defaultSemester) % 2 != 0){
                    module.setValid(false);
                    module.setNote("Das Modul wird im " + module.getSemesterCurrent() + ". nicht angeboten.");
                } else {
                    if (module.isValid()) {
                        module.setValid(true);
                        module.resetNote();
                    } 
                }
            }
        }

        
        
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
