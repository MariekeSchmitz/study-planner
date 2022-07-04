package de.hsrm.mi.swt.SPAsS.business.planManagement;

import java.io.Serializable;
import java.util.Objects;
/**
 * Represents a single competence that a module either needs or teaches.
 * Doesnt contain any logic.
 */
public class Competence implements Serializable{

    private String name;
    
    public Competence() {
    	
    }

    public Competence(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competence other = (Competence) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
    
    
    
}
