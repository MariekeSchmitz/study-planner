package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.SerialisableInterface;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

/**
 * A validator checks, whether each module in a plan is positioned validly or if certain conditions are violated.
 * Each Validator represents one condition.
 */
public interface Validator extends SerialisableInterface {
    /**
     * Validates the plan in relation to the validators condition
    * @param plan
    */
    public void validate(Plan plan);

    /**
     * returns error Message of a Validator
    */
	public String getMessage();
     /**
     * returns unique desciption of Validator
    */
    public String getDescription();

     /**
     * returns unique name of Validator
    */
    public String getName();
}
