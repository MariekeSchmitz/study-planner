package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.OfferedTime;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

public class TestClassGenerator {
    
    Plan plan;

    public TestClassGenerator(){
		Module x = new Module("Prog 1", "Programmieren undso", 1, 1, OfferedTime.YEARLY, 6);
        Module y = new Module("Prog 2", "Advanced Programmieren undso", 2, 2, OfferedTime.YEARLY, 6);
        Module z = new Module("Prog 3", "Mega Advanced Programmieren undso", 2, 2, OfferedTime.YEARLY, 6);
        TestValidator t = new TestValidator(1, "valid");
        TestValidatorV2 t2 = new TestValidatorV2(1, "valid");
		List<Module> modules = new ArrayList<>();
		List<Validator> valids = new ArrayList<>();
		modules.add(x);
        modules.add(y);
        modules.add(z);
        valids.add(t);
        valids.add(t2);
		Plan p = new Plan("RandomName", "RandomCurriculumName", 1.2f, modules, valids);
        this.plan = p;
    }
}
