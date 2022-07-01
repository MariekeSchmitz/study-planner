package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;

public class TitelPlanViewController extends ViewController{

    public TitelPlanViewController(String titel, String degreeProgram, String institution) {
        rootView = new TitelPlanView(titel, degreeProgram, institution);
    }

    @Override
    public void initialise() {
        // TODO Auto-generated method stub
        
    }
    
}
