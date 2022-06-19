package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

public class Plan {

    private String name;
    private String curriculumName;
    private float averageGrade;
    private List <Module> moduleList;
    private List <Validator> validatorList;
    private Map<Integer,List<Module>> moduleMap;
    private int numberSemester;
    
    public Plan(String name, String curriculumName,List<Module> moduleList,List<Validator> validatorList, int numberSemester) {
        this.averageGrade = 0;
        this.name = name;
        this.curriculumName = curriculumName;
        this.moduleList = moduleList;
        this.validatorList = validatorList;
        this.numberSemester = numberSemester;
        this.moduleMap = new HashMap<>();
        calculateAverage();  
    }

    public void resetPlan(){

        for (Module module : moduleList) {
            module.semesterReset();
        }
     
        
    }
    
    public void updateModuleMap() {
    	for (int i = 1; i <= this.numberSemester; i++) {	
    		moduleMap.put(i, new LinkedList<>());    		
    	}
    	
    	for (Module module : moduleList) {   		
    		moduleMap.get(module.getSemesterCurrent()).add(module);   		
    	}
    }

    public void removeSemester(){
        this.numberSemester--;
    }
    
    public void addSemester(){
        this.numberSemester++;
    }

    public void calculateAverage(){
        int cp = 0;
        float grade = 0;
        for (Module module : moduleList) {
           
            if (module.isPassed()){
                cp += module.getCp();
                grade += module.getGrade() * module.getCp();
            }
        }
        if(cp != 0){
            this.averageGrade = grade/cp;
        }
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

	public float getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(float averageGrade) {
		this.averageGrade = averageGrade;
	}

	public List<Validator> getValidatorList() {
		return validatorList;
	}

	public void setValidatorList(List<Validator> validatorList) {
		this.validatorList = validatorList;
	}

	public int getNumberSemester() {
		return numberSemester;
	}

	public void setNumberSemester(int numberSemester) {
		this.numberSemester = numberSemester;
	}

	public Map<Integer, List<Module>> getModuleMap() {
		return moduleMap;
	}

	public void setModuleMap(Map<Integer, List<Module>> moduleMap) {
		this.moduleMap = moduleMap;
	}
	
	
    
	
    


    


}
