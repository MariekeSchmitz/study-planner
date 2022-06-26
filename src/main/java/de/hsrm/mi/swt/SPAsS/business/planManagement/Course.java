package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
    private String name;
    private int cp;
    private Exam exam;

    public Course() {
    	
    }
    
    
    public Course(String name, int cp, Exam exam) {
        this.name = name;
        this.cp = cp;
        this.exam = exam;
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
}
