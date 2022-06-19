package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.util.List;

public class Module {

	private String name; 
	private String description;
	private int semesterDefault;
	private int semesterCurrent; 
	private OfferedTime offeredIn;
	private int cp;
	private List <Course> courses;
	private float grade;
	private boolean passed = false;
	private List<Competence> neededCompetences;
	private List <Category> categories;
		
	
	public Module(String name, String description, int semesterDefault, int semesterCurrent, OfferedTime offeredIn,
			int cp, List<Course> courses, List<Competence> neededCompetences,List <Category> categories) {
		this.name = name;
		this.description = description;
		this.semesterDefault = semesterDefault;
		this.semesterCurrent = semesterCurrent;
		this.offeredIn = offeredIn;
		this.cp = cp;
		this.courses = courses;
		this.neededCompetences = neededCompetences;
	}


	public void move() {
		
	};
	
	
	public void semesterReset() {
		
		this.semesterCurrent = this.semesterDefault;
		
	}
	
	public void coursesPassed(){
		boolean tempPassed = true;
		for (Course course:courses){
			if (!course.getExam().isPassed()){
				tempPassed = false;
				break;
			}
		}
		this.passed = tempPassed;
	}

	public void calcGrade(){
		float grade = 0;
		if (passed){
			for (Course course:courses){
				grade += course.getCp() * course.getExam().getGrade();
			}
			this.grade = grade/this.cp;
		}

	}

	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSemesterDefault() {
		return semesterDefault;
	}
	public void setSemesterDefault(int semesterDefault) {
		this.semesterDefault = semesterDefault;
	}
	public int getSemesterCurrent() {
		return semesterCurrent;
	}
	public void setSemesterCurrent(int semesterCurrent) {
		this.semesterCurrent = semesterCurrent;
	}
	public OfferedTime getOfferedIn() {
		return offeredIn;
	}
	public void setOfferedIn(OfferedTime offeredIn) {
		this.offeredIn = offeredIn;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}


	public float getGrade() {
		return grade;
	}


	public void setGrade(float grade) {
		this.grade = grade;
	}


	public boolean isPassed() {
		return passed;
	}


	public List<Competence> getNeededCompetences() {
		return neededCompetences;
	}


	public void setNeededCompetences(List<Competence> neededCompetences) {
		this.neededCompetences = neededCompetences;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	
	
}
