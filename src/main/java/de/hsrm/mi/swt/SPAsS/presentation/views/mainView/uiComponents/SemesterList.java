package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.uiComponents;

import java.util.List;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import javafx.event.Event;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class SemesterList extends ListView<Module>{

	
	private List<Module> moduleList;
	
	public SemesterList (List<Module> moduleList) {
	
		this.moduleList = moduleList;
		
	}
	
	public void moduleDragDetected (Event event) {
		
		
		
	}
	
	public void moduleOnDragOver (DragEvent event) {
		
	}
	
	
	public void moduleOnDragDropped(DragEvent event) {
		
		
	}
	
	
	
	
}
