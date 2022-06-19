package de.hsrm.mi.swt.SPAsS.business.restrictionManagement;

import java.util.List;

public interface Validator {
    public ValidatorReturnObject validate(List <Module> moduleList);
}
