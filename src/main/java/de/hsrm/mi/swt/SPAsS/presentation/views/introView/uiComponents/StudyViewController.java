package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;

public class StudyViewController extends ViewController{

    public StudyViewController(String study, String campus) {
        rootView = new StudyView(study, campus);
    }

    @Override
    public void initialise() {
        // TODO Auto-generated method stub
        
    }
    
}
