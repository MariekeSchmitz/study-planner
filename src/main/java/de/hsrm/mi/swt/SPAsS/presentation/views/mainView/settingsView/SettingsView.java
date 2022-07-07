package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.settingsView;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * View for Settings
 */
public class SettingsView extends AnchorPane {

    private Label header;

    private Button backButton;
    private Label textField;

    private ScrollPane scrollPane;
    private VBox box;

    public SettingsView() {        
        header = new Label("Einschränkungen");
		header.getStyleClass().add("ModuleHeader");
		header.setTextFill(Color.WHITE);

        box = new VBox(30);
        textField = new Label();
        textField.setWrapText(true);
        textField.setTextFill(Color.WHITE);

		ImageView ivIcon = new ImageView(new Image(File.separator+"images" + File.separator +"XWeiss.png"));
		ivIcon.setFitHeight(50);
		ivIcon.setFitWidth(50);
		backButton = new Button();
		backButton.setGraphic(ivIcon);
		backButton.getStyleClass().add("backButton");
		backButton.setPrefSize(100, 100);
        backButton.setMaxSize(50, 50);

        box.getChildren().add(textField);

        scrollPane = new ScrollPane();
        scrollPane.setContent(box);
        scrollPane.fitToHeightProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
		scrollPane.setPannable(true);

        AnchorPane.setTopAnchor(backButton, 30.0);
        AnchorPane.setRightAnchor(backButton, 30.0);

        AnchorPane.setTopAnchor(header, 125.0);
        AnchorPane.setLeftAnchor(header, 150.0);
		AnchorPane.setRightAnchor(header, 150.0);
		header.setMaxWidth(300);

        AnchorPane.setTopAnchor(scrollPane, 155.0);
        AnchorPane.setLeftAnchor(scrollPane, 150.0);
		AnchorPane.setRightAnchor(scrollPane, 150.0);
        AnchorPane.setBottomAnchor(scrollPane, 0.0);

        this.getChildren().addAll(header, backButton, scrollPane);
        this.setEffect(new DropShadow(204,0,2, Color.rgb(49, 49, 64)));
        this.getStylesheets().add(getClass().getResource("/css/settingsView.css").toExternalForm());
		this.setId("secondColor");
        this.setMaxWidth(755);
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
