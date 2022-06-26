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
                CpLimitValidator v2 = new CpLimitValidator(30);
                ProgressValidator v3 = new ProgressValidator(3);
                valids.add(v1);
                valids.add(v2);
                valids.add(v3);

                Plan p = new Plan("Medieninformatik", "RandomCurriculumName", this.getModules(), valids, 7);
                this.plan = p;

        }

        private List<Module> getModules() {
                List<Competence> neededCompetences = new ArrayList<>();
                Competence c = new Competence("KernKompetenz1");
                neededCompetences.add(c);

                List<Course> courses1 = new ArrayList<>();
                // Exam e = new Exam(1.3f, ExamType.EXAM, OfferedTime.BI_YEARLY, 2, true);
                Course course1 = new Course("Vorlesung", 3, new Exam(ExamType.EXAM, OfferedTime.BI_YEARLY, 2, true),
                                neededCompetences);
                courses1.add(course1);

                List<Course> courses2 = new ArrayList<>();
                Course course2 = new Course("Praktikum", 3, new Exam(ExamType.EXAM, OfferedTime.BI_YEARLY, 2, false),
                                neededCompetences);

                courses2.add(course2);

                CategoryEnum infl = CategoryEnum.GESTALTUNG;
                CategoryEnum gestl = CategoryEnum.INFORMATIK;
                CategoryEnum infgestl = CategoryEnum.SONSTIGES;
                CategoryEnum fql = CategoryEnum.INFORMATIK;
                CategoryEnum mathl = CategoryEnum.MATHE;

                List<Module> modules = new ArrayList<>();
                Module prog1 = new Module("Programmieren 1", "Programmieren undso", 1, 1, OfferedTime.YEARLY,
                                courses1,
                                neededCompetences, infl, true, "");
                Module eidm = new Module("Einfuehrung in die Medieninformatik", "Einfuehrung halt", 1, 1,
                                OfferedTime.YEARLY,
                                courses2, neededCompetences, infl, true, "");
                Module eidg = new Module("Einfuehrung in die Gestaltung", "Einfuehrung halt", 1, 1, OfferedTime.YEARLY,
                                courses1, neededCompetences, gestl, true, "");
                Module bwl = new Module("Grundlagen der BWL", "BWL halt", 1, 1, OfferedTime.YEARLY, courses1,
                                neededCompetences, fql, true, "");
                Module analysis = new Module("Analysis", "Mathe 1 halt", 1, 1, OfferedTime.YEARLY, courses1,
                                neededCompetences, mathl, true, "");
                modules.addAll(Arrays.asList(prog1, eidm, eidg, bwl, analysis));

                Module alge = new Module("Algorithmen und Datenstrukturen", "Schlaues Codingzeugs", 2, 2,
                                OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Analysis"), new Competence("Programmieren 1"),
                                                new Competence("Einfuehrung in die Medieninformatik")),
                                infl, true, "");
                Module prog2 = new Module("Programmieren 2", "Advanced Programmieren undso", 2, 2, OfferedTime.YEARLY,
                                courses1, Arrays.asList(new Competence("Programmieren 1"),
                                                new Competence("Einfuehrung in die Medieninformatik")),
                                infl, true, "");
                Module linealge = new Module("Lineare Algebra", "Mathe 2 halt", 2, 2, OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Analysis")), mathl, true, "");
                Module gem = new Module("Gestaltung elektronischer Medien", "Websites undso", 2, 2, OfferedTime.YEARLY,
                                courses1, Arrays.asList(new Competence("Einfuehrung in die Gestaltung")), gestl, true,
                                "");
                Module itrecht = new Module("IT-Recht und Datenschutz", "DSGVO undso", 2, 2, OfferedTime.YEARLY,
                                courses1,
                                neededCompetences, fql, true, "");
                Module asz = new Module("Auszeichnungssprachen", "Html undso", 2, 2, OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Programmieren 1"),
                                                new Competence("Einfuehrung in die Medieninformatik")),
                                infl, true, "");
                modules.addAll(Arrays.asList(alge, prog2, linealge, gem, itrecht, asz));

                Module prog3 = new Module("Programmieren 3", "Mega Advanced Programmieren undso", 3, 3,
                                OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Auszeichnungssprachen"),
                                                new Competence("Programmieren 2"),
                                                new Competence("Algorithmen und Datenstrukturen")),
                                infl, true, "");
                Module eibo = new Module("Entwicklung interaktiver Benutzungsoberflaechen", "JavaFX undso", 3, 3,
                                OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Programmieren 2"),
                                                new Competence("Einfuehrung in die Gestaltung")),
                                infgestl, true, "");
                Module angeMath = new Module("Angewandte Mathematik", "Basically Stochastik", 3, 3, OfferedTime.YEARLY,
                                courses1, Arrays.asList(new Competence("Analysis"), new Competence("Lineare Algebra")),
                                mathl, true, "");
                Module data = new Module("Datenbanken", "Umgang mit DBs", 3, 3, OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Lineare Algebra"), new Competence("Programmieren 2"),
                                                new Competence("Algorithmen und Datenstrukturen")),
                                infl, true, "");
                Module auto = new Module("Automatentheorie und formale Sprachen", "Umgang mit DBs", 3, 3,
                                OfferedTime.YEARLY,
                                courses1, Arrays.asList(new Competence("Analysis"),
                                                new Competence("Algorithmen und Datenstrukturen")),
                                infl, true, "");
                modules.addAll(Arrays.asList(prog3, eibo, angeMath, data, auto));

                Module swt = new Module("Softwaretechnik", "Mega Advanced Programmiertheorie", 4, 4, OfferedTime.YEARLY,
                                courses1,
                                Arrays.asList(new Competence("Programmieren 2"), new Competence("Programmieren 3"),
                                                new Competence("Entwicklung interaktiver Benutzeroberflaechen"),
                                                new Competence("Datenbanksysteme")),
                                infl, true, "");
                Module cg = new Module("Computergrafik", "Krasse Grafikgeschichten mit Schwani", 4, 4,
                                OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Lineare Algebra"), new Competence("Programmieren 3"),
                                                new Competence("Entwicklung interaktiver Benutzeroberflaechen")),
                                infl, true, "");
                Module animus = new Module("Animation", "Leblose Sachen beleben", 4, 4, OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Gestaltung elektronischer Medien"),
                                                new Competence("Entwicklung interaktiver Benutzeroberflaechen")),
                                gestl, true, "");
                Module web = new Module("Webbasierte Anwendungen", "Webseiten bauen mit Backendanbindung", 4, 4,
                                OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Programmieren 3"), new Competence("Datenbanksysteme"),
                                                new Competence("Entwicklung interaktiver Benutzeroberflaechen")),
                                infl, true, "");
                Module netz = new Module("Rechnernetze und Betriebssysteme", "Eigentlich nur Protokolle", 4, 4,
                                OfferedTime.YEARLY, courses1, Arrays.asList(new Competence("Programmieren 3")), infl,
                                true, "");
                modules.addAll(Arrays.asList(swt, cg, animus, web, netz));

                Module swtp = new Module("Softwaretechnik-Projekt", "Großes Softwareprojekt", 5, 5, OfferedTime.YEARLY,
                                courses1,
                                Arrays.asList(new Competence("Programmieren 3"), new Competence("Datenbanksysteme"),
                                                new Competence("Softwaretechnik"),
                                                new Competence("Webbasierte Anwendungen")),
                                infl, true, "");
                Module mci = new Module("Mensch-Computer-Interaktion", "Menschen mache Sachen mit Computern", 5, 5,
                                OfferedTime.YEARLY, courses1,
                                Arrays.asList(new Competence("Softwaretechnik"),
                                                new Competence("Gestaltung elektronischer Medien"),
                                                new Competence("Entwicklung interaktiver Benutzeroberflaechen")),
                                gestl, true, "");
                Module wp1 = new Module("Wahlpflichtliste Gestaltung und Informatik", "Wahlpflicht", 5, 5,
                                OfferedTime.YEARLY, courses1, neededCompetences, infgestl, true, "");
                Module wp2 = new Module("Wahlpflichtliste Medien und Informatik", "Wahlpflicht", 5, 5,
                                OfferedTime.YEARLY, courses1, neededCompetences, infl, true, "");
                modules.addAll(Arrays.asList(swtp, mci, wp1, wp2));

                Module prak = new Module("Berufspraktische Taetigkeit", "Praktikum", 6, 6, OfferedTime.YEARLY, courses1,
                                neededCompetences, fql, true, "");
                modules.add(prak);

                Module wp3 = new Module("Wahlpflichtliste Internationalisierung", "Wahlpflicht", 7, 7,
                                OfferedTime.YEARLY,
                                courses1, neededCompetences, fql, true, "");
                Module port = new Module("Portfolio Medieninformatik", "Portfolio", 7, 7, OfferedTime.YEARLY,
                                courses1,
                                neededCompetences, infgestl, true, "");
                Module bach = new Module("Bachelor Thesis", "Bachelor Thesis", 7, 7, OfferedTime.YEARLY, courses1,
                                neededCompetences, fql, true, "");
                modules.addAll(Arrays.asList(wp3, port, bach));

                return modules;
        }
}
