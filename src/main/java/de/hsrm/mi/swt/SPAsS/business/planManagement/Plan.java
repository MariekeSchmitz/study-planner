package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

public class Plan {

    private String name;
    private String curriculumName;
    private float cpAverage;
    private List <Module> moduleList;
    private List <Validator> validatorList;

    
    
    
    public Plan(String name, String curriculumName, float cpAverage, List<Module> moduleList,List<Validator> validators) {
        this.name = name;
        this.curriculumName = curriculumName;
        this.cpAverage = cpAverage;
        this.moduleList = moduleList;
        this.validatorList = validators;
    }

    public void resetPlan(){

    }
    
    public void addSemester(){

    }

    public void calculateAverage(){

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
    public float getCpAverage() {
        return cpAverage;
    }
    public void setCpAverage(float cpAverage) {
        this.cpAverage = cpAverage;
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


    


}
