package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Competence;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

/**
 * Validates each Module in relation to their needed Competences.
 */
public class CompetenceValidator implements Validator {

	private String className;

	private String name;
	private String message;
	private String description;

	public CompetenceValidator() {
		this.className = getClass().getName();
		this.name = "Kompetenzabhängigkeiten ";
		this.message = "Die benötigen Kompetenzen für das Modul wurden noch nicht erreicht.";
		this.description = "Es wird immer geprüft, ob du in deiner jetzigen Planung die inidivuellen Kompetenzen jedes Moduls in einer sinnvollen Reihenfolge erlangst.";

	}

	@Override
	public void validate(Plan plan) {

		List<Module> moduleList = plan.getModuleList();
		Map<Competence, Integer> competenceMap = new HashMap<>();
		boolean competencesObtained = true;

		// alle vermittelten Kompetenzen in Map packen
		for (Module module : moduleList) {
			
			if (module instanceof ExamModule) {
				
				ExamModule examModule = (ExamModule)module;
				Module actualModule = examModule.getAssociatedActualModule();
				
			
				if (examModule.getSemesterCurrent() > actualModule.getSemesterCurrent()){
					
					for (Competence competence : examModule.getTaughtCompetences()) {
						competenceMap.put(competence, examModule.getSemesterCurrent());
					}

				} else {
					
					for (Competence competence : actualModule.getTaughtCompetences()) {
						competenceMap.put(competence, actualModule.getSemesterCurrent());
					}
					
				}
				
			} else {
				
				if (!module.isHasExamModule()) {
					
					for (Competence competence : module.getTaughtCompetences()) {
						competenceMap.put(competence, module.getSemesterCurrent());
					}
					
				}
				
			}
			
		}

		// für alle Module checken, ob benötige Kompetenzen nicht in höherem Semester
		// liegen
		for (Module module : moduleList) {

			int currentSemester = module.getSemesterCurrent();

			for (Competence competence : module.getNeededCompetences()) { 

				if (competenceMap.get(competence) >= currentSemester) {
					competencesObtained = false;
					this.message = "Die benötigte Kompetenz " + competence.getName() + " wurde zum geplanten Zeitpunkt noch nicht erreicht. ";
				}

			}

			if (!competencesObtained) {
				module.setValid(false);
				module.setNote(this.message);
			} else{
				if (module.isValid()) {
					module.setValid(true);
					module.resetNote();
				} 
				
			}

			competencesObtained = true;

		}

	}

//	public void validate2(Plan plan) {
//
//		Map<Integer, List<Module>> moduleMap = plan.getModuleMap();
//		boolean competencesObtained = false;
//
//		for (int semester : moduleMap.keySet()) {
//
//			for (Module module : moduleMap.get(semester)) {
//
//				competencesObtained = false;
//
//				List<Competence> neededCompetences = module.getNeededCompetences();
//				List<Competence> taughtCompetences = new LinkedList<>();
//
//				if (neededCompetences.isEmpty()) {
//					continue;
//				}
//
//				for (int i = 1; i < semester; semester++) {
//
//					List<Module> tempList = moduleMap.get(i);
//
//					for (Module tempModule : tempList) {
//						taughtCompetences.addAll(tempModule.getTaughtCompetences());
//
//						if (taughtCompetences.containsAll(neededCompetences)) {
//							competencesObtained = true;
//							break;
//						}
//
//					}
//
//					if (competencesObtained) {
//						break;
//					}
//
//				}
//
//				if (!competencesObtained) {
//					module.setValid(false);
//					module.setNote(this.message);
//				}
//
//			}
//
//		}
//
//	}

	@Override
	public String getClassName() {
		return className;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getName() {
		return name;
	}

}
