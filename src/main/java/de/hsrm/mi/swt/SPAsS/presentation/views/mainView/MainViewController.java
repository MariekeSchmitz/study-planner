package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView.ExamViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.ModuleInformationViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.PlanViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.SettingsViewController;
import javafx.scene.layout.StackPane;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

public class MainViewController extends ViewController{

    private StackPane mainViewStack;
    private SettingsViewController settingsViewController;
    private ExamViewController examViewController;
    private ModuleInformationViewController moduleInformationViewController;
    private PlanViewController planViewController;


    public MainViewController(ViewManager viewManager, App app) {
        
        mainViewStack = new StackPane();
        settingsViewController = new SettingsViewController(viewManager, app);
        examViewController = new ExamViewController(viewManager, app);
        moduleInformationViewController = new ModuleInformationViewController(this, app);
        planViewController = new PlanViewController(viewManager, app);
        mainViewStack.getChildren().add(planViewController.getRootView());
//        mainViewStack.getChildren().add(settingsViewController.getRootView());
//        mainViewStack.getChildren().add(examViewController.getRootView());
//        mainViewStack.getChildren().add(moduleInformationViewController.getRootView());
     
        rootView = mainViewStack;
        
        
        
    }
    @Override
    public void initialise() {
        
        
    }
    
   
    
    public void addView(Scenes scene) {
    	
    	if (scene == Scenes.MODULE_INFORMATION_VIEW) {
       	 	mainViewStack.getChildren().add(moduleInformationViewController.getRootView());

    	} else if (scene == Scenes.EXAM_VIEW) {
       	 	mainViewStack.getChildren().add(examViewController.getRootView());
       	 	
    	} else if (scene == Scenes.SETTINGS_VIEW) {
       	 	mainViewStack.getChildren().add(settingsViewController.getRootView());
    	}
    	
    }
    
    public void removeView(Scenes scene) {
    	if (scene == Scenes.MODULE_INFORMATION_VIEW) {
       	 	mainViewStack.getChildren().remove(moduleInformationViewController.getRootView());

    	} else if (scene == Scenes.EXAM_VIEW) {
       	 	mainViewStack.getChildren().add(examViewController.getRootView());
       	 	
    	} else if (scene == Scenes.SETTINGS_VIEW) {
       	 	mainViewStack.getChildren().add(settingsViewController.getRootView());
    	}
    }
    
    
    public void putModuleViewOnStack(Module module) {
    	
    	moduleInformationViewController.setModuleInformation(module);
   	 	mainViewStack.getChildren().add(moduleInformationViewController.getRootView());

    }
    
    
    
}
