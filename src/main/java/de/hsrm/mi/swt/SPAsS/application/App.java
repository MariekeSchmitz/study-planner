package de.hsrm.mi.swt.SPAsS.application;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.TestClassGenerator;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private String filepath;
	private FileManager fileManager;

	private ViewManager viewManager;
	private Plan plan;
	private TestClassGenerator testClass = new TestClassGenerator();

	

	@Override
	public void start(Stage primaryStage) throws Exception{
		plan = testClass.plan;

		fileManager = new FileManager("FileManagerTestFolder");
		try {
			fileManager.test(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("you killed the parser");
		}

		try {
			viewManager = new ViewManager(this);
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

	public Plan getPlan() {
		return plan;
	}

	
	

}
