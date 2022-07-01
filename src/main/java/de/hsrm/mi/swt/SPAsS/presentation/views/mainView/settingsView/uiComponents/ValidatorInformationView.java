package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.uiComponents;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ValidatorInformationView extends VBox {

    private Label header;
    private Label description;

    public ValidatorInformationView() {
        header = new Label("ValidatorÜberschrift");
        header.setWrapText(true);
        header.setTextFill(Color.BLACK);

        description = new Label("");
        description.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        description.setWrapText(true);
        description.setTextFill(Color.BLACK);

        this.setSpacing(10);
        this.getChildren().addAll(header, description);
    }

    public Label getHeader() {
        return header;
    }

    public void setHeader(Label header) {
        this.header = header;
    }

    public Label getDescripction() {
        return description;
    }

    public void setDescripction(Label descripction) {
        this.description = descripction;
    }
    
}
