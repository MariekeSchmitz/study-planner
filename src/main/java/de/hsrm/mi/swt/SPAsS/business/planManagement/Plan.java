package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.commands.AddSemesterCommand;
import de.hsrm.mi.swt.SPAsS.business.commands.CommandManager;
import de.hsrm.mi.swt.SPAsS.business.commands.RemoveSemesterCommand;
import de.hsrm.mi.swt.SPAsS.business.commands.ResetPlanCommand;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;
import javafx.beans.property.SimpleFloatProperty;

public class Plan {

    private String name;
    private String curriculumName;
    private Float averageGrade;
    private List<Module> moduleList;
    private List<Validator> validatorList;
    private transient Map<Integer, List<Module>> moduleMap;
    private int numberSemesterCurrent;
    private int numberSemesterDefault;

    
    private transient final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    

    
    
    public Plan(String name, String curriculumName, List<Module> moduleList, List<Validator> validatorList,
            int numberSemester) {
        this.name = name;
        this.curriculumName = curriculumName;
        this.moduleList = moduleList;
        this.validatorList = validatorList;
        this.numberSemesterCurrent = numberSemester;
        this.moduleMap = new HashMap<>();
        updateModuleMap();
        this.numberSemesterDefault = calculateNumberSemesterDefault();
        
        calculateAverage();
        validate();
        
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
   

    private int calculateNumberSemesterDefault() {
    	
    	int max = 0;
    	
    	for(List<Module> moduleList : moduleMap.values()) {
    		
    		for (Module module : moduleList) {
    			
    			if (module.getSemesterDefault() > max) {
    				max = module.getSemesterDefault();
    			}
    			
    		}
    	} 
    	
    	return max;
    }
    
    
    
    public void resetPlan() {

        CommandManager.getInstance().execAndPush(new ResetPlanCommand(this));
        this.numberSemesterCurrent = numberSemesterDefault;
    }

    public void updateModuleMap() {
        for (int i = 1; i <= this.numberSemesterCurrent; i++) {
            moduleMap.put(i, new LinkedList<>());
        }

        for (Module module : moduleList) {
            moduleMap.get(module.getSemesterCurrent()).add(module);
        }
    }

    public void removeSemester() {
        if (checkLastSemesterEmpty()) {
            CommandManager.getInstance().execAndPush(new RemoveSemesterCommand(this));
            
        } 
        
        //TODO else Throw 
    }

    public void addSemester() {
        CommandManager.getInstance().execAndPush(new AddSemesterCommand(this));
        
        
    }

    public boolean checkLastSemesterEmpty() {
        
        return moduleMap.get(numberSemesterCurrent).isEmpty();

    }

    public void calculateAverage() {
        int cp = 0;
        float grade = 0;
        for (Module module : moduleList) {

            if (module.isPassed()) {
                cp += module.getCp();
                module.calcGrade();
                grade += module.getGrade() * module.getCp();
            }
        }
        if (cp != 0) {
        	setAverageGrade(grade/cp);
        } else {
        	setAverageGrade(0f);
        }
    }
    
    public Module getModuleByName(String name) {
    	
    	for(List<Module> moduleList : moduleMap.values()) {
    		
    		for (Module module : moduleList) {
    			
    			if (module.getName().equals(name)) {
    				return module;
    			}
    			
    		}
    	}
    	
    	return null;
    	
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public List<Validator> getValidators() {
        return validatorList;
    }

    public void setValidators(List<Validator> validators) {
        this.validatorList = validators;
    }



    public List<Validator> getValidatorList() {
        return validatorList;
    }

    public void setValidatorList(List<Validator> validatorList) {
        this.validatorList = validatorList;
    }
    
    public void validate () {
    	
    	
    	for (Module module : moduleList) {
    		module.setValid(true);
    		module.resetNote();
    	}
    	
    	for (Validator validator : this.validatorList) {
    		validator.validate(this);
    	}
    	
    	
    	
    }

    public int getNumberSemester() {
        return numberSemesterCurrent;
    }

    public void setNumberSemester(int numberSemester) {
        this.numberSemesterCurrent = numberSemester;
    }

    public Map<Integer, List<Module>> getModuleMap() {
        return moduleMap;
    }

    public void setModuleMap(Map<Integer, List<Module>> moduleMap) {
        this.moduleMap = moduleMap;
    }
    
    public void setAverageGrade(Float averageGrade) {
    	
    	var pre = this.averageGrade;
		this.averageGrade = averageGrade;
		this.pcs.firePropertyChange("average", pre, this.averageGrade);
		System.out.println("AverageGrade - set "+this.averageGrade);
    	
    }
    
    public Float getAverageGrade() {
    	return this.averageGrade;
    }
    

	public int getNumberSemesterCurrent() {
		return numberSemesterCurrent;
	}

	public void setNumberSemesterCurrent(int numberSemesterCurrent) {
		this.numberSemesterCurrent = numberSemesterCurrent;
	}

	public int getNumberSemesterDefault() {
		return numberSemesterDefault;
	}

	public void setNumberSemesterDefault(int numberSemesterDefault) {
		this.numberSemesterDefault = numberSemesterDefault;
	}
	
	
	
    
    

}
