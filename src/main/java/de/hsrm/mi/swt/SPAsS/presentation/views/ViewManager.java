package de.hsrm.mi.swt.SPAsS.presentation.views;

import de.hsrm.mi.swt.SPAsS.presentation.views.introView.StartViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.UploadViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.MainViewController;
import javafx.scene.layout.StackPane;

public class ViewManager extends ViewController {

    private StackPane root;

    public ViewManager() {
        root = new StackPane();
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        rootView = root;
        initialise();
    
    }

	public void switchScene(ScenesEmun toScene) {
        if (toScene.equals(ScenesEmun.MAIN_VIEW_CONTROLLER)) {
            root.getChildren().clear();
            root.getChildren().add(new MainViewController(this).getRootView()); 
        } else if (toScene.equals(ScenesEmun.START_VIEW_CONTROLLER)) {
            root.getChildren().clear();
            root.getChildren().add(new StartViewController(this).getRootView()); 
        } else if (toScene.equals(ScenesEmun.UPLOAD_VIEW_CONTROLLER)) {
            root.getChildren().clear();
            root.getChildren().add(new UploadViewController(this).getRootView()); 
        }
    }    

    @Override
    public void initialise() {
        switchScene(ScenesEmun.MAIN_VIEW_CONTROLLER);
    }

}
