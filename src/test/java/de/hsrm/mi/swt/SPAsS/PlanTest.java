package de.hsrm.mi.swt.SPAsS;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.TestClassGenerator;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

public class PlanTest {
    Plan p = new TestClassGenerator().plan;

    @Test
    public void testCalculateSemesterDefault(){
        int i = 0;
        for(Module m :p.getModuleList()){
            if(m.getSemesterDefault()> i)i = m.getSemesterDefault();
        }
        assertEquals(p.getNumberSemester(), i);
    }

    @Test
    public void testGetModuleByName(){
        String a = "Analysis";
        Module m = p.getModuleByName(a);
        assertEquals(m.getName(), a);
    }
}
