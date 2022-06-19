package de.hsrm.mi.swt.SPAsS.business.planManagement;

public class Exam {

    private float grade;
    private ExamType examType;
    private OfferedTime offeredIn;
    private int numberAttempt;
    private boolean passed;


    public Exam(float grade, ExamType examType, OfferedTime offeredIn, int numberAttempt, boolean passed) {
        this.grade = grade;
        this.examType = examType;
        this.offeredIn = offeredIn;
        this.numberAttempt = numberAttempt;
        this.passed = passed;
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
    public boolean isPassed() {
        return passed;
    }
    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    
}
