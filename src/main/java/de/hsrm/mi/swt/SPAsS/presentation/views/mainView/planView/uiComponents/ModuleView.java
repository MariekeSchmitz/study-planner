package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Course;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Exam;
import de.hsrm.mi.swt.SPAsS.business.planManagement.ExamModule;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
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
        moduleLabel.getStyleClass().add("module");
        moduleLabel.setStyle("-fx-font-weight: bold;");

        cpLabel = new Label("");
        cpLabel.getStyleClass().add("module");
        
        labels = new VBox(10);
        labels.getChildren().addAll(moduleLabel,cpLabel);
		labels.setPadding(new Insets(15, 15, 15,15));
		labels.setAlignment(Pos.TOP_LEFT);
        
        this.setGraphic(labels);
        this.setMaxHeight(50);
        this.setMaxWidth(150);
		this.setStyle("-fx-background-color: transparent;");
		
		
    }
    
    
    @Override
    protected void updateItem(Module item, boolean empty) {
    	super.updateItem(item, empty);
    	
    	if (!empty) {
    		
    		if (this.getItem().isValid()) {
    			this.setId("valid");
    		} else {
    			this.setId("invalid");
    		}
    		
    		moduleLabel.setText(item.getName());
    		cpLabel.setText(Integer.toString(item.getCp()));
    		
    		Color color = item.getCategories().getColor();
    		double red = color.getRed();
    		double blue = color.getBlue();
    		double green = color.getGreen();
    		
    		
    		// TO DO 
    		String colorPassed = "-fx-background-color:rgba("+red+","+blue+","+green+", 0.5);";
    		String onlyExam = "-fx-background-color:rgb(200,0,200)";
    		
    		System.out.println(item.getName() + " valid: "+ (item.isValid()));
    		
    		if (item.isPassed()) {
    			labels.setStyle(colorPassed);
    		} else if (item instanceof ExamModule) {
    			labels.setStyle(onlyExam);
    		} else {
        		labels.setBackground(new Background(new BackgroundFill(item.getCategories().getColor(),new CornerRadii(0),new Insets(0))));
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
