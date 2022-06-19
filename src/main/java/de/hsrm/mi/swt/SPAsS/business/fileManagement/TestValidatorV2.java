package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

public class TestValidatorV2 implements Validator {

    private String className;
    private int valueX;
    private String valueY;

    public TestValidatorV2(int valueX, String valueY){
        this.className = getClass().getName();
        this.valueX = valueX;
        this.valueY = valueY;
    }

    @Override
    public void validate() {
        if(valueX == 1 && valueY.equals("valid")) return;
    }

    @Override
    public String getClassName() {
        return className;
    }

    
}
