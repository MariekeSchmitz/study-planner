package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

public class ProgressValidator implements Validator{
    private String className;
    private int progressValue;
    private String message;
    
    public ProgressValidator(int progressValue){
        this.className = getClass().getName();
        this.progressValue = progressValue;
        this.message = "Die Fortschrittsregelung ist verletzt.";
    }

    @Override
	public void validate(Plan plan) {
		
    	Map<Integer,List<Module>> moduleMap = plan.getModuleMap();
    	List<Module> moduleList = plan.getModuleList();
    	boolean progressValid = true;
    	int defaultSemester;
    	int currentSemester;
    	int neededSemester;

    	
    	// Module durchgehen 
    	// wenn default-Semester von Modul - progressValue < 1, dann weitergehen 
    	// wenn default-Semester - progressValue >0 ist, dann: 
    	
    	
    	// SWT --> Default-Semester 4, aktuelles Semester 6
    	
    	// default-Semester - progressValue = 1 --> man muss alles mit default-Semester 1 belegt haben
    	// alle Module durchgehen, die default-Semester 1 oder niedriger haben und gucken, ob das unter aktuelle Semester 6 haben
    	
    	
    	for (Module module: moduleList) {
    		
    		defaultSemester = module.getSemesterDefault();
    		currentSemester = module.getSemesterCurrent();
    		
    		neededSemester = defaultSemester - progressValue;
    		
    		if (neededSemester < 1) {
    			continue;
    		}
    		
    		
    		for (int i = currentSemester; i <= plan.getNumberSemester(); i++) {
    			
    			for (Module tempModule : moduleMap.get(i)) {
    				if (tempModule.getSemesterDefault() <= neededSemester) {			
    					progressValid = false;
    					break;
    				}   				
    			}
    			
    			if (!progressValid) {
    				break;
    			}
    			
    			}	
    		
    		if (!progressValid) {
				module.setValid(false);
    			module.setNote(this.message);
    			}
    		
    		progressValid = true;
    	}
    	
    	
		
	}
    
    @Override
    public String getClassName() {
        return className;
    }
    
    
}
