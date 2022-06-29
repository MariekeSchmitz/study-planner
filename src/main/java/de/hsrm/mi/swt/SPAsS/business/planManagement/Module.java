package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import de.hsrm.mi.swt.SPAsS.business.commands.CommandManager;
import de.hsrm.mi.swt.SPAsS.business.commands.MoveSemesterCommand;

public class Module {

	private String name; 
	private String description;
	private int semesterCurrent;
	private int semesterDefault;
	private OfferedTime offeredIn;
	private int cp = 0;
	private List <Course> courses;
	private float grade;
	private boolean passed;
	private List<Competence> neededCompetences;
	private List <Competence> taughtCompetences;
	private CategoryEnum category;
	private boolean valid = true;
	private String note = "";
	private boolean hasExtraExam;
	private Module associatedModule = null;
		
    private transient final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	
	public Module() {
		
	}
	
	public Module(String name, String description, int semesterDefault, int semesterCurrent, OfferedTime offeredIn,
			List<Course> courses, List<Competence> neededCompetences, List <Competence> taughtCompetences, CategoryEnum category, boolean valid, String note, boolean hasExtraExam)  {
		this.name = name;
		
		this.description = description;
		this.semesterDefault = semesterDefault;
		this.offeredIn = offeredIn;
		
		this.courses = courses;
		this.neededCompetences = neededCompetences;
		this.taughtCompetences = taughtCompetences;
		this.valid = valid;
		this.note = note;
		this.category = category;
		this.hasExtraExam = hasExtraExam;
		
		this.semesterCurrent = semesterCurrent;
		this.passed = false;
		this.coursesPassed();
		
		for (Course course : this.courses) {
			this.cp += course.getCp();
		}
		
	}
	
	public Module(String name, String description, int semesterDefault, int semesterCurrent, OfferedTime offeredIn,
			List<Course> courses, List<Competence> neededCompetences, List <Competence> taughtCompetences, CategoryEnum category, boolean valid, String note)  {
		this.name = name;
		
		this.description = description;
		this.semesterDefault = semesterDefault;
		this.offeredIn = offeredIn;
		
		this.courses = courses;
		this.neededCompetences = neededCompetences;
		this.taughtCompetences = taughtCompetences;
		this.valid = valid;
		this.note = note;
		this.category = category;
		
		this.semesterCurrent = semesterCurrent;
		this.passed = false;
		this.hasExtraExam = false;
		this.coursesPassed();
		
		for (Course course : this.courses) {
			this.cp += course.getCp();
		}
		
	}
	
	public Module(String name, String description, int semesterDefault, int semesterCurrent, OfferedTime offeredIn,
			List<Course> courses, List<Competence> neededCompetences, List <Competence> taughtCompetences, CategoryEnum category, boolean valid, String note, Module associatedModule)  {
		this.name = name;
		
		this.description = description;
		this.semesterDefault = semesterDefault;
		this.offeredIn = offeredIn;
		
		this.courses = courses;
		this.neededCompetences = neededCompetences;
		this.taughtCompetences = taughtCompetences;
		this.valid = valid;
		this.note = note;
		this.category = category;
		
		this.semesterCurrent = semesterCurrent;
		this.passed = false;
		this.hasExtraExam = false;
		this.associatedModule = associatedModule;
		this.coursesPassed();
		
		for (Course course : this.courses) {
			this.cp += course.getCp();
		}
		
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
   

	public void move(int newSemester) {
		CommandManager.getInstance().execAndPush(new MoveSemesterCommand(this, newSemester));
	};
	
	
	public void semesterReset() {
		CommandManager.getInstance().execAndPush(new MoveSemesterCommand(this, this.semesterDefault));
	}
	
	public void coursesPassed(){
		boolean tempPassed = true;
		for (Course course:courses){
			if (!course.getExam().getPassed()){
				tempPassed = false;
				break;
			}
		}
		this.passed = tempPassed;
	}

	public void calcGrade(){
		float grade = 0;
		int cp = 0;
		if (passed){
			for (Course course:courses){
				if (course.getExam().isGradeAvailable()) {
					grade += course.getCp() * course.getExam().getGrade();
					cp += course.getCp();
				}
			}
			if (cp != 0) {
				this.grade = grade/cp;
			} else {
				this.grade = 0;
			}
			
		}

	}
	
	public void resetNote() {
		this.note = "";
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
		
		var pre = this.semesterCurrent;
		this.semesterCurrent = semesterCurrent;
		this.pcs.firePropertyChange("semesterCurrent", pre, this.semesterCurrent);
		System.out.println("semesterCurrent - set "+this.semesterCurrent);
		
	}
	
	public int getSemesterCurrentProperty () {
		return this.semesterCurrent;
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


	
	


	public List<Competence> getNeededCompetences() {
		return neededCompetences;
	}


	public void setNeededCompetences(List<Competence> neededCompetences) {
		this.neededCompetences = neededCompetences;
	}


	public CategoryEnum getCategories() {
		return category;
	}


	public void setCategories(CategoryEnum category) {
		this.category = category;
	}


	public boolean isValid() {
		return valid;
	}


	public void setValid(boolean valid) {
		
		var pre = this.valid;
		this.valid = valid;		
		this.pcs.firePropertyChange("valid", pre, this.valid);
		System.out.println("semesterCurrent - set "+this.valid);
		
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note += note;
	}

	@Override
	public String toString() {
		return "Module [name=" + name + ", semesterCurrent=" + semesterCurrent + ", cp=" + cp + "]";
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}


	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public boolean isPassed() {
		this.coursesPassed();
		return passed;
	}

	public List<Competence> getTaughtCompetences() {
		return taughtCompetences;
	}

	public void setTaughtCompetences(List<Competence> taughtCompetences) {
		this.taughtCompetences = taughtCompetences;
	}

	public boolean isHasExtraExam() {
		return hasExtraExam;
	}

	public void setHasExtraExam(boolean hasExtraExam) {
		this.hasExtraExam = hasExtraExam;
	}

	public Module getAssociatedModule() {
		return associatedModule;
	}

	public void setAssociatedModule(Module associatedModule) {
		this.associatedModule = associatedModule;
	}
	
	
	
	
	

	
	
	
	


	
	
	
	
	
	
	
	
}
