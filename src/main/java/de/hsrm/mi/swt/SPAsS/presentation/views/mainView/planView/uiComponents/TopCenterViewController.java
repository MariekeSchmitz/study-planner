package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;

public class TopCenterViewController extends ViewController{

	private TopCenterView topCenterView;
	private Plan plan;
	private Label gradeAverage;
	
    public TopCenterViewController(Plan plan) {
    	
        this.plan = plan;
    	
        topCenterView = new TopCenterView();
        rootView = topCenterView;
        
        gradeAverage = topCenterView.getPointAverage();
        
        initialise();
    }

    @Override
    public void initialise() {
        
    	if (plan.getAverageGrade().get() == 0.0f) {
    		gradeAverage.setText("Sobald du eine Prüfung bestanden hast, findest du hier deinen Notendurchschnitt.");
    	} else {
        	gradeAverage.setText("Aktueller Notendurchschnitt: " + Float.toString(plan.getAverageGrade().get()));
    	}
    	
    	
    	plan.getAverageGrade().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				
				System.out.println("Average Grade changed");
				
				if (plan.getAverageGrade().get() == 0.0f) {
		    		gradeAverage.setText("Sobald du eine Prüfung bestanden hast, findest du hier deinen Notendurchschnitt.");
		    	} else {
		        	gradeAverage.setText("Aktueller Notendurchschnitt: " + Float.toString(plan.getAverageGrade().get()));
		    	}
				
			}
				
			
		});
        
    }
    
}
