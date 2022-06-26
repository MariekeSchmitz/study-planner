package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import javafx.scene.paint.Color;

public class ModuleViewController extends ViewController{

    private ModuleView mv;


    public ModuleViewController(String module, String zeile, Color color, double maxWidth) {
        mv = new ModuleView();
        mv.setMaxWidth(maxWidth);

    }

    @Override
    public void initialise() {
    }
    
}
