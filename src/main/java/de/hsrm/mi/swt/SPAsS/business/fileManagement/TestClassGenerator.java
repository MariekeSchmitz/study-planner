package de.hsrm.mi.swt.SPAsS.business.fileManagement;

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

public class TestClassGenerator {

        public Plan plan;

        public TestClassGenerator() {
                List<Validator> valids = new ArrayList<>();
                CompetenceValidator v1 = new CompetenceValidator();
                CpLimitValidator v2 = new CpLimitValidator(100);
                ProgressValidator v3 = new ProgressValidator(3);
                valids.add(v1);
                valids.add(v2);
                valids.add(v3);

                Plan p = new Plan("Medieninformatik", "RandomCurriculumName", this.getModules(), valids, 7);
                this.plan = p;

        }

        private List<Module> getModules() {
                List<Competence> neededCompetences = new ArrayList<>();

                CategoryEnum infl = CategoryEnum.INFORMATIK;
                CategoryEnum gestl = CategoryEnum.GESTALTUNG;
                CategoryEnum infgestl = CategoryEnum.INFORMATIK_UND_GESTALTUNG;
                CategoryEnum fql = CategoryEnum.SONSTIGES;
                CategoryEnum mathl = CategoryEnum.MATHE;
                
                

                List<Module> modules = new ArrayList<>();
                Module prog1 = new Module("Programmieren 1", getLorem(), 1, 1, OfferedTime.YEARLY,
                                getCourses(4,3),
                                neededCompetences, Arrays.asList(new Competence("Programmieren 1")), infl, true, "");
                Module eidm = new Module("Einfuehrung in die Medieninformatik", getLorem(), 1, 1,
                                OfferedTime.YEARLY,
                                getCourses(4,4), neededCompetences, Arrays.asList(new Competence("Einfuehrung in die Medieninformatik")), infl, true, "");
                Module eidg = new Module("Einfuehrung in die Gestaltung", getLorem(), 1, 1, OfferedTime.YEARLY,
                                getCourses(3,2), neededCompetences, Arrays.asList(new Competence("Einfuehrung in die Gestaltung")), gestl, true, "");
                Module bwl = new Module("Grundlagen der BWL", getLorem(), 1, 1, OfferedTime.YEARLY, getCourses(3,2),
                                neededCompetences,Arrays.asList(new Competence("Grundlagen der BWL")), fql, true, "");
                Module analysis = new Module("Analysis", getLorem(), 1, 1, OfferedTime.YEARLY, getCourses(3,2),
                                neededCompetences,Arrays.asList(new Competence("Analysis")), mathl, true, "");
                modules.addAll(Arrays.asList(prog1, eidm, eidg, bwl, analysis));

                Module alge = new Module("Algorithmen und Datenstrukturen", getLorem(), 2, 2,
                                OfferedTime.YEARLY, getCourses(3,2),
                                Arrays.asList(new Competence("Analysis"), new Competence("Programmieren 1"),
                                                new Competence("Einfuehrung in die Medieninformatik")),
                                Arrays.asList(new Competence("Algorithmen und Datenstrukturen")),infl, true, "");
                Module prog2 = new Module("Programmieren 2", getLorem(), 2, 2, OfferedTime.YEARLY,
                                getCourses(3,2), Arrays.asList(new Competence("Programmieren 1"),
                                                new Competence("Einfuehrung in die Medieninformatik")),
                                Arrays.asList(new Competence("Programmieren 2")),infl, true, "");
                Module linealge = new Module("Lineare Algebra", getLorem(), 2, 2, OfferedTime.YEARLY, getCourses(3,2),
                                Arrays.asList(new Competence("Analysis")),Arrays.asList(new Competence("Lineare Algebra")), mathl, true, "");
                Module gem = new Module("Gestaltung elektronischer Medien", getLorem(), 2, 2, OfferedTime.YEARLY,
                                getCourses(3,2), Arrays.asList(new Competence("Einfuehrung in die Gestaltung")),Arrays.asList(new Competence("Gestaltung elektronischer Medien")), gestl, true,
                                "");
                Module itrecht = new Module("IT-Recht und Datenschutz", getLorem(), 2, 2, OfferedTime.YEARLY,
                                getCourses(3,2),
                                neededCompetences,Arrays.asList(new Competence("IT-Recht und Datenschutz")), fql, true, "");
                Module asz = new Module("Auszeichnungssprachen", getLorem(), 2, 2, OfferedTime.YEARLY, getCourses(3,2),
                                Arrays.asList(new Competence("Programmieren 1"),
                                                new Competence("Einfuehrung in die Medieninformatik")),
                                Arrays.asList(new Competence("Auszeichnungssprachen")),infl, true, "");
                modules.addAll(Arrays.asList(alge, prog2, linealge, gem, itrecht, asz));

                Module prog3 = new Module("Programmieren 3", getLorem(), 3, 3,
                                OfferedTime.YEARLY, getCourses(3,3),
                                Arrays.asList(new Competence("Auszeichnungssprachen"),
                                                new Competence("Programmieren 2"),
                                                new Competence("Algorithmen und Datenstrukturen")),
                                                Arrays.asList(new Competence("Programmieren 3")),infl, true, "");
                Module eibo = new Module("Entwicklung interaktiver Benutzungsoberflaechen", getLorem(), 3, 3,
                                OfferedTime.YEARLY, getCourses(3,3),
                                Arrays.asList(new Competence("Programmieren 2"),
                                                new Competence("Einfuehrung in die Gestaltung")),
                                                Arrays.asList(new Competence("Entwicklung interaktiver Benutzungsoberflaechen")),infgestl, true, "");
                Module angeMath = new Module("Angewandte Mathematik", getLorem(), 3, 3, OfferedTime.YEARLY,
                                getCourses(3,3), Arrays.asList(new Competence("Analysis"), new Competence("Lineare Algebra")),
                                Arrays.asList(new Competence("Angewandte Mathematik")),mathl, true, "");
                Module data = new Module("Datenbanksysteme", getLorem(), 3, 3, OfferedTime.YEARLY, getCourses(3,3),
                                Arrays.asList(new Competence("Lineare Algebra"), new Competence("Programmieren 2"),
                                                new Competence("Algorithmen und Datenstrukturen")),
                                                Arrays.asList(new Competence("Datenbanksysteme")),infl, true, "");
                Module auto = new Module("Automatentheorie und formale Sprachen", getLorem(), 3, 3,
                                OfferedTime.YEARLY,
                                getCourses(3,3), Arrays.asList(new Competence("Analysis"),
                                                new Competence("Algorithmen und Datenstrukturen")),
                                                Arrays.asList(new Competence("Automatentheorie und formale Sprachen")),infl, true, "");
                modules.addAll(Arrays.asList(prog3, eibo, angeMath, data, auto));

                Module swt = new Module("Softwaretechnik", getLorem(), 4, 4, OfferedTime.YEARLY,
                                getCourses(3,3),
                                Arrays.asList(new Competence("Programmieren 2"), new Competence("Programmieren 3"),
                                                new Competence("Entwicklung interaktiver Benutzungsoberflaechen"),
                                                new Competence("Datenbanksysteme")),
                                                Arrays.asList(new Competence("Softwaretechnik")),infl, true, "");
                Module cg = new Module("Computergrafik", getLorem(), 4, 4,
                                OfferedTime.YEARLY, getCourses(3,3),
                                Arrays.asList(new Competence("Lineare Algebra"), new Competence("Programmieren 3"),
                                                new Competence("Entwicklung interaktiver Benutzungsoberflaechen")),
                                                Arrays.asList(new Competence("Computergrafik")),infl, true, "");
                Module animus = new Module("Animation", getLorem(), 4, 4, OfferedTime.YEARLY, getCourses(3,3),
                                Arrays.asList(new Competence("Gestaltung elektronischer Medien"),
                                                new Competence("Entwicklung interaktiver Benutzungsoberflaechen")),
                                                Arrays.asList(new Competence("Animation")),gestl, true, "");
                Module web = new Module("Webbasierte Anwendungen", getLorem(), 4, 4,
                                OfferedTime.YEARLY, getCourses(3,3),
                                Arrays.asList(new Competence("Programmieren 3"), new Competence("Datenbanksysteme"),
                                                new Competence("Entwicklung interaktiver Benutzungsoberflaechen")),
                                                Arrays.asList(new Competence("Webbasierte Anwendungen")),infl, true, "");
                Module netz = new Module("Rechnernetze und Betriebssysteme", getLorem(), 4, 4,
                                OfferedTime.YEARLY, getCourses(3,3), Arrays.asList(new Competence("Programmieren 3")),
                                Arrays.asList(new Competence("Rechnernetze und Betriebssysteme")), infl,true, "");
                modules.addAll(Arrays.asList(swt, cg, animus, web, netz));
                
                Module swtp = new Module("Softwaretechnik-Projekt", getLorem(), 5, 5, OfferedTime.YEARLY,
                Arrays.asList(new Course("Softwaretechnik-Projekt", 10, new Exam(ExamType.SEMESTER_PROJECT, OfferedTime.YEARLY, 0, false))),
                                Arrays.asList(new Competence("Programmieren 3"), new Competence("Datenbanksysteme"),
                                                new Competence("Softwaretechnik"),
                                                new Competence("Webbasierte Anwendungen")),
                                                Arrays.asList(new Competence("Softwaretechnik-Projekt")),infl, true, "");
                Module mci = new Module("Mensch-Computer-Interaktion", getLorem(), 5, 5,
                                OfferedTime.YEARLY, getCourses(3,3),
                                Arrays.asList(new Competence("Softwaretechnik"),
                                                new Competence("Gestaltung elektronischer Medien"),
                                                new Competence("Entwicklung interaktiver Benutzungsoberflaechen")),
                                                Arrays.asList(new Competence("Mensch-Computer-Interaktion")),gestl, true, "");
                Module wp1 = new Module("Wahlpflichtliste Gestaltung und Informatik", getLorem(), 5, 5,
                                OfferedTime.YEARLY, getCourses(5,5), neededCompetences, 
                                Arrays.asList(new Competence("Wahlpflichtliste Gestaltung und Informatik")),infgestl, true, "");
                Module wp2 = new Module("Wahlpflichtliste Medien und Informatik", getLorem(), 5, 5,
                                OfferedTime.YEARLY, getCourses(3,2), neededCompetences, 
                                Arrays.asList(new Competence("Wahlpflichtliste Medien und Informatik")),infl, true, "");
                modules.addAll(Arrays.asList(swtp, mci, wp1, wp2));

                Module prak = new Module("Berufspraktische Taetigkeit", getLorem(), 6, 6, OfferedTime.YEARLY, 
                Arrays.asList(new Course("Berufspraktikum", 30, new Exam(ExamType.SEMESTER_PROJECT, OfferedTime.YEARLY, 0, false))),
                                neededCompetences, 
                                Arrays.asList(new Competence("Berufspraktische Taetigkeit")),fql, true, "");
                modules.add(prak);
                
                Module wp3 = new Module("Wahlpflichtliste Internationalisierung", getLorem(), 7, 7,
                                OfferedTime.YEARLY,
                                Arrays.asList(new Course("Sprachkurs", 4, new Exam(ExamType.SEMESTER_PROJECT, OfferedTime.YEARLY, 0, false))),
                                neededCompetences,
                                Arrays.asList(new Competence("Wahlpflichtliste Internationalisierung")), fql, true, "");
                Module port = new Module("Portfolio Medieninformatik", getLorem(), 7, 7, OfferedTime.YEARLY,
                Arrays.asList(new Course("Portfolio-Projekt", 10, new Exam(ExamType.SEMESTER_PROJECT, OfferedTime.YEARLY, 0, false))),
                                neededCompetences, 
                                Arrays.asList(new Competence("Portfolio Medieninformatik")), infgestl, true, "");
                Module bach = new Module("Bachelor Thesis", getLorem(), 7, 7, OfferedTime.YEARLY, 
                                Arrays.asList(new Course("Bachelor-Arbeit", 15, new Exam(ExamType.SEMESTER_PROJECT, OfferedTime.YEARLY, 0, false))),
                                neededCompetences, 
                                Arrays.asList(new Competence("Bachelor Thesis")),fql, true, "Hier steht eine Warnung");
                modules.addAll(Arrays.asList(wp3, port, bach));

                return modules;
        }

        private List<Course> getCourses(int cpvl, int cpp){
                List<Course> courses = new ArrayList<>();
                Course course1 = new Course("Vorlesung", cpvl, new Exam(ExamType.EXAM, OfferedTime.BI_YEARLY, 0, true));
                Course course2 = new Course("Praktikum", cpp, new Exam(ExamType.SEMESTER_PROJECT, OfferedTime.YEARLY, 0, false));
                courses.add(course1);
                courses.add(course2);
                return courses;
        }

        private String getLorem(){
                return "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, \n sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,\n sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.\n Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. \nLorem ipsum dolor sit amet, consetetur sadipscing elitr, \nsed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat,\n sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.\n Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
        }
}
