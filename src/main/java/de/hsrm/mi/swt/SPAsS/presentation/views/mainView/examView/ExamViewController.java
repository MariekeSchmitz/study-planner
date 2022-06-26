package de.hsrm.mi.swt.SPAsS.presentation.views.mainView.examView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Module;
import de.hsrm.mi.swt.SPAsS.application.App;
import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewController;
import de.hsrm.mi.swt.SPAsS.presentation.views.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ExamViewController extends ViewController{


    private ViewManager viewManager;
    private App app;
    private ExamView aev;
    
    private int numSemester;
    private Plan plan;
    private ListView<Module> listView;
    private Map<Integer, List<Module>> moduleMap;
    private List<Module> allModuleList;
    private ObservableList<Module> list;

    public ExamViewController(ViewManager viewManager, App app) {
        
        aev = new ExamView();
        rootView = aev;

        this.viewManager = viewManager;
        this.app = app;
        this.plan = app.getPlan();
        this.moduleMap = plan.getModuleMap();
        this.numSemester = plan.getNumberSemester();
        this.listView = aev.getListView();

        allModuleList = new ArrayList<Module>();

        generateListView();
        initialise();

        list = FXCollections.observableList(allModuleList);
        listView.setItems(list);

    }

    @Override
    public void initialise() {
        listView.setCellFactory(new Callback<ListView<Module>, ListCell<Module>>() {

            @Override
            public ListCell<Module> call(ListView<Module> param) {
                return new ExamListCell();
            }
                
        });
        
    }
    private void generateListView(){

        for (int i = numSemester; i > 0; i--) {
            allModuleList.addAll(moduleMap.get(i));
    	};
        
    }
}
