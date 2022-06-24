package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

public class CpLimitValidator implements Validator {
    
	private String className;
	
    private String message;
    private int cpLimit;
 
    public CpLimitValidator(int cpLimit){
        this.className = getClass().getName();
        this.cpLimit = cpLimit;
        
        this.message = "Dein CP-Limit von " + cpLimit + " pro Semester wurde missachtet.";
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
    		
    		if (tempCP > this.cpLimit) {
    			
    			for (Module module : tempList) {
        			module.setValid(false);
        			module.setNote(this.message);
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
        
    }


    @Override
    public String getClassName() {
        return className;
    }
    
    
}
