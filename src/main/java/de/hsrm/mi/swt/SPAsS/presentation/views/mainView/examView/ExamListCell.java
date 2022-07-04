package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView;

import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ExamListCell extends ListCell<ExamModule>{

    private HBox mainPane;
    private VBox vbox;

    private Label header;
    private Label cp;

    public ExamListCell() {
        mainPane = new HBox();
        mainPane.setPrefHeight(40);
        mainPane.setSpacing(10);

        header = new Label("");
        header.getStyleClass().add("examListHeader");
        cp = new Label("");
        cp.getStyleClass().add("examListCp");
 
        vbox = new VBox(header, cp);
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefWidth(400);
        vbox.setMaxWidth(400);
        
        vbox.getStyleClass().add("test-border-red");
        
        mainPane.getChildren().addAll(vbox);

        this.getChildren().addAll(mainPane);
        this.setPrefSize(50, 100);
        this.setMaxWidth(200);
        this.setMaxHeight(50);
        this.setPadding(new Insets(5, 0, 5, 0));

    }

    @Override
	public void updateItem(ExamModule item, boolean empty) {
		super.updateItem(item, empty);
		
		if(!empty) {
            header.setText(item.getName());
            cp.setText(Integer.toString(item.getCp()) + " CP");
            mainPane.setBackground(new Background(new BackgroundFill(item.getCategories().getColor(), new CornerRadii(5), new Insets(0))));
			this.setGraphic(mainPane);
		} else {
			this.setGraphic(null);
		}
	}
}
