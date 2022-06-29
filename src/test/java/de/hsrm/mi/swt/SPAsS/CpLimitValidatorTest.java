package de.hsrm.mi.swt.SPAsS;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.TestClassGenerator;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.CpLimitValidator;

public class CpLimitValidatorTest {
    Plan p = new TestClassGenerator().plan;
    CpLimitValidator cv = new CpLimitValidator(30);

    @Test
    public void testValidatorForPlan(){
        int cpCount = 0;
        for(Module m : p.getModuleMap().get(1)){
            cpCount += m.getCp();
        }
        cv = new CpLimitValidator(cpCount);
        cv.validate(p);
        for (Module m : p.getModuleMap().get(1)) {
            assertTrue(m.isValid());
        }

        cv = new CpLimitValidator(cpCount-1);
        cv.validate(p);
        for (Module m : p.getModuleMap().get(1)) {
            assertFalse(m.isValid());
        }
    }
}
