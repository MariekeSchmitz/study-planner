package de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

public class DragDropViewController extends ViewController {

	private Button fileOpenButton;
	private DragDropView dragDropView;
	private App app;
	private Pane dragDropPane;
	
	
    public DragDropViewController(App app) {
        
    	this.app = app;
    	dragDropView = new DragDropView();
    	rootView = dragDropView;
    	
    	fileOpenButton = dragDropView.getFileOpen();
   
    	initialise();
        
    }

    @Override
    public void initialise() {
        
    	
    	fileOpenButton.addEventHandler(ActionEvent.ACTION, e -> {

        	FileChooser.ExtensionFilter fileFilter = new FileChooser.ExtensionFilter("JSON-Dateien", "*json");
        	FileChooser fileChooser = new FileChooser();
        	fileChooser.setTitle("Datei hochladen");
        	fileChooser.showOpenDialog(app.getPrimaryStage());
        	
        	
        	
        	
		});
        
    }
    
}
