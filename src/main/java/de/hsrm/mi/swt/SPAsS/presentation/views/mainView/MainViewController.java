package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView.ExamView;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView.ExamViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.ModuleInformationView;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.ModuleInformationViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.PlanViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.LeftSideView;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.LeftSideViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.SettingsView;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.SettingsViewController;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

/**
 * Combines all Plan-related Views into single Layer
 * Also contains transition-animations
 */
public class MainViewController extends ViewController{

    private StackPane mainViewStack;
    private SettingsViewController settingsViewController;
    private ExamViewController examViewController;
    private ModuleInformationViewController moduleInformationViewController;
    private PlanViewController planViewController;
	private LeftSideViewController leftSideViewController;
    
    private ModuleInformationView moduleInformationView;
    private ExamView examView;
    private SettingsView settingsView;
	private LeftSideView leftSideView;
	private Pane backgroundPane;

    
    private App app;


    public MainViewController(ViewManager viewManager, App app) {
        
    	this.app = app;
    	
        mainViewStack = new StackPane();
		leftSideViewController = new LeftSideViewController(viewManager);
        settingsViewController = new SettingsViewController(viewManager, app);
        examViewController = new ExamViewController(viewManager, app);
        moduleInformationViewController = new ModuleInformationViewController(this, app);
        planViewController = new PlanViewController(viewManager, app);
        mainViewStack.getChildren().add(planViewController.getRootView());

        this.examView = (ExamView)examViewController.getRootView();
        this.moduleInformationView= (ModuleInformationView)moduleInformationViewController.getRootView(); 
        this.settingsView = (SettingsView)settingsViewController.getRootView();
        this.leftSideView = (LeftSideView) leftSideViewController.getRootView();
        backgroundPane = new Pane();
        backgroundPane.getStyleClass().add("BackgroundBackButton");
        rootView = mainViewStack;
        
        
        initialise();
        
    }
    
    @Override
    public void initialise() {
    	StackPane.setAlignment(moduleInformationView, Pos.CENTER_RIGHT);
    	StackPane.setAlignment(examView, Pos.CENTER_RIGHT);
		StackPane.setAlignment(settingsView, Pos.CENTER_LEFT);
		StackPane.setAlignment(leftSideView, Pos.CENTER_LEFT);

    	moduleInformationView.setVisible(false);
    	examView.setVisible(false);
		settingsView.setVisible(false);
		backgroundPane.setVisible(false);
		mainViewStack.getChildren().add(backgroundPane);
    	mainViewStack.getChildren().add(moduleInformationView);
        mainViewStack.getChildren().add(examView);
		mainViewStack.getChildren().add(settingsView);
		mainViewStack.getChildren().add(leftSideView);


    }
    
   
    /**
 * Adds View to Stack
 */
    public void addView(Scenes scene) {
    	
    	if (scene == Scenes.MODULE_INFORMATION_VIEW) {
       	 	mainViewStack.getChildren().add(moduleInformationView);

    	} else if (scene == Scenes.EXAM_VIEW) {
       	 	mainViewStack.getChildren().add(examView);
       	 	
    	} else if (scene == Scenes.SETTINGS_VIEW) {
       	 	mainViewStack.getChildren().add(settingsView);
    	} 	
    }
    
	/**
 * Removes View from Stack
 */
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
    	
    	if (!Scenes.MODULE_INFORMATION_VIEW.isIn()) {
        	this.transitionIn(moduleInformationViewController, false);
	        moduleInformationView.setEffect(new DropShadow(204,0,2, Color.rgb(49, 49, 64)));
        	Scenes.MODULE_INFORMATION_VIEW.setIn(true);
    		setBackgroundVisible();

    	} 
    	
    	
    	
//   	 	mainViewStack.getChildren().add(moduleInformationViewController.getRootView());
    }
    
    
    public void putExamViewOnStack() {
    	
    	this.transitionIn(examViewController, false);
        examView.setEffect(new DropShadow(204,0,2, Color.rgb(49, 49, 64)));
    	Scenes.EXAM_VIEW.setIn(true);
		setBackgroundVisible();
    	
    }

	public void putSettingsViewOnStack(){
		if (!Scenes.SETTINGS_VIEW.isIn()) {
			this.transitionIn(settingsViewController, true);
	        settingsView.setEffect(new DropShadow(204,0,2, Color.rgb(49, 49, 64)));
			Scenes.SETTINGS_VIEW.setIn(true);
			setBackgroundVisible();

		}
			
	}
	
	public void setBackgroundVisible() {
		if(Scenes.SETTINGS_VIEW.isIn() || Scenes.EXAM_VIEW.isIn() || Scenes.MODULE_INFORMATION_VIEW.isIn()) {
			backgroundPane.setVisible(true);
		} else {
			backgroundPane.setVisible(false);
		}
	}
    
    

    
    private void transitionIn(ViewController viewController, boolean toRight) {
    	
    	Pane rootView = viewController.getRootView();
    	
    	rootView.setVisible(false);
    	
    	if(toRight) {
        	rootView.setTranslateX(-rootView.getMaxWidth());
    	} else {
        	rootView.setTranslateX(rootView.getMaxWidth());
    	}
    	rootView.setVisible(true);  
    	
		TranslateTransition transitionAnim = new TranslateTransition();
		transitionAnim.setNode(rootView);
		transitionAnim.setDuration(Duration.millis(400));
		transitionAnim.setInterpolator(Interpolator.EASE_OUT);
		transitionAnim.setToX(0);
		transitionAnim.playFromStart();
	}
    
    public void transitionOut(Scenes scene) {
		TranslateTransition transitionAnim = new TranslateTransition();
		
	
		switch (scene) {
			case MODULE_INFORMATION_VIEW:
				transitionAnim.setNode(moduleInformationView);
				transitionAnim.setToX(moduleInformationView.getMaxWidth());
				moduleInformationView.setEffect(null);
				Scenes.MODULE_INFORMATION_VIEW.setIn(false);
				break;
			case SETTINGS_VIEW:
				transitionAnim.setNode(settingsView);
				transitionAnim.setToX(-settingsView.getMaxWidth());
				settingsView.setEffect(null);
				Scenes.SETTINGS_VIEW.setIn(false);
				break;
			case EXAM_VIEW:
				transitionAnim.setNode(examView);
				transitionAnim.setToX(examView.getMaxWidth());
				examView.setEffect(null);
				Scenes.EXAM_VIEW.setIn(false);
				break;
		}
		
		transitionAnim.setDuration(Duration.millis(200));
		transitionAnim.setInterpolator(Interpolator.EASE_OUT);
		transitionAnim.playFromStart();
		setBackgroundVisible();

	}

	public SettingsViewController getSettingsViewController() {
		return settingsViewController;
	}

	public void setSettingsViewController(SettingsViewController settingsViewController) {
		this.settingsViewController = settingsViewController;
	}

	public ExamViewController getExamViewController() {
		return examViewController;
	}

	public void setExamViewController(ExamViewController examViewController) {
		this.examViewController = examViewController;
	}

	public ModuleInformationViewController getModuleInformationViewController() {
		return moduleInformationViewController;
	}

	public void setModuleInformationViewController(ModuleInformationViewController moduleInformationViewController) {
		this.moduleInformationViewController = moduleInformationViewController;
	}

	public PlanViewController getPlanViewController() {
		return planViewController;
	}

	public void setPlanViewController(PlanViewController planViewController) {
		this.planViewController = planViewController;
	}
    
	
    
    
    
    
    
    
    
}
