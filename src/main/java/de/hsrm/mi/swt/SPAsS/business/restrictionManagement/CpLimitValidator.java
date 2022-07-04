package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

public class CpLimitValidator implements Validator {
    
	private String className;
	
	private String name;
    private String message;
    private int cpLimit;
    private String description;
 
    public CpLimitValidator(int cpLimit){
        this.className = getClass().getName();
		this.name = "CP-Limit Regel";
        this.cpLimit = cpLimit;
		this.description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."; 
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
