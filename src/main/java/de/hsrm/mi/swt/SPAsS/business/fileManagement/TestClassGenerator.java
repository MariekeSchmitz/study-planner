package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Category;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Competence;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.OfferedTime;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.CompetenceValidator;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.CpLimitValidator;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.ProgressValidator;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

public class TestClassGenerator {
    
    Plan plan;

    public TestClassGenerator(){
        List<Course> courses = new ArrayList<>();
        List<Competence> neededCompetences = new ArrayList<>();
        List <Category> categories = new ArrayList<>();
		Module x = new Module("Prog 1", "Programmieren undso", 1, 1, OfferedTime.YEARLY, 6, courses, neededCompetences, categories);
        Module y = new Module("Prog 2", "Advanced Programmieren undso", 2, 2, OfferedTime.YEARLY, 6, courses, neededCompetences, categories);
        Module z = new Module("Prog 3", "Mega Advanced Programmieren undso", 2, 2, OfferedTime.YEARLY, 6, courses, neededCompetences, categories);
        CompetenceValidator v1 = new CompetenceValidator();
        CpLimitValidator v2 = new CpLimitValidator();
        ProgressValidator v3 = new ProgressValidator();
		List<Module> modules = new ArrayList<>();
		List<Validator> valids = new ArrayList<>();
		modules.add(x);
        modules.add(y);
        modules.add(z);
        valids.add(v1);
        valids.add(v2);
        valids.add(v3);
		Plan p = new Plan("RandomName", "RandomCurriculumName", modules, valids, 1);
        this.plan = p;
    }
}
