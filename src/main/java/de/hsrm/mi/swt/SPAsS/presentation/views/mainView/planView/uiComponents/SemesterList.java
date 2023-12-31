package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import java.util.List;
import java.util.Set;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

/**
 * Contains drop-logic for ListViews representing a semester
 */
public class SemesterList extends ListView<Module>{

	private Plan plan;
	private List<Module> moduleList;
	private int semester;
	
	public SemesterList (List<Module> moduleList, int semester, Plan plan) {
	
		this.moduleList = moduleList;
		this.semester = semester;
		this.plan = plan;
		
		initialize();
	
		
	}
	
	private void initialize () {
		
		
		this.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				boolean moveSupported = true; 
				
				Dragboard dragboard;
				Set<TransferMode> modes;
				
				dragboard = event.getDragboard();

				
				modes = dragboard.getTransferModes();
				for (TransferMode mode : modes) {
					moveSupported = (moveSupported || TransferMode.MOVE == mode);
				}
				
				if (moveSupported) {
					event.acceptTransferModes(TransferMode.MOVE);
				}
				event.consume();
			}
			
		});
		
		
		this.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				

				Dragboard dragboard = event.getDragboard();
					
				
				String moduleName = dragboard.getString();
				Module module = plan.getModuleByName(moduleName);
				module.move(semester);
			
				
				event.setDropCompleted(true);
				event.consume();	
				
			}

			
		});
	}
	
		
}
