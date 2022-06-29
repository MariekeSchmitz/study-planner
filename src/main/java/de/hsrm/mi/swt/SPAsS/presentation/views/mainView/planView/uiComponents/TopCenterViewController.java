package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;

public class TopCenterViewController extends ViewController  implements PropertyChangeListener{

	private TopCenterView topCenterView;
	private Plan plan;
	private Label gradeAverage;
	
    public TopCenterViewController(Plan plan) {
    	
        this.plan = plan;
        plan.addPropertyChangeListener(this);

    	
        topCenterView = new TopCenterView();
        rootView = topCenterView;
        
        gradeAverage = topCenterView.getPointAverage();
        
        initialise();
    }

    @Override
    public void initialise() {
        
    	if (plan.getAverageGrade() == 0.0f) {
    		gradeAverage.setText("Sobald du eine Prüfung bestanden hast, findest du hier deinen Notendurchschnitt.");
    	} else {
        	gradeAverage.setText("Aktueller Notendurchschnitt: " + Float.toString(plan.getAverageGrade()));
    	}
    	
    	
    	
    	
    
        
    }

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		
		// UI bei Änderung des zugehörigen Domänenobjekts (Kringel) aktualisieren
		System.out.println("AverageGrade Update " + event);
		
		switch (event.getPropertyName()) {
			case "average":
				if (plan.getAverageGrade() == 0.0f) {
		    		gradeAverage.setText("Sobald du eine Prüfung bestanden hast, findest du hier deinen Notendurchschnitt.");
		    	} else {
		        	gradeAverage.setText("Aktueller Notendurchschnitt: " + Float.toString(plan.getAverageGrade()));
		    	}
			break;
			
			default:
				throw new IllegalArgumentException("UnbehandeltesEvent " + event);
		}
		
	}
    
}
