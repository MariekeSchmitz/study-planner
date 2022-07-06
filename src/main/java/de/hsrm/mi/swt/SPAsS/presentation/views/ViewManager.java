package de.hsrm.mi.swt.SPAsS.presentation.views;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.SelectView;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.SelectViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.StartView;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.StartViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.UploadView;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.UploadViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.loadingView.LoadingView;
import de.hsrm.mi.swt.SPAsS.presentation.views.loadingView.LoadingViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.MainViewController;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * Manages core Views by enabling a switch of scenes
 */
public class ViewManager {

    private StackPane root;
    private App app;
    private MainViewController mainViewController;
    private StartView startView;
    private LoadingView loadingView;
    private StackPane loadingStack;

    public ViewManager(App app) {
    	this.app = app;
        root = new StackPane();
        loadingStack = new StackPane();
        root.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

        initialise();
       
    }


    public void initialise() {
    	switchScene(Scenes.LOADING_VIEW);
    } 
    

    
    /** 
     * @param toScene Scene to be swapped to
     * switches Scenes
     */
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
        	uploadView.getHeader().setText("Studiengang");
        	uploadView.getHeader1().setText("wählen");
            AnchorPane.setTopAnchor(uploadView, 130.0); 
    		AnchorPane.setLeftAnchor(uploadView, 130.0);
    		AnchorPane.setRightAnchor(uploadView, 130.0);
            AnchorPane.setBottomAnchor(uploadView, 130.0);   
            startView.getUploadPane().getChildren().add(uploadView);
            
        } else if (toScene.equals(Scenes.SELECT_VIEW)) {
        	SelectView selectView = (SelectView)new SelectViewController(this,app).getRootView();
            AnchorPane.setTopAnchor(selectView, 130.0); 
    		AnchorPane.setLeftAnchor(selectView, 130.0);
    		AnchorPane.setRightAnchor(selectView, 130.0);
            AnchorPane.setBottomAnchor(selectView, 130.0);   
            startView.getUploadPane().getChildren().add(selectView);
        
        } else if (toScene.equals(Scenes.UPLOAD_PLAN_VIEW)) {
        	UploadView uploadView = (UploadView)new UploadViewController(this, app, FileType.PLAN).getRootView();
        	uploadView.getHeader().setText("Eigenen Plan");
        	uploadView.getHeader1().setText("wählen");
            AnchorPane.setTopAnchor(uploadView, 130.0); 
    		AnchorPane.setLeftAnchor(uploadView, 130.0);
    		AnchorPane.setRightAnchor(uploadView, 130.0);
            AnchorPane.setBottomAnchor(uploadView, 130.0);   
            startView.getUploadPane().getChildren().add(uploadView);   
        
        } else if (toScene.equals(Scenes.LOADING_VIEW)) {
        	startView = (StartView)new StartViewController(this, app).getRootView();
        	loadingView = (LoadingView)new LoadingViewController(this).getRootView();
        	
        	loadingStack.getChildren().addAll(startView,loadingView);
        	root.getChildren().add(loadingStack);
        	
//            startView = (StartView)new StartViewController(this, app).getRootView();
//            root.getChildren().add(startView);
        }

    } 
    	
    
    /** 
     * @return Pane
     */
    public Pane getRoot(){
        return root;
    }
    
    
    /** 
     * @return MainViewController
     */
    public MainViewController getMainViewController() {
    	return mainViewController;
    }
}
