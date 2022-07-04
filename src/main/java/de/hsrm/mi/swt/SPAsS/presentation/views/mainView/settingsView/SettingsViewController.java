package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView;

import java.util.List;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.CpLimitValidator;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.uiComponents.ValidatorInformationView;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.uiComponents.ValidatorInformationViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Controller for SettingsView
 * Dynamically fills SettingsView with needed Components
 */
public class SettingsViewController extends ViewController{
    
    private ViewManager viewManager;
    private SettingsView settingsView;

    private Plan plan;
    private List<Validator> validatorList;

    private Button backButton;
    private VBox box;

    private ValidatorInformationViewController validatorInformationViewController;
    private ValidatorInformationView validatorInformationView;

    public SettingsViewController(ViewManager viewManager, App app) {
        this.viewManager = viewManager;
        settingsView = new SettingsView();
        rootView = settingsView;

        backButton = settingsView.getBackButton();
        box = settingsView.getBox();

        plan = app.getPlan();
        validatorList = plan.getValidatorList();

        setContent();
        initialise();
    }

    @Override
    public void initialise() {
        backButton.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("backButton");
    		viewManager.getMainViewController().transitionOut(Scenes.SETTINGS_VIEW);
    		Scenes.SETTINGS_VIEW.setIn(false);
    	});  
        
    }

    public void setContent(){

        for (Validator validator : validatorList) {
            validatorInformationViewController = new ValidatorInformationViewController(plan);
            validatorInformationView = (ValidatorInformationView) validatorInformationViewController.getRootView();
            validatorInformationView.getHeader().setText(validator.getName());
            validatorInformationView.getDescription().setText(validator.getDescription());
            box.getChildren().addAll(validatorInformationView);
            
            if (!(validator instanceof CpLimitValidator)) {
            	
            	validatorInformationView.removeInputBox();
            	
            } else {
            	
            	CpLimitValidator cpValidator = (CpLimitValidator)validator;
            	validatorInformationView.getInput().setText(String.valueOf(cpValidator.getCpLimit()));
            	
            }
        }
    
        
    }

}
