package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.StudyViewController;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SelectViewController extends ViewController{
    private SelectView sv;
    private HBox hbox;

    public SelectViewController() {
        sv = new SelectView();
        rootView = sv;

        hbox = sv.getHbox();
        
        for (int i = 0; i < 5 ; i++) {
            Pane test1 = new StudyViewController("Medieninformatik (B.Sc.)", "Hochschule RheinMain").getRootView();
            hbox.getChildren().add(test1);
        }


		
       
    }

    @Override
    public void initialise() {
        // TODO Auto-generated method stub
        
    }
    
}
