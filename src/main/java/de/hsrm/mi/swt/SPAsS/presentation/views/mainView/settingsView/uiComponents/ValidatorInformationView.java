package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView.uiComponents;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Visual Component for Validator - Details
 */
public class ValidatorInformationView extends VBox {

    private Label header;
    private Label description;
    private TextField input;
    private HBox inputBox;
    private Label inputLabel;

    public ValidatorInformationView() {
        header = new Label("ValidatorÜberschrift");
        header.setWrapText(true);

        description = new Label("");
        description.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
        description.setWrapText(true);
                
        inputBox = new HBox(5);
        input = new TextField();
        inputLabel = new Label("Credit Points");
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.getChildren().addAll(input,inputLabel);

        this.setSpacing(10);
        this.getChildren().addAll(header, inputBox, description);
    }

    public Label getHeader() {
        return header;
    }

    public void setHeader(Label header) {
        this.header = header;
    }

    

	public Label getDescription() {
		return description;
	}

	public void setDescription(Label description) {
		this.description = description;
	}

	public TextField getInput() {
		return input;
	}

	public void setInput(TextField input) {
		this.input = input;
	}
	
	public void removeInputBox() {
		this.getChildren().remove(inputBox);
	}
    
    
    
}
