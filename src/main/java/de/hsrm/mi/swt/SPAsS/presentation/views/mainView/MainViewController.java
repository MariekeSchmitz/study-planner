package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ScenesEmun;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents.CenterViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents.LeftSideViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents.TopCenterViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainViewController extends ViewController{
    private ViewManager viewManager;
    private MainView mainView;
    private Button testButton;
    private App app;
    private CenterViewController centerViewController;
    private TopCenterViewController topCenterViewController;
    private LeftSideViewController leftSideViewController;
    private Plan plan;

    public MainViewController(ViewManager viewManager, App app) {
        this.viewManager = viewManager;
        this.app = app;
        this.plan = app.getPlan();
        


        centerViewController = new CenterViewController(plan); 
        topCenterViewController = new TopCenterViewController();
        leftSideViewController = new LeftSideViewController();
        
        mainView = new MainView((AnchorPane)leftSideViewController.getRootView(), (AnchorPane)topCenterViewController.getRootView(), (AnchorPane)centerViewController.getRootView());
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
