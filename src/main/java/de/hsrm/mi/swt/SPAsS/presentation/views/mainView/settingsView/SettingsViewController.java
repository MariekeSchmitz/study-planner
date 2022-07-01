package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.MainViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class SettingsViewController extends ViewController{
    
    private ViewManager viewManager;
    private SettingsView settingsView;

    private Button backButton;

    public SettingsViewController(ViewManager viewManager, App app) {
        this.viewManager = viewManager;
        settingsView = new SettingsView();
        rootView = settingsView;

        backButton = settingsView.getBackButton();
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

}
