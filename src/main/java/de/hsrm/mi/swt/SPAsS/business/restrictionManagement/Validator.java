package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.SerialisableInterface;

public interface Validator extends SerialisableInterface {
    public ValidatorReturnObject validate(List <Module> moduleList);
}
