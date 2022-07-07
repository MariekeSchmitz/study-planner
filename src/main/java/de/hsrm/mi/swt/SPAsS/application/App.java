package de.hsrm.mi.swt.SPAsS.application;

import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.TestClassGenerator;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFx - Application class. Contains Application initialisation, start and quit logic.
 * 
 */
public class App extends Application {

	private String filepath;
	private FileManager fileManager;

	private ViewManager viewManager;
	private Plan plan;
	private TestClassGenerator testClass;
	
	private Scene scene;
	
	private Stage primaryStage;

	

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		this.primaryStage = primaryStage;
		
		testClass = new TestClassGenerator();
//		plan = testClass.plan;

		fileManager = new FileManager("FileManagerTestFolder");
		try {
//			fileManager.test(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("you killed the parser");
		}

		try {
			scene = new Scene(new Pane(), 1440, 1024);
			viewManager = new ViewManager(this);
			scene = new Scene(viewManager.getRoot(),1440,1024);	
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void init(){

	}
	
	public void stop(){
		
		if(plan!=null)fileManager.fileSave(FileType.PLAN, plan);
		
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
	
	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public ViewManager getViewManager() {
		return viewManager;
	}

	public void setViewManager(ViewManager viewManager) {
		this.viewManager = viewManager;
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	

	
	
	

}
