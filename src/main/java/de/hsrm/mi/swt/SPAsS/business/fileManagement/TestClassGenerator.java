package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Category;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Competence;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Exam;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamType;
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
        List<Competence> neededCompetences = new ArrayList<>();
        Competence c = new Competence("KernKompetenz1");
        neededCompetences.add(c);

        List<Course> courses = new ArrayList<>();
        Exam e = new Exam(1, ExamType.EXAM, OfferedTime.BI_YEARLY, 2, true);
        Course course = new Course("", 3, e, neededCompetences);
        courses.add(course);
        

        List <Category> categories = new ArrayList<>();
        Category cat = new Category("Informatik");
        categories.add(cat);

		List<Module> modules = new ArrayList<>();
        Module x = new Module("Prog 1", "Programmieren undso", 1, 1, OfferedTime.YEARLY, 6, courses, neededCompetences, categories, true, "");
        Module y = new Module("Prog 2", "Advanced Programmieren undso", 2, 2, OfferedTime.YEARLY, 6, courses, neededCompetences, categories, true, "");
        Module z = new Module("Prog 3", "Mega Advanced Programmieren undso", 2, 2, OfferedTime.YEARLY, 6, courses, neededCompetences, categories, true, "");
        modules.add(x);
        modules.add(y);
        modules.add(z);

		List<Validator> valids = new ArrayList<>();
        CompetenceValidator v1 = new CompetenceValidator();
        CpLimitValidator v2 = new CpLimitValidator(30);
        ProgressValidator v3 = new ProgressValidator(3);
        valids.add(v1);
        valids.add(v2);
        valids.add(v3);

		Plan p = new Plan("RandomName", "RandomCurriculumName", modules, valids, 3);
        p.updateModuleMap();
        this.plan = p;
    }
}
