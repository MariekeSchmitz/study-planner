package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import de.hsrm.mi.swt.SPAsS.business.commands.CommandManager;
import de.hsrm.mi.swt.SPAsS.business.commands.PassExamCommand;
import de.hsrm.mi.swt.SPAsS.business.commands.SetGradeCommand;


/**
 * Represents an Exam. 
 * 
 */
public class Exam implements Serializable {

    private float grade;
    private ExamType examType;
    private OfferedTime offeredIn;
    private int numberAttempt;
    private boolean passed;
    private boolean gradeAvailable;
    private transient final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    
    public Exam() {
    	
    }
    
    /** 
     * @param grade grade with which the exam has been evaluated
     * @param examType 
     * @param offeredIn
     * @param numberAttempt 
     * @param gradeAvailable
     */
    public Exam(float grade, ExamType examType, OfferedTime offeredIn, int numberAttempt, boolean gradeAvailable) {
        this.grade = grade;
        this.examType = examType;
        this.offeredIn = offeredIn;
        this.numberAttempt = numberAttempt;
        this.passed = true;
        this.gradeAvailable = gradeAvailable;
    }
    
    public Exam(ExamType examType, OfferedTime offeredIn, int numberAttempt,boolean gradeAvailable) {
        this.examType = examType;
        this.offeredIn = offeredIn;
        this.numberAttempt = numberAttempt;
        this.passed = false;
        this.gradeAvailable = gradeAvailable;
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
     * @param grade
     */
    public void changeGradeCommand(float grade) {
		CommandManager.getInstance().execAndPush(new SetGradeCommand(this, grade));
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
     * @return ExamType
     */
    public ExamType getExamType() {
        return examType;
    }
    
    /** 
     * @param examType
     */
    public void setExamType(ExamType examType) {
        this.examType = examType;
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
    public int getNumberAttempt() {
        return numberAttempt;
    }
    
    /** 
     * @param numberAttempt
     */
    public void setNumberAttempt(int numberAttempt) {
        this.numberAttempt = numberAttempt;
    }

	
    /** 
     * @return boolean
     */
    public boolean getPassed() {
		return passed;
	}

	
    /** 
     * @param passed
     */
    public void setPassed(Boolean passed) {
		
		CommandManager.getInstance().execAndPush(new PassExamCommand(this, passed));

	}
	
	
    /** 
     * @param passed
     */
    public void firePassedEvent (Boolean passed) {
		var pre = this.passed;
		this.passed = passed;
		this.pcs.firePropertyChange("bestanden", pre, this.passed);
	  	System.out.println("bestanden - set "+this.passed);	}

	
    /** 
     * @return boolean
     */
    public boolean isGradeAvailable() {
		return gradeAvailable;
	}

	
    /** 
     * @param gradeAvailable
     */
    public void setGradeAvailable(boolean gradeAvailable) {
		this.gradeAvailable = gradeAvailable;
	}
    
    
    

    
}
