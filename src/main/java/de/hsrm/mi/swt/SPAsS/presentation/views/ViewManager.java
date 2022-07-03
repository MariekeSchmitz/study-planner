package de.hsrm.mi.swt.SPAsS.presentation.views;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.SelectView;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.SelectViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.StartView;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.StartViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.UploadView;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.UploadViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.MainViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.ModuleInformationView;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.moduleInformationView.ModuleInformationViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.PlanViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.SettingsViewController;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ViewManager {

    private StackPane root;
    private App app;
    private MainViewController mainViewController;
    private StartView startView;

    public ViewManager(App app) {
    	this.app = app;
        root = new StackPane();
        root.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

        initialise();
       
    }

    public void initialise() {
    	switchScene(Scenes.START_VIEW);
    } 
    
    public void switchScene(Scenes toScene) {
        if (toScene.equals(Scenes.MAIN_VIEW)) {
            root.getChildren().clear();
        	mainViewController = new MainViewController(this, app);
            root.getChildren().add(mainViewController.getRootView());
            
        } else if (toScene.equals(Scenes.START_VIEW)) {
            root.getChildren().clear();
            startView = (StartView)new StartViewController(this, app).getRootView();
            root.getChildren().add(startView); 
            
        } else if (toScene.equals(Scenes.UPLOAD_CURRICULUM_VIEW)) {
        	UploadView uploadView = (UploadView)new UploadViewController(this, app, FileType.CURRICULA).getRootView();
        	uploadView.getHeader().setText("Studiengang \nwählen");
            startView.getUploadPane().setCenter(uploadView);
            
        } else if (toScene.equals(Scenes.SELECT_VIEW)) {
        	SelectView selectView = (SelectView)new SelectViewController(this,app).getRootView();
            startView.getUploadPane().setCenter(selectView);
        
        } else if (toScene.equals(Scenes.UPLOAD_PLAN_VIEW)) {
        	UploadView uploadView = (UploadView)new UploadViewController(this, app, FileType.PLAN).getRootView();
        	uploadView.getHeader().setText("Eigenen Plan \nwählen");
            startView.getUploadPane().setCenter(uploadView);       
        }

    } 
    	
    public Pane getRoot(){
        return root;
    }
    
    public MainViewController getMainViewController() {
    	return mainViewController;
    }
}
