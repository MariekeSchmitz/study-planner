package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.CenterViewController;
import javafx.scene.layout.AnchorPane;

public class PlanViewController extends ViewController{
    private PlanView mainView;
    private CenterViewController centerViewController;
    private Plan plan;

    public PlanViewController(ViewManager viewManager, App app) {
        this.plan = app.getPlan();

        centerViewController = new CenterViewController(plan, viewManager); 
        
        mainView = new PlanView((AnchorPane)centerViewController.getRootView());
        rootView = mainView;     

        initialise();
    }
    @Override
    public void initialise() {}

	public CenterViewController getCenterViewController() {
		return centerViewController;
	}
	public void setCenterViewController(CenterViewController centerViewController) {
		this.centerViewController = centerViewController;
	}   

}
