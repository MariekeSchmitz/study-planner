package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

public class TestValidator implements Validator {

    private String className;
    private int validationValueX;
    private String validationValueY;

    public TestValidator(int validationValueX, String validationValueY){
        this.className = getClass().getName();
        this.validationValueX = validationValueX;
        this.validationValueY = validationValueY;
    }

    @Override
    public void validate() {
        if(validationValueX == 1 && validationValueY.equals("valid")) return;
    }

    @Override
    public String getClassName() {
        return className;
    }

    
}
