package de.hsrm.mi.swt.SPAsS;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.TestClassGenerator;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.CompetenceValidator;

public class CompetenceValidatorTest {
    
    Plan p = new TestClassGenerator().plan;
    CompetenceValidator cv = new CompetenceValidator();

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
        p.getModuleByName("Analysis").move(5);
        p.getModuleByName("Lineare Algebra").move(5);
        cv.validate(p);
        assertFalse(p.getModuleByName("Angewandte Mathematik").isValid()); 
        resetModuleValidity();
        p.getModuleByName("Lineare Algebra").move(2); 
        cv.validate(p);
        assertFalse(p.getModuleByName("Angewandte Mathematik").isValid()); 
        resetModuleValidity();
        p.getModuleByName("Analysis").move(2);      
        cv.validate(p);  
        assertTrue(p.getModuleByName("Angewandte Mathematik").isValid());
        assertFalse(p.getModuleByName("Lineare Algebra").isValid());
    }

private void resetModuleValidity(){
    for(Module m : p.getModuleList()){
        m.setValid(true);
    }
    p.updateModuleMap();
}

    
}
