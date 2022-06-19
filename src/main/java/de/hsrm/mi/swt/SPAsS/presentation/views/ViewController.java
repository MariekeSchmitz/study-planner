package de.hsrm.mi.swt.SPAsS.presentation.views;

import javafx.scene.layout.Pane;

public abstract class ViewController {
    protected Pane rootView;

    public ViewController(){}

    public abstract void initialise();

    public Pane getRootView(){
        return rootView;
    }
}
