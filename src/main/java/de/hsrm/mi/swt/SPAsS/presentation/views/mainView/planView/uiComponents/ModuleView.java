package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 * Visual Component - visualizes single Module
 */
public class ModuleView extends ListCell<Module>{

    private Label moduleLabel;
	private Label cpLabel;
	private VBox labels;

    private double startX;
    private double startY;

    public ModuleView() {

        moduleLabel = new Label("");
        moduleLabel.setStyle("-fx-font-family: 'Open Sans SemiBold', sans-serif;"
        		+ "-fx-font-size:12px;");

        cpLabel = new Label("");
        cpLabel.setStyle("-fx-font-family: 'Open Sans Light', sans-serif;"
        		+ "-fx-font-size: 12px;");
        
        labels = new VBox(5);
        labels.getChildren().addAll(moduleLabel,cpLabel);
		labels.setPadding(new Insets(0, 15, 0,15));
		labels.setAlignment(Pos.CENTER_LEFT);
		labels.getStyleClass().add("moduleView");
		labels.setEffect(new DropShadow(3, 0, 2, Color.rgb(211, 211, 211, 0.5)));
		labels.setClip(null);
        
        this.setGraphic(labels);
        this.setMaxHeight(40);
        this.setMaxWidth(150);
		this.setStyle("-fx-background-color: transparent;");
		
		
    }
    
    
    @Override
    protected void updateItem(Module item, boolean empty) {
    	super.updateItem(item, empty);
    	
    	if (!empty) {
    		
    		this.setId("valid");
    		moduleLabel.setText(item.getName());
    		cpLabel.setText(Integer.toString(item.getCp()) + " CP");
    		
    		Color color = item.getCategories().getColor();
    		
    		
    		if (item.isPassed()) {
    			labels.setId("passed");
    		} else if (item instanceof ExamModule) {
    			labels.setId("exam");
    		} else if (!this.getItem().isValid()) {
    			labels.setId("invalid");
    		} else {
    			labels.setId("moduleView");
    		}
    			
    		this.setGraphic(labels);
    		
    	} else{
    		
    		this.setId("valid");
    		this.setGraphic(null);
    	}
    }
    
    
    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }
    
    public Label getModuleLabel() {
		return moduleLabel;
	}
    
	public void setModuleLabel(Label moduleLabel) {
		this.moduleLabel = moduleLabel;
	}
	
	public Label getCpLabel() {
		return cpLabel;
	}
	
	public void setCpLabel(Label cpLabel) {
		this.cpLabel = cpLabel;
	}

    
}
