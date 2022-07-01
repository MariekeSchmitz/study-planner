package de.hsrm.mi.swt.SPAsS.presentation.views.introView;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileManager;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.FileType;
import de.hsrm.mi.swt.SPAsS.business.fileManagement.MetaEnum;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.DragDropViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.StudyView;
import de.hsrm.mi.swt.SPAsS.presentation.views.introView.uiComponents.StudyViewController;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SelectViewController extends ViewController{
    private SelectView selectView;
    private HBox curriculaBox;
    private FileManager fileManager;
    private ViewManager viewManager;
    private App app;
    private Pane dragDropPane;
    private DragDropViewController dragDropViewController;
    
    public SelectViewController(ViewManager viewmanager, App app) {
    	this.app = app;
    	this.viewManager = viewmanager;
    	this.fileManager = app.getFileManager();
        selectView = new SelectView();
        rootView = selectView;
        curriculaBox = selectView.getHbox();
        dragDropViewController = new DragDropViewController(app, FileType.CURRICULA);
        dragDropPane = dragDropViewController.getRootView();
        selectView.setDrag_drop_field(dragDropPane);
        
        initialise();
    }

    @Override
    public void initialise() {
    	
    	List<String> curriculaNames = fileManager.curriculumScan();
    	HashMap<String, String> metaData;
      
        for (String fileName:curriculaNames) {
        	
        	String name;
    		String institution;
    		String degreeProgram;
    		
    		
    		try {
				metaData = fileManager.readMeta(FileType.CURRICULA, fileName);
				name = metaData.get(MetaEnum.NAME.toString());
        		institution = metaData.get(MetaEnum.HOCHSCHULE.toString());
        		degreeProgram = metaData.get(MetaEnum.STUDIENGANG.toString());
			} catch (FileNotFoundException e1) {
				name = fileName;
        		institution = "";
        		degreeProgram = "";
			}
    		
    		System.out.println(name);

    		
        	
        	StudyView studyView = (StudyView)new StudyViewController(name, degreeProgram, institution, fileManager, app, viewManager).getRootView();
            curriculaBox.getChildren().add(studyView);
        	
        }	
        
    }
    
}
