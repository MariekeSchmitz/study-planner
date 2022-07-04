package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.io.Serializable;


/**
 * A Course represents one part of a Module. An example course would be a lecture.
 * Each Course has an exam.
 */
public class Course implements Serializable{
    private String name;
    private int cp;
    private Exam exam;
    private boolean hasExtraExam;

    public Course() {
    	
    }
    
    
    public Course(String name, int cp, Exam exam) {
        this.name = name;
        this.cp = cp;
        this.exam = exam;
    }
    
    public Course(String name, int cp, Exam exam, boolean hasExtraExam) {
        this(name,cp,exam);
        this.hasExtraExam = hasExtraExam;
    }
    
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }


	public boolean isHasExtraExam() {
		return hasExtraExam;
	}


	public void setHasExtraExam(boolean hasExtraExam) {
		this.hasExtraExam = hasExtraExam;
	}    
    
    
}
