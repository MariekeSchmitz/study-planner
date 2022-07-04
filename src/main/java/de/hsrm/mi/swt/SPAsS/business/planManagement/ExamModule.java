package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.util.List;

public class ExamModule extends Module{

	private Module associatedActualModule = null;

	public ExamModule(String name, String description, int semesterDefault, int semesterCurrent, OfferedTime offeredIn,
			List<Course> courses, List<Competence> neededCompetences, List <Competence> taughtCompetences, CategoryEnum category, boolean valid, String note, Module associatedActualModule) {
		super(name,description, semesterDefault, semesterCurrent,offeredIn,courses,neededCompetences,taughtCompetences,category,valid,note);
		this.associatedActualModule = associatedActualModule;
	}
	
	public Module getAssociatedActualModule() {
		return associatedActualModule;
	}

	public void setAssociatedActualModule(Module associatedActualModule) {
		this.associatedActualModule = associatedActualModule;
	}
	
	
	
}
