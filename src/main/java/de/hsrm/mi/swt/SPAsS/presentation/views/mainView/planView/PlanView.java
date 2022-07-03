package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView;

import javafx.scene.layout.AnchorPane;
public class PlanView extends AnchorPane{
    
    public PlanView( AnchorPane center) {    	

        AnchorPane.setTopAnchor(center, 0.0);
		AnchorPane.setLeftAnchor(center,  75.0);
        AnchorPane.setRightAnchor(center,  0.0);
        AnchorPane.setBottomAnchor(center, 0.0);

        this.getChildren().addAll(center);
    }
}

