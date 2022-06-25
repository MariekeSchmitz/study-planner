package de.hsrm.mi.swt.SPAsS.presentation.views;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.SelectViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.StartViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.UploadViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.MainViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.ModuleInformationView;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.ModuleInformationViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.PlanViewController;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ViewManager {

    private StackPane root;
    private App app;
    private MainViewController mainViewController;

    public ViewManager(App app) {
    	this.app = app;
        root = new StackPane();
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	mainViewController = new MainViewController(this, app);

        initialise();
       
    }

    public void initialise() {
    	switchScene(ScenesEmun.MAIN_VIEW_CONTROLLER);
    } 
    
    public void switchScene(ScenesEmun toScene) {
        if (toScene.equals(ScenesEmun.MAIN_VIEW_CONTROLLER)) {
            root.getChildren().clear();
            root.getChildren().add(mainViewController.getRootView()); 
        } else if (toScene.equals(ScenesEmun.START_VIEW_CONTROLLER)) {
            root.getChildren().clear();
            root.getChildren().add(new StartViewController(this).getRootView()); 
        } else if (toScene.equals(ScenesEmun.UPLOAD_VIEW_CONTROLLER)) {
            root.getChildren().clear();
            root.getChildren().add(new UploadViewController(this).getRootView()); 
        } else if (toScene.equals(ScenesEmun.SELECT_VIEW)) {
	        root.getChildren().clear();
	        root.getChildren().add(new SelectViewController().getRootView()); 
        } 
    } 
    	
    public Pane getRoot(){
        return root;
    }
    
    public MainViewController getMainViewController() {
    	return mainViewController;
    }
}
