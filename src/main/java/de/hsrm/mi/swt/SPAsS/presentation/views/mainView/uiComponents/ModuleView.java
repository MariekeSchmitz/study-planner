package de.hsrm.mi.swt.projekt.uicomponents;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ModuleView extends AnchorPane{

    private Label moduleLabel;
    private Label cpLabel;

    private double startX;
    private double startY;

    public ModuleView(String module, String cp, Color color) {

        moduleLabel = new Label(module);
        moduleLabel.getStyleClass().add("module");

        cpLabel = new Label(cp);
        cpLabel.getStyleClass().add("module");

        AnchorPane.setLeftAnchor(moduleLabel, 10.0);
        AnchorPane.setTopAnchor(moduleLabel, 10.0);

        AnchorPane.setLeftAnchor(cpLabel, 10.0);
        AnchorPane.setTopAnchor(cpLabel, 30.0);

        this.setTranslateX(50);
        this.setTranslateY(50);

        // this.getStyleClass().add("test-border-yellow");
        this.getChildren().addAll(moduleLabel, cpLabel);
        this.setPrefSize(1000, 300);
        this.setMaxHeight(50);
        this.setMaxWidth(150);
        this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(0), new Insets(0))));
    }
    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    
}
