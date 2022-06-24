package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CenterView extends AnchorPane{
    
    private VBox vboxNumber;
    private HBox hBoxAdd;
    private StackPane plan;
    private Button addSemester;
    private Button addKlausur;

    public CenterView(){
        this.getStyleClass().add("center");

        vboxNumber = new VBox();
        vboxNumber.setPrefWidth(60);
        vboxNumber.setSpacing(15);
        vboxNumber.setAlignment(Pos.BOTTOM_CENTER);

        plan = new StackPane();
        this.getStyleClass().add("test-border-red");
        plan.setAlignment(Pos.BOTTOM_LEFT);

        hBoxAdd = new HBox();
        hBoxAdd.setPrefHeight(40);
        hBoxAdd.setSpacing(10);

        addSemester = new Button("Semester hinzufügen");
        addSemester.getStyleClass().add("addSemester");
        addSemester.setMaxSize(2000, 40);

        addKlausur = new Button("Zurücksetzen");
        addKlausur.setPrefSize(200,40);
        addKlausur.getStyleClass().add("buttons");

        HBox.setHgrow(addSemester, Priority.ALWAYS);
        HBox.setHgrow(addKlausur, Priority.ALWAYS);
        hBoxAdd.getChildren().addAll(addSemester, addKlausur);

        AnchorPane.setLeftAnchor(hBoxAdd, 125.0);
        AnchorPane.setTopAnchor(hBoxAdd, 50.0);
        AnchorPane.setRightAnchor(hBoxAdd, 50.0);

        AnchorPane.setLeftAnchor(addSemester, 125.0);
        AnchorPane.setTopAnchor(addSemester, 50.0);
        AnchorPane.setRightAnchor(addSemester, 50.0);
        
        AnchorPane.setLeftAnchor(plan, 125.0);
        AnchorPane.setTopAnchor(plan, 100.0);
        AnchorPane.setBottomAnchor(plan, 50.0);
        AnchorPane.setRightAnchor(plan, 50.0);

        AnchorPane.setLeftAnchor(vboxNumber, 50.0);
        AnchorPane.setTopAnchor(vboxNumber, 100.0);
        AnchorPane.setBottomAnchor(vboxNumber, 50.0);

        this.getChildren().addAll(vboxNumber, plan, hBoxAdd);
    }

}