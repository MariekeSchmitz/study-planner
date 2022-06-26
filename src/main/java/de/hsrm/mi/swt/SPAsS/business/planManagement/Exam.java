package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.io.Serializable;

import de.hsrm.mi.swt.SPAsS.business.commands.AddSemesterCommand;
import de.hsrm.mi.swt.SPAsS.business.commands.CommandManager;
import de.hsrm.mi.swt.SPAsS.business.commands.PassExamCommand;
import de.hsrm.mi.swt.SPAsS.business.commands.SetGradeCommand;
import javafx.beans.property.SimpleBooleanProperty;

public class Exam implements Serializable {

    private float grade;
    private ExamType examType;
    private OfferedTime offeredIn;
    private int numberAttempt;
    private SimpleBooleanProperty passed;
    private boolean gradeAvailable;

    public Exam() {
    	
    }
    
    public Exam(float grade, ExamType examType, OfferedTime offeredIn, int numberAttempt, boolean gradeAvailable) {
        this.grade = grade;
        this.examType = examType;
        this.offeredIn = offeredIn;
        this.numberAttempt = numberAttempt;
        this.passed = new SimpleBooleanProperty(true);
        this.gradeAvailable = gradeAvailable;
    }
    
    public Exam(ExamType examType, OfferedTime offeredIn, int numberAttempt,boolean gradeAvailable) {
        this.examType = examType;
        this.offeredIn = offeredIn;
        this.numberAttempt = numberAttempt;
        this.passed = new SimpleBooleanProperty(false);
        this.gradeAvailable = gradeAvailable;
    }
    
    public void changeGradeCommand(float grade) {
		CommandManager.getInstance().execAndPush(new SetGradeCommand(this, grade));
    }
    
    public float getGrade() {
        return grade;
    }
    public void setGrade(float grade) {
        this.grade = grade;
    }
    public ExamType getExamType() {
        return examType;
    }
    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
    public OfferedTime getOfferedIn() {
        return offeredIn;
    }
    public void setOfferedIn(OfferedTime offeredIn) {
        this.offeredIn = offeredIn;
    }
    public int getNumberAttempt() {
        return numberAttempt;
    }
    public void setNumberAttempt(int numberAttempt) {
        this.numberAttempt = numberAttempt;
    }
   

	public SimpleBooleanProperty getPassed() {
		return passed;
	}

	public void setPassed(Boolean passed) {
		CommandManager.getInstance().execAndPush(new PassExamCommand(this, passed));
	}

	public boolean isGradeAvailable() {
		return gradeAvailable;
	}

	public void setGradeAvailable(boolean gradeAvailable) {
		this.gradeAvailable = gradeAvailable;
	}
    
    
    

    
}
