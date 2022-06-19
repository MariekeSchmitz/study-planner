package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.List;

public class CpLimitValidator implements Validator {
    private String className;
    private String message;
    private int cpLimit;

    public CpLimitValidator(){
        this.className = getClass().getName();
    }

    @Override
    public ValidatorReturnObject validate(List <Module> moduleList) {
        return null;
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
