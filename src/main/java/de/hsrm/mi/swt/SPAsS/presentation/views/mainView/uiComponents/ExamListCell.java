package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;

public class ExamListCell extends ListCell<Module>{

    private AnchorPane mainPane;

    private Label header;

    public ExamListCell() {
        mainPane = new AnchorPane();

        header = new Label("");

        AnchorPane.setTopAnchor(header, 50.0);
        AnchorPane.setLeftAnchor(header, 50.0);

        this.getChildren().addAll(header);
        this.getStyleClass().add("test-border-red");
        this.setMaxWidth(500);
    }

    @Override
	public void updateItem(Module item, boolean empty) {
		super.updateItem(item, empty);
		
		if(!empty) {
            header.setText(item.getName());
			this.setGraphic(mainPane);
		} else {
			this.setGraphic(null);
		}
	}
}
