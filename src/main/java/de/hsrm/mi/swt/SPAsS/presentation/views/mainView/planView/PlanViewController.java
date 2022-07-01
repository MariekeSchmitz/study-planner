package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.CenterViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.LeftSideViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.TopCenterViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PlanViewController extends ViewController{
    private ViewManager viewManager;
    private PlanView mainView;
    private Button testButton;
    private App app;
    private CenterViewController centerViewController;
    private TopCenterViewController topCenterViewController;
    private LeftSideViewController leftSideViewController;
    private Plan plan;

    public PlanViewController(ViewManager viewManager, App app) {
        this.viewManager = viewManager;
        this.app = app;
        this.plan = app.getPlan();
        


        centerViewController = new CenterViewController(plan, viewManager); 
        topCenterViewController = new TopCenterViewController(plan);
        leftSideViewController = new LeftSideViewController();
        
        mainView = new PlanView((AnchorPane)leftSideViewController.getRootView(), (AnchorPane)topCenterViewController.getRootView(), (AnchorPane)centerViewController.getRootView());
        rootView = mainView;
        
        
        testButton = mainView.getTestButton();        

        initialise();
    }
    @Override
    public void initialise() {
        testButton.addEventHandler(ActionEvent.ACTION, event -> { 
			viewManager.switchScene(Scenes.START_VIEW_CONTROLLER);
		});
    }
	public CenterViewController getCenterViewController() {
		return centerViewController;
	}
	public void setCenterViewController(CenterViewController centerViewController) {
		this.centerViewController = centerViewController;
	}   
    
    

}
