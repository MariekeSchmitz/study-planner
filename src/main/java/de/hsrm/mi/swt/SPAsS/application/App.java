package de.hsrm.mi.swt.SPAsS.application;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private String filepath;
	private FileManager fileManager;

	private ViewManager viewManager;
	

	@Override
	public void start(Stage primaryStage) throws Exception{
		fileManager = new FileManager("");
		try {
			fileManager.test();
		} catch (Exception e) {
			System.out.println("you killed the parser");
		}

		try {
			viewManager = new ViewManager();
			Scene scene = new Scene(viewManager.getRootView(),1440,1024);			
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
