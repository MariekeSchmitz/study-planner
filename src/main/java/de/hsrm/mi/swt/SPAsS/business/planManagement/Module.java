package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import de.hsrm.mi.swt.SPAsS.business.commands.CommandManager;
import de.hsrm.mi.swt.SPAsS.business.commands.MoveSemesterCommand;

/** 
     * Class that represents a Module
     */
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
//	private boolean hasExtraExam;
	private Module associatedModule = null;
		
    private transient final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	
	public Module() {
		
	}
	
//	public Module(String name, String description, int semesterDefault, int semesterCurrent, OfferedTime offeredIn,
//			List<Course> courses, List<Competence> neededCompetences, List <Competence> taughtCompetences, CategoryEnum category, boolean valid, String note, boolean hasExtraExam)  {
//		this.name = name;
//		
//		this.description = description;
//		this.semesterDefault = semesterDefault;
//		this.offeredIn = offeredIn;
//		
//		this.courses = courses;
//		this.neededCompetences = neededCompetences;
//		this.taughtCompetences = taughtCompetences;
//		this.valid = valid;
//		this.note = note;
//		this.category = category;
////		this.hasExtraExam = hasExtraExam;
//		
//		this.semesterCurrent = semesterCurrent;
//		this.passed = false;
//		this.coursesPassed();
//		
//		for (Course course : this.courses) {
//			this.cp += course.getCp();
//		}
//		
//	}
	

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
//		this.hasExtraExam = false;
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
		this.associatedModule = associatedModule;
		this.coursesPassed();
		
		for (Course course : this.courses) {
			this.cp += course.getCp();
		}
		
	}

	
	/** 
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    
	/** 
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }
   

	
	/** 
	 * moves module from one semester to another
	 * @param newSemester
	 */
	public void move(int newSemester) {
		CommandManager.getInstance().execAndPush(new MoveSemesterCommand(this, newSemester));
	};
	
	/** 
	 * changes the semester back to its default state
	 */
	public void semesterReset() {
		CommandManager.getInstance().execAndPush(new MoveSemesterCommand(this, this.semesterDefault));
	}
	
	/** 
	 * flags the module as passed only if all its courses/exams are passed
	 */
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

	/** 
	 *calculates its grade by averaging the grades of its different courses
	 */
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
	
	/** 
	 * resets the Validation Note
	 */
	public void resetNote() {
		this.note = "";
	}
	
	

	
	/** 
	 * @return List<Course>
	 */
	public List<Course> getCourses() {
		return courses;
	}
	
	
	/** 
	 * @param c
	 * @return Course
	 */
	public Course getCourse(Course c) {
		
		for(Course ci : this.courses) {
			if(c.equals(ci)) {
				return ci;
			}
		}
		return null;
	}


	
	/** 
	 * @param courses
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	
	/** 
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/** 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	
	/** 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/** 
	 * @return int
	 */
	public int getSemesterDefault() {
		return semesterDefault;
	}
	
	/** 
	 * @param semesterDefault
	 */
	public void setSemesterDefault(int semesterDefault) {
		this.semesterDefault = semesterDefault;
	}
	
	/** 
	 * @return int
	 */
	public int getSemesterCurrent() {
		return semesterCurrent;
	}
	
	/** 
	 * @param semesterCurrent
	 */
	public void setSemesterCurrent(int semesterCurrent) {
		
		var pre = this.semesterCurrent;
		this.semesterCurrent = semesterCurrent;
		this.pcs.firePropertyChange("semesterCurrent", pre, this.semesterCurrent);
		System.out.println("semesterCurrent - set "+this.semesterCurrent);
		
	}
	
	
	/** 
	 * @return int
	 */
	public int getSemesterCurrentProperty () {
		return this.semesterCurrent;
	}
	
	
	/** 
	 * @return OfferedTime
	 */
	public OfferedTime getOfferedIn() {
		return offeredIn;
	}
	
	/** 
	 * @param offeredIn
	 */
	public void setOfferedIn(OfferedTime offeredIn) {
		this.offeredIn = offeredIn;
	}
	
	/** 
	 * @return int
	 */
	public int getCp() {
		return cp;
	}
	
	/** 
	 * @param cp
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}


	
	/** 
	 * @return float
	 */
	public float getGrade() {
		return grade;
	}


	
	/** 
	 * @param grade
	 */
	public void setGrade(float grade) {
		this.grade = grade;
	}


	
	


	
	/** 
	 * @return List<Competence>
	 */
	public List<Competence> getNeededCompetences() {
		return neededCompetences;
	}


	
	/** 
	 * @param neededCompetences
	 */
	public void setNeededCompetences(List<Competence> neededCompetences) {
		this.neededCompetences = neededCompetences;
	}


	
	/** 
	 * @return CategoryEnum
	 */
	public CategoryEnum getCategories() {
		return category;
	}


	
	/** 
	 * @param category
	 */
	public void setCategories(CategoryEnum category) {
		this.category = category;
	}


	
	/** 
	 * @return boolean
	 */
	public boolean isValid() {
		return valid;
	}


	
	/** 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		
		var pre = this.valid;
		this.valid = valid;		
		this.pcs.firePropertyChange("valid", pre, this.valid);
		System.out.println("semesterCurrent - set "+this.valid);
		
	}


	
	/** 
	 * @return String
	 */
	public String getNote() {
		return note;
	}


	
	/** 
	 * @param note 
	 */
	public void setNote(String note) {
		this.note += note;
	}

	
	/** 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Module [name=" + name + ", semesterCurrent=" + semesterCurrent + ", cp=" + cp + "]";
	}

	
	/** 
	 * @return CategoryEnum
	 */
	public CategoryEnum getCategory() {
		return category;
	}

	
	/** 
	 * @param category
	 */
	public void setCategory(CategoryEnum category) {
		this.category = category;
	}


	
	/** 
	 * @param passed
	 */
	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	
	/** 
	 * @return boolean 
	 */
	public boolean isPassed() {
		this.coursesPassed();
		return passed;
	}

	
	/** 
	 * @return List<Competence>
	 */
	public List<Competence> getTaughtCompetences() {
		return taughtCompetences;
	}

	
	/** 
	 * @param taughtCompetences all competences that this module teaches
	 */
	public void setTaughtCompetences(List<Competence> taughtCompetences) {
		this.taughtCompetences = taughtCompetences;
	}


/** 
 * @return Module
 */
//	public boolean isHasExtraExam() {
//		return hasExtraExam;
//	}
//
//	public void setHasExtraExam(boolean hasExtraExam) {
//		this.hasExtraExam = hasExtraExam;
//	}

	public Module getAssociatedModule() {
		return associatedModule;
	}

	
	/** 
	 * @param associatedModule
	 */
	public void setAssociatedModule(Module associatedModule) {
		this.associatedModule = associatedModule;
	}
	
	
	
	
	

	
	
	
	


	
	
	
	
	
	
	
	
}
