package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.SerialisableInterface;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;

public interface Validator extends SerialisableInterface {
    public void validate(Plan plan);
}
