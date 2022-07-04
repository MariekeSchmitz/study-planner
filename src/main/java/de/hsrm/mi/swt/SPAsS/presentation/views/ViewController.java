package de.hsrm.mi.swt.SPAsS.presentation.views;

import javafx.scene.layout.Pane;

/**
 * abstract class for all Controllers
 */
public abstract class ViewController {
    
	protected Pane rootView;

    public ViewController(){}

    /**
 * Initialises Controller by adding Event Handling
 */
    public abstract void initialise();

    public Pane getRootView(){
        return rootView;
    }
}
