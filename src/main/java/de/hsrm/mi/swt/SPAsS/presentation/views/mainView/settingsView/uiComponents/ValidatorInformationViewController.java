package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.uiComponents;

import de.hsrm.mi.swt.SPAsS.business.commands.ChangeCPSettingsCommand;
import de.hsrm.mi.swt.SPAsS.business.commands.CommandManager;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.CpLimitValidator;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import javafx.scene.control.TextField;

/**
 * Fills ValidatorInformationView with validator Details.
 * Reacts to User Input to change validator settings
 */
public class ValidatorInformationViewController extends ViewController {

    private ValidatorInformationView validatorInformationView;
    private TextField textInput;
    private Plan plan;

    public ValidatorInformationViewController(Plan p) {
        validatorInformationView = new ValidatorInformationView();
        rootView = validatorInformationView;
        textInput = validatorInformationView.getInput();
        plan = p;
        
        initialise();
    }

    @Override
    public void initialise() {
    	
    	textInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
			
			if (!newValue) {
				
				for (Validator validator : plan.getValidatorList()) {
					
					if (validator instanceof CpLimitValidator) {
						CpLimitValidator cpValidator = (CpLimitValidator)validator;
                        CommandManager.getInstance().execAndPush(new ChangeCPSettingsCommand(plan, cpValidator, Integer.valueOf(textInput.getText())));
						plan.validate();
					}
					
				}
				
				
			}
		});
        
    }
    
}
