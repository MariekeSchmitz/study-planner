package de.hsrm.mi.swt.SPAsS;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.TestClassGenerator;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.ProgressValidator;

public class ProgressValidatorTest {
    Plan p = new TestClassGenerator().plan;
    ProgressValidator cv = new ProgressValidator(3);

    @Test
    public void testValidatorForValidPlan(){
        resetModuleValidity();
        cv.validate(p);
        for (Module m : p.getModuleList()) {
            assertTrue(m.isValid());
        }
    }

    @Test
    public void testValidatorForInvalidPlan(){
        resetModuleValidity();
        p.getModuleByName("Analysis").move(4);
        p.updateModuleMap();
        cv.validate(p);
        assertFalse(p.getModuleByName("Computergrafik").isValid()); 
        resetModuleValidity();
        p.getModuleByName("Analysis").move(5);
        p.updateModuleMap();
        cv.validate(p);
        assertFalse(p.getModuleByName("Computergrafik").isValid()); 
        resetModuleValidity();
        p.getModuleByName("Analysis").move(3);
        p.updateModuleMap();
        cv.validate(p);
        assertTrue(p.getModuleByName("Computergrafik").isValid()); 
    }

    private void resetModuleValidity(){
        for(Module m : p.getModuleList()){
            m.setValid(true);
        }
        p.updateModuleMap();
    }
}
