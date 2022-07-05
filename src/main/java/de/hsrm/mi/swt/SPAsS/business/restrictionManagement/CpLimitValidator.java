package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

 /**
     * validates each Module in relation to a certain user chosen CP-Threshold per semester
    */
public class CpLimitValidator implements Validator {
    
	private String className;
	
	private String name;
    private String message;
    private int cpLimit;
    private String description;
 
    public CpLimitValidator(int cpLimit){
        this.className = getClass().getName();
		this.name = "CP-Limit";
        this.cpLimit = cpLimit;
		this.description = "Du wirst immer darauf hingewiesen, wenn du in einem Semester dein persönliches CP-Limit übersteigst. Es soll schließlich auch nicht zu stressig werden.";
        this.message = "Dein Limit von " + cpLimit + " Creditpoints pro Semester wurde überschritten.";
    }

    @Override
	public void validate(Plan plan) {
		
    	int numSemester = plan.getNumberSemester();
    	Map<Integer,List<Module>> moduleMap = plan.getModuleMap();
    	
    	int tempCP = 0;
    	
    	for (List<Module> tempList : moduleMap.values()) {
    		
    		for (Module module : tempList) {
    			tempCP += module.getCp();
    		}
    		
    		for (Module module : tempList) {
    			
    			if (tempCP > this.cpLimit) {
    				module.setValid(false);
        			module.setNote("Dein Limit von " + cpLimit + " Creditpoints pro Semester wurde im " + module.getSemesterCurrent() + " überschritten. ");
    			
    			} else {
    				
    				if (module.isValid()) {
    					module.setValid(true);
    					module.resetNote();
    				}
    				
    			}
    		}
    		
    		
    		tempCP = 0;
    		
    	}
 		
	}


    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getCpLimit() {
        return cpLimit;
    }
    public void setCpLimit(int cpLimit) {
        this.cpLimit = cpLimit;
        this.message = "Dein Limit von " + cpLimit + " Creditpoints pro Semester wurde überschritten.";
        
    }


    @Override
    public String getClassName() {
        return className;
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
