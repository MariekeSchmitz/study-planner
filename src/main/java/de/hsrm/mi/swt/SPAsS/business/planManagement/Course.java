package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable{
    private String name;
    private int cp;
    private Exam exam;
    private List <Competence> taughtCompetences;

    
    public Course() {
    	
    }
    
    
    public Course(String name, int cp, Exam exam, List <Competence> taughtCompetences) {
        this.name = name;
        this.cp = cp;
        this.exam = exam;
        this.taughtCompetences = taughtCompetences;
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

	public List<Competence> getTaughtCompetences() {
		return taughtCompetences;
	}

	public void setTaughtCompetences(List<Competence> taughtCompetences) {
		this.taughtCompetences = taughtCompetences;
	}
    
	
    

    
}
