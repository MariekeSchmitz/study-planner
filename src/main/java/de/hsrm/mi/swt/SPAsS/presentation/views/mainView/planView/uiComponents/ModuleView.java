package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;

public class ModuleView extends ListCell<Module>{

    private Label moduleLabel;
	private Label cpLabel;
	private VBox labels;
	private Color color;

    private double startX;
    private double startY;

    public ModuleView() {

        moduleLabel = new Label("");
        moduleLabel.getStyleClass().add("module");

        cpLabel = new Label("");
        cpLabel.getStyleClass().add("module");
        
        labels = new VBox();
        labels.getChildren().addAll(moduleLabel,cpLabel);
        
        this.setGraphic(labels);

        this.setMaxHeight(50);
        this.setMaxWidth(150);
   
    }
    
    
    @Override
    protected void updateItem(Module item, boolean empty) {
    	super.updateItem(item, empty);
    	
    	if (!empty) {
    		
    		moduleLabel.setText(item.getName());
    		cpLabel.setText(Integer.toString(item.getCp()));
    		
    		Color color = item.getCategories().getColor();
    		double red = color.getRed();
    		double blue = color.getBlue();
    		double green = color.getGreen();
    		
    		
    		// TO DO 
    		String s = "-fx-background-color:rgba("+red+","+blue+","+green+", 0.5)";
    		
    		
    		if (item.isPassed()) {
    			this.setStyle(s);
        		
    		} else {
        		this.setBackground(new Background(new BackgroundFill(item.getCategories().getColor(),new CornerRadii(0),new Insets(0))));
    		}
    		
    		
    		this.setGraphic(labels);
    		
    	} else{
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
