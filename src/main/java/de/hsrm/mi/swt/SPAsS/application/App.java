package de.hsrm.mi.swt.SPAsS.application;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

	private String filepath;
	private FileManager fileManager;


	@Override
	public void start(Stage primaryStage) throws Exception{
		fileManager = new FileManager("");
		fileManager.test();
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void init(){

	}
	
	public void stop(){
		Platform.exit();
		System.exit(1);
	}

	public void savePlan(){

	}
	
	public void readPlan(){

	}

	public void swapView(){

	}

}
