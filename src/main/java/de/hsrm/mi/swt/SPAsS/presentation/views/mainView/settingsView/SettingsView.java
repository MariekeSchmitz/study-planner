package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SettingsView extends AnchorPane {

    private Label header;

    private Button backButton;
    private Label textField;

    private ScrollPane scrollPane;
    private VBox box;

    public SettingsView() {        
        header = new Label("Einschränkungen");
		header.getStyleClass().add("ModuleHeader");

        box = new VBox(30);
        textField = new Label();
        textField.setWrapText(true);

        backButton = new Button("back");
		backButton.getStyleClass().add("backbutton");
		backButton.setPrefSize(100, 100);
        backButton.setMaxSize(50, 50);

        box.getChildren().add(textField);

        scrollPane = new ScrollPane();
        scrollPane.setContent(box);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
		scrollPane.setPannable(true);

        AnchorPane.setTopAnchor(backButton, 30.0);
        AnchorPane.setRightAnchor(backButton, 50.0);

        AnchorPane.setTopAnchor(header, 75.0);
        AnchorPane.setLeftAnchor(header, 150.0);
		AnchorPane.setRightAnchor(header, 150.0);
		header.setMaxWidth(300);

        AnchorPane.setTopAnchor(scrollPane, 125.0);
        AnchorPane.setLeftAnchor(scrollPane, 150.0);
		AnchorPane.setRightAnchor(scrollPane, 50.0);
        AnchorPane.setBottomAnchor(scrollPane, 0.0);

        this.getChildren().addAll(header, backButton, scrollPane);
        this.getStylesheets().add(getClass().getResource("/css/settingsView.css").toExternalForm());
		this.getStyleClass().add("left-side-pane");
        this.setMaxWidth(675);
    }


    public Label getHeader() {
        return header;
    }


    public Button getBackButton() {
        return backButton;
    }


    public void setHeader(Label header) {
        this.header = header;
    }


    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }


    public Label getTextField() {
        return textField;
    }


    public void setTextField(Label textField) {
        this.textField = textField;
    }


    public ScrollPane getScrollPane() {
        return scrollPane;
    }


    public void setScrollPane(ScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }


    public VBox getBox() {
        return box;
    }


    public void setBox(VBox box) {
        this.box = box;
    }
    
}
