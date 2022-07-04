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

/** 
	 * represents a users personal curriculum.
	 */
public class Plan {

    private String name;
    private String curriculumName;
    private Float averageGrade;
    private List<Module> moduleList;
    private List<Validator> validatorList;
    private transient Map<Integer, List<Module>> moduleMap;
    private int numberSemesterCurrent;
    private int numberSemesterDefault;
    private String studiengang;
    private String hochschule;

    
    private transient PropertyChangeSupport pcs = new PropertyChangeSupport(this);
   
    
    /** 
	 * Constructor
	 * @param name name of plan
	 * @param curriculumName name of curriculum from which this plan was created
	 * @param moduleList all modules of the plan
	 * @param validatorList all Validator that validate if the modules in this plan are valid 
	 * @param numberSemester the amount of semesters that are currently planned
	 * @param studiengang name of the programm that this plan belongs to
	 * @param hochschule  name of the University which the plan is for
	 */
    public Plan(String name, String curriculumName, List<Module> moduleList, List<Validator> validatorList,
            int numberSemester, String studiengang, String hochschule) {
        this.name = name;
        this.studiengang = studiengang;
        this.hochschule = hochschule;
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
    
    
    /** 
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    
    /** 
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
   
    
    
    /** 
     * calculates the needed amount of semesters.
     * @return int
     */
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
    
    
    /** 
     * resets all Modules back to their default semester
     */
    public void resetPlan() {

        CommandManager.getInstance().execAndPush(new ResetPlanCommand(this));
        this.numberSemesterCurrent = numberSemesterDefault;
    }
    
    public void initialize() {
    	
    	
    	pcs = new PropertyChangeSupport(this);
    	moduleMap = new HashMap<>();
    	this.updateModuleMap();
        this.numberSemesterDefault = calculateNumberSemesterDefault();
        calculateAverage();


    }
    /** 
     * updates the Map with up-to-date values
     */
    public void updateModuleMap() {
        for (int i = 1; i <= this.numberSemesterCurrent; i++) {
            moduleMap.put(i, new LinkedList<>());
        }

        for (Module module : moduleList) {
            moduleMap.get(module.getSemesterCurrent()).add(module);
        }
    }

    /** 
     * removes the highest semester from the plan
     */
    public void removeSemester() {
        if (checkLastSemesterEmpty()) {
            CommandManager.getInstance().execAndPush(new RemoveSemesterCommand(this));
            
        } 
        
        //TODO else Throw 
    }

    /** 
     * adds a semester to the plan
     */
    public void addSemester() {
        CommandManager.getInstance().execAndPush(new AddSemesterCommand(this));
        
        
    }

    
    /** 
     * checks whether there are modules in the highest semester
     * @return boolean
     */
    public boolean checkLastSemesterEmpty() {
        
        return moduleMap.get(numberSemesterCurrent).isEmpty();

    }

    /** 
     * calculates the average grade of all modules
     */
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
    
    
    /** 
     * returns a Module-Object that fits the given name 
     * @param name
     * @return Module
     */
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

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return String
     */
    public String getCurriculumName() {
        return curriculumName;
    }

    
    /** 
     * @param curriculumName
     */
    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    
    /** 
     * @return List<Module>
     */
    public List<Module> getModuleList() {
        return moduleList;
    }

    
    /** 
     * @param moduleList
     */
    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
//        updateModuleMap();

    }


    
    /** 
     * @return List<Validator>
     */
    public List<Validator> getValidatorList() {
        return validatorList;
    }

    
    /** 
     * @param validatorList
     */
    public void setValidatorList(List<Validator> validatorList) {
        this.validatorList = validatorList;
    }

    /** 
     * validates the entire plan by using Validator
     */
    public void validate () {
    	
    	
    	for (Module module : moduleList) {
    		module.setValid(true);
    		module.resetNote();
    	}
    	
    	for (Validator validator : this.validatorList) {
    		validator.validate(this);
    	}
    	
    	
    	
    }

    
    /** 
     * @return int
     */
    public int getNumberSemester() {
        return numberSemesterCurrent;
    }

    
    /** 
     * @param numberSemester
     */
    public void setNumberSemester(int numberSemester) {
        this.numberSemesterCurrent = numberSemester;
    }

    
    /** 
     * @return Map<Integer, List<Module>>
     */
    public Map<Integer, List<Module>> getModuleMap() {
        return moduleMap;
    }

    
    /** 
     * @param moduleMap
     */
    public void setModuleMap(Map<Integer, List<Module>> moduleMap) {
        this.moduleMap = moduleMap;
    }
    
    
    /** 
     * @param averageGrade
     */
    public void setAverageGrade(Float averageGrade) {
    	
    	var pre = this.averageGrade;
		this.averageGrade = averageGrade;
		this.pcs.firePropertyChange("average", pre, this.averageGrade);
		System.out.println("AverageGrade - set "+this.averageGrade);
    	
    }
    
    
    /** 
     * @return Float
     */
    public Float getAverageGrade() {
    	return this.averageGrade;
    }
    

	
    /** 
     * @return int
     */
    public int getNumberSemesterCurrent() {
		return numberSemesterCurrent;
	}

	
    /** 
     * @param numberSemesterCurrent
     */
    public void setNumberSemesterCurrent(int numberSemesterCurrent) {
		this.numberSemesterCurrent = numberSemesterCurrent;
	}

	
    /** 
     * @return int
     */
    public int getNumberSemesterDefault() {
		return numberSemesterDefault;
	}

	
    /** 
     * @param numberSemesterDefault
     */
    public void setNumberSemesterDefault(int numberSemesterDefault) {
		this.numberSemesterDefault = numberSemesterDefault;
	}
	
	
    /** 
     * adds Module to the Plan
     * @param semester
     * @param module
     */
    public void addModule (int semester, Module module){
		this.moduleMap.get(semester).add(module);
		this.moduleList.add(module);
	}
	
	
    /** 
     * removes Module from Plan
     * @param semester
     * @param module
     */
    public void removeModule (int semester, Module module){
		this.moduleMap.get(semester).remove(module);
		this.moduleList.remove(module);
	}

	
    /** 
     * @return String
     */
    public String getStudiengang() {
		return studiengang;
	}

	
    /** 
     * @param studiengang
     */
    public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	
    /** 
     * @return String
     */
    public String getHochschule() {
		return hochschule;
	}

	
    /** 
     * @param hochschule
     */
    public void setHochschule(String hochschule) {
		this.hochschule = hochschule;
	}
	
    /** 
     * completely removes all user planning to create default state of plan
     */
	 public void planToDefaultPlan() {
	    	
	    	this.initialize();

	    	this.setName(studiengang);
			
			for (Module module : moduleList) {
				module.setSemesterCurrent(module.getSemesterDefault());
				module.setValid(true);
				module.setPassed(false);
				module.setGrade(0);
				
				for (Course course : module.getCourses()) {
					course.getExam().setGrade(0);
					course.getExam().setPassed(false);
					course.setHasExtraExam(false);
				}

			
			}
			this.validate();
			this.initialize();
	    	
	    }
	
	

}
