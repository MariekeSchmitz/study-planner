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

/**
 * Reacts to User Input on left side of the PlanView. 
 * Contains Listeners to undo,redo,save,reference and settings-Buttons.
 */
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
         settingsButton.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("Settings Button Pressed"); 
            if(!Scenes.SETTINGS_VIEW.isIn()){
                viewManager.getMainViewController().putSettingsViewOnStack();
                settingsButton.setId("settingsButtonIN");
            } else {
                viewManager.getMainViewController().transitionOut(Scenes.SETTINGS_VIEW);
                Scenes.SETTINGS_VIEW.setIn(false);
                settingsButton.setId("settingsButtonOut");

            }
         });
    }

    
}
