package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;

public class TitelPlanViewController extends ViewController{

    public TitelPlanViewController(String titel, String study) {
        rootView = new TitelPlanView(titel, study);
    }

    @Override
    public void initialise() {
        // TODO Auto-generated method stub
        
    }
    
}
