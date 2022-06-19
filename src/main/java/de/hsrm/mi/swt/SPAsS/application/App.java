package de.hsrm.mi.swt.SPAsS.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception{
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
