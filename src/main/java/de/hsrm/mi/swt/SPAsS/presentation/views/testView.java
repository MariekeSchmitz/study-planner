package de.hsrm.mi.swt.SPAsS.presentation.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class testView extends VBox{

	public testView() {
		
		ListView<String> listView = new ListView<>();
		  ObservableList<String> list =FXCollections.observableArrayList (
		          "Sunday",
		          "Monday",
		          "Tuesday",
		          "Wednesday",
		          "Thursday",
		          "Friday",
		          "Saturday");
		  listView.setItems(list);
		  listView.setOrientation(Orientation.HORIZONTAL);
		  
		  

			ListView<String> listView2 = new ListView<>();
			  ObservableList<String> list2 =FXCollections.observableArrayList (
			          "Sunday",
			          "Monday",
			          "Tuesday",
			          "Wednesday",
			          "Thursday",
			          "Friday",
			          "Saturday");
			  listView2.setItems(list2);
			  listView2.setOrientation(Orientation.HORIZONTAL);
		
			  
		  this.getChildren().addAll(listView, listView2);
	}
	
	
	
}


