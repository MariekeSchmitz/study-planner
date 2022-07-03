package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.planView.uiComponents;

import de.hsrm.mi.swt.SPAsS.business.commands.CommandManager;
import de.hsrm.mi.swt.SPAsS.business.commands.UndoRedoException;
import de.hsrm.mi.swt.SPAsS.presentation.views.Scenes;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class LeftSideViewController extends ViewController {

    private ViewManager viewManager;

    private Button redoButton;
    private Button undoButton;
    private Button saveButton;
    private Button referenceButton;
    private Button settingsButton;
    LeftSideView leftSideView;

    public LeftSideViewController(ViewManager viewManager) {
        this.viewManager = viewManager;

        leftSideView = new LeftSideView();
        rootView = leftSideView;

        redoButton = leftSideView.getRedoButton();
        undoButton = leftSideView.getUndoButton();
        saveButton = leftSideView.getSaveButton();
        referenceButton = leftSideView.getReferenceButton();
        settingsButton = leftSideView.getSettingsButton();

        initialise();
    }

    @Override
    public void initialise() {
        redoButton.addEventHandler(ActionEvent.ACTION, e -> {
            try {
                CommandManager.getInstance().redo();
            } catch (UndoRedoException ure) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("UndoRedoError");
                alert.setContentText(ure.getMessage());
                
                alert.showAndWait();
            }
    	});
        undoButton.addEventHandler(ActionEvent.ACTION, e -> {
            try {
                CommandManager.getInstance().undo(); 
            } catch (UndoRedoException ure) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("UndoRedoError");
                alert.setContentText(ure.getMessage());
                
                alert.showAndWait();
            }
         });
         saveButton.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("Save Button Pressed"); 
         });
         referenceButton.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("Reference Button Pressed"); 
         });
         settingsButton.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("Settings Button Pressed"); 
            if(!Scenes.SETTINGS_VIEW.isIn()){
                viewManager.getMainViewController().putSettingsViewOnStack();
            } else {
                viewManager.getMainViewController().transitionOut(Scenes.SETTINGS_VIEW);
                Scenes.SETTINGS_VIEW.setIn(false);
            }
         });
    }

    
}
