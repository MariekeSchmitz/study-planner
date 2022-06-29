package de.hsrm.mi.swt.SPAsS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.TestClassGenerator;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

public class ModuleTest {
    Plan p = new TestClassGenerator().plan;

    @Test
    public void testMoveModule(){
        Module m = p.getModuleByName("Analysis");
        int defSemOld = m.getSemesterDefault();
        int curSemOld = m.getSemesterCurrent();
        m.move(curSemOld+1);
        assertEquals(m.getSemesterCurrent(), curSemOld+1);
        assertEquals(m.getSemesterDefault(), defSemOld);
    }

    @Test
    public void testResetSemester(){
        Module m = p.getModuleByName("Analysis");
        int defSemOld = m.getSemesterDefault();
        int curSemOld = m.getSemesterCurrent();
        m.move(curSemOld+1);
        m.semesterReset();
        assertEquals(m.getSemesterCurrent(), defSemOld);
    }

    @Test
    public void testCoursePassed(){
        Module m = p.getModuleByName("Analysis");
        for(Course c : m.getCourses()){
            c.getExam().setPassed(false);
        }
        assertFalse(m.isPassed());
        for(Course c : m.getCourses()){
            c.getExam().setPassed(true);
        }
        assertTrue(m.isPassed());
    }
}
