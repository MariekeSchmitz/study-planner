package de.hsrm.mi.swt.SPAsS.presentation.views.introView;


import java.util.List;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.DragDropViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
/**
 * Reacts to user Plan-Upload
 */
public class UploadViewController extends ViewController {

	private App app; 
	private ViewManager viewManager;
	private DragDropViewController dragDropViewController;
	private UploadView uploadView;
	
	private Button backButton;
	
    public UploadViewController(ViewManager viewManager,App app, FileType fileType)  {
        
    	this.app = app;
    	this.viewManager = viewManager;
    	UploadView uploadView = new UploadView();
    	dragDropViewController = new DragDropViewController(app, fileType);
    	uploadView.setDrag_drop_field(dragDropViewController.getRootView());
    	backButton = uploadView.getBackButton();
    	rootView = uploadView;
    	initialise();
    }

    @Override
    public void initialise() {
    	backButton.addEventHandler(ActionEvent.ACTION, e -> {

    		viewManager.switchScene(Scenes.START_VIEW);

			
		});
    	
        
    }

}
