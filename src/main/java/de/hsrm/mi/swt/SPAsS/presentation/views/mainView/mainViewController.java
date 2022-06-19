package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import de.hsrm.mi.swt.SPAsS.presentation.views.ScenesEmun;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MainViewController extends ViewController{
    private ViewManager viewManager;
    private MainView mainView;
    private Button testButton;

    public MainViewController(ViewManager viewManager) {
        this.viewManager = viewManager;
        mainView = new MainView();
        rootView = mainView;

        testButton = mainView.getTestButton();        

        initialise();
    }
    @Override
    public void initialise() {
        testButton.addEventHandler(ActionEvent.ACTION, event -> { 
			viewManager.switchScene(ScenesEmun.START_VIEW_CONTROLLER);
		});
    }   

}
