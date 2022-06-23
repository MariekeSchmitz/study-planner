package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.planManagement.CategoryEnum;
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
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents.CenterViewController;

public class TestClassGenerator {
    
    public Plan plan;

    public TestClassGenerator(){
		List<Validator> valids = new ArrayList<>();
        CompetenceValidator v1 = new CompetenceValidator();
        CpLimitValidator v2 = new CpLimitValidator(30);
        ProgressValidator v3 = new ProgressValidator(3);
        valids.add(v1);
        valids.add(v2);
        valids.add(v3);

		Plan p = new Plan("Medieninformatik", "RandomCurriculumName", this.getModules(), valids, 5);
        p.updateModuleMap();
        this.plan = p;
        
        
    }

    private List<Module> getModules(){
        List<Competence> neededCompetences = new ArrayList<>();
        Competence c = new Competence("KernKompetenz1");
        neededCompetences.add(c);

        List<Course> courses = new ArrayList<>();
        Exam e = new Exam(1, ExamType.EXAM, OfferedTime.BI_YEARLY, 2, true);
        Course course = new Course("", 3, e, neededCompetences);
        courses.add(course);
        

        CategoryEnum infl = CategoryEnum.GESTALTUNG;
        CategoryEnum gestl = CategoryEnum.INFORMATIK;
        CategoryEnum infgestl = CategoryEnum.SONSTIGES;
        CategoryEnum fql = CategoryEnum.INFORMATIK;
        CategoryEnum mathl = CategoryEnum.MATHE;

        List<Module> modules = new ArrayList<>();
        Module prog1 = new Module("Programmieren 1", "Programmieren undso", 1, 1, OfferedTime.YEARLY, 7, courses, neededCompetences, infl, true, "");
        Module eidm = new Module("Einfuehrung in die Medieninformatik", "Einfuehrung halt", 1, 1, OfferedTime.YEARLY, 5, courses, neededCompetences, infl, true, "");
        Module eidg = new Module("Einfuehrung in die Gestaltung", "Einfuehrung halt", 1, 1, OfferedTime.YEARLY, 8, courses, neededCompetences, gestl, true, "");
        Module bwl = new Module("Grundlagen der BWL", "BWL halt", 1, 1, OfferedTime.YEARLY, 5, courses, neededCompetences, fql, true, "");
        Module analysis = new Module("Analysis", "Mathe 1 halt", 1, 1, OfferedTime.YEARLY, 5, courses, neededCompetences, mathl, true, "");
        modules.addAll(Arrays.asList(prog1, eidm, eidg, bwl, analysis));

        Module alge = new Module("Algorithmen und Datenstrukturen", "Schlaues Codingzeugs", 2, 2, OfferedTime.YEARLY, 5, courses, neededCompetences, infl, true, "");
        Module prog2 = new Module("Programmieren 2", "Advanced Programmieren undso", 2, 2, OfferedTime.YEARLY, 5, courses, neededCompetences, infl, true, "");
        Module linealge = new Module("Lineare Algebra", "Mathe 2 halt", 2, 2, OfferedTime.YEARLY, 5, courses, neededCompetences, mathl, true, "");
        Module gem = new Module("Gestaltung elektronischer Medien", "Websites undso", 2, 2, OfferedTime.YEARLY, 5, courses, neededCompetences, gestl, true, "");
        Module itrecht = new Module("IT-Recht und Datenschutz", "DSGVO undso", 2, 2, OfferedTime.YEARLY, 5, courses, neededCompetences, fql, true, "");
        modules.addAll(Arrays.asList(alge, prog2, linealge, gem, itrecht));

        Module prog3 = new Module("Programmieren 3", "Mega Advanced Programmieren undso", 3, 3, OfferedTime.YEARLY, 6, courses, neededCompetences, infl, true, "");
        Module eibo = new Module("Entwicklung interaktiver Benutzungsoberflaechen", "JavaFX undso", 3, 3, OfferedTime.YEARLY, 6, courses, neededCompetences, infgestl, true, "");
        Module angeMath = new Module("Angewandte Mathematik", "Basically Stochastik", 3, 3, OfferedTime.YEARLY, 6, courses, neededCompetences, mathl, true, "");
        modules.addAll(Arrays.asList(prog3, eibo, angeMath));

        Module swt = new Module("Softwaretechnik", "Mega Advanced Programmiertheorie", 4, 4, OfferedTime.YEARLY, 6, courses, neededCompetences, infl, true, "");
        Module cg = new Module("Softwaretechnik", "Krasse Grafikgeschichten mit Schwani", 4, 4, OfferedTime.YEARLY, 6, courses, neededCompetences, infl, true, "");
        Module animus = new Module("Animation", "Leblose Sachen beleben", 4, 4, OfferedTime.YEARLY, 6, courses, neededCompetences, gestl, true, "");
        modules.addAll(Arrays.asList(swt, cg, animus));

        Module swtp = new Module("Softwaretechnik-Projekt", "Großes Softwareprojekt", 5, 5, OfferedTime.YEARLY, 10, courses, neededCompetences, infl, true, "");
        Module mci = new Module("Mensch-Computer-Interaktion", "Großes Softwareprojekt", 5, 5, OfferedTime.YEARLY, 6, courses, neededCompetences, gestl, true, "");
        modules.addAll(Arrays.asList(swtp, mci));

        return modules;
    }
    
    
}
