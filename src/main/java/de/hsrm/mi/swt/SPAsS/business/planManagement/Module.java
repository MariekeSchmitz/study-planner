package de.hsrm.mi.swt.SPAsS.business.planManagement;

public class Module {

	private String name; 
	private String description;
	private int semesterDefault;
	private int semesterCurrent; 
	private OfferedTime offeredIn;
	private int cp;
	
	
	public Module(String name, String description, int semesterDefault, int semesterCurrent, OfferedTime offeredIn,
			int cp) {
		this.name = name;
		this.description = description;
		this.semesterDefault = semesterDefault;
		this.semesterCurrent = semesterCurrent;
		this.offeredIn = offeredIn;
		this.cp = cp;
	}
	
	
	public void move() {
		
	};
	
	
	public void semesterReset() {
		
		this.semesterCurrent = this.semesterDefault;
		
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
	
	
	
	
	
}
