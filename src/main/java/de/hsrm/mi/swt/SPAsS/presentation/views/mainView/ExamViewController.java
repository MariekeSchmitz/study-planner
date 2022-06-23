package de.hsrm.mi.swt.SPAsS.presentation.views.mainView;

import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class ExamViewController extends ViewController{

    private ExamView aev;
    private ListView<String> listView;

    public ExamViewController() {

        aev = new ExamView();
        rootView = aev;
        
        listView = aev.getListView();

        ObservableList<String> list = FXCollections.observableArrayList (
            "Klausur 1",
            "Klausur 2",
            "Klausur 3",
            "Klausur 4",
            "Klausur 5",
            "Klausur 6",
            "Klausur 7");

        listView.setItems(list);
    }

    @Override
    public void initialise() {
        // TODO Auto-generated method stub
        
    }
    
}
