package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView;

import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.CenterViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents.LeftSideViewController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PlanView extends AnchorPane{
    
    private Label testLabel;
    private Button testButton;
    private VBox vbox;

    private AnchorPane leftSideMenu;
    private AnchorPane topCenter;
    private AnchorPane center;

    private AnchorPane rightSide;

    public PlanView(AnchorPane leftSideMenu, AnchorPane center) {

    	this.leftSideMenu = leftSideMenu;
    	this.center = center;
    	
        //leftside
        AnchorPane.setTopAnchor(leftSideMenu, 0.0);
        AnchorPane.setLeftAnchor(leftSideMenu,  0.0);
        AnchorPane.setBottomAnchor(leftSideMenu, 0.0);

        testButton = new Button("Switch");

        AnchorPane.setTopAnchor(center, 0.0);
		AnchorPane.setLeftAnchor(center,  75.0);
        AnchorPane.setRightAnchor(center,  0.0);
        AnchorPane.setBottomAnchor(center, 0.0);

        this.getChildren().addAll(leftSideMenu, testButton, center);
    }

    public Label getTestLabel() {
        return testLabel;
    }

    public Button getTestButton() {
        return testButton;
    }
    

}

