package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.List;

public class CompetenceValidator implements Validator{

    private String className;

    public CompetenceValidator(){
        this.className = getClass().getName();
    }

    @Override
    public ValidatorReturnObject validate(List <Module> moduleList) {
        return null; 
    }

    @Override
    public String getClassName() {
        return className;
    }
    
}
