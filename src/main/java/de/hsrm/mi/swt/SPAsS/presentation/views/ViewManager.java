package de.hsrm.mi.swt.SPAsS.presentation.views;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.SelectViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.StartViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.UploadViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.MainViewController;
import javafx.scene.layout.StackPane;

public class ViewManager extends ViewController {

    private StackPane root;
    private App app;

    public ViewManager(App app) {
    	this.app = app;
        root = new StackPane();
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        rootView = root;
        initialise();
    }

    @Override
    public void initialise() {
    	switchScene(ScenesEmun.MAIN_VIEW_CONTROLLER);
    } 
    
    public void switchScene(ScenesEmun toScene) {
        if (toScene.equals(ScenesEmun.MAIN_VIEW_CONTROLLER)) {
            root.getChildren().clear();
            root.getChildren().add(new MainViewController(this, app).getRootView()); 
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

}
