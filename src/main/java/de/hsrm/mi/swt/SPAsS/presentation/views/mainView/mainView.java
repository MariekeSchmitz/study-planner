package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents.CenterViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents.LeftSideViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents.TopCenterViewController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainView extends AnchorPane{
    
    private Label testLabel;
    private Button testButton;
    private VBox vbox;

    private AnchorPane leftSideMenu;
    private AnchorPane topCenter;
    private AnchorPane center;

    private BorderPane rightSide;

    public MainView() {

        //leftside
        leftSideMenu = (AnchorPane) new LeftSideViewController().getRootView();

        AnchorPane.setTopAnchor(leftSideMenu, 0.0);
        AnchorPane.setLeftAnchor(leftSideMenu,  0.0);
        AnchorPane.setBottomAnchor(leftSideMenu, 0.0);

        center = (AnchorPane) new CenterViewController().getRootView();

        topCenter = (AnchorPane) new TopCenterViewController().getRootView();

        testButton = new Button("Switch");

        rightSide = new BorderPane();
        rightSide.setTop(topCenter);
        rightSide.setCenter(center);

        AnchorPane.setTopAnchor(rightSide, 0.0);
		AnchorPane.setLeftAnchor(rightSide,  75.0);
        AnchorPane.setRightAnchor(rightSide,  0.0);
        AnchorPane.setBottomAnchor(rightSide, 0.0);

        this.getChildren().addAll(leftSideMenu, testButton, rightSide);
    }

    public Label getTestLabel() {
        return testLabel;
    }

    public Button getTestButton() {
        return testButton;
    }
    

}

