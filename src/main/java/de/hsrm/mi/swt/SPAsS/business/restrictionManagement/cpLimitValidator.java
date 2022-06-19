package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.List;

public class cpLimitValidator implements Validator {
    private String message;
    private int cpLimit;



    @Override
    public void validate(List <Module> moduleList) {
        
        
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
    
    
}
