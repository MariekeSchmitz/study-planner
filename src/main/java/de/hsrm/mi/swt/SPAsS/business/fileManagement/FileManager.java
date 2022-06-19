package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

public class FileManager {
    private String path;
    public String jsonTestString;

    public FileManager(String path){
        this.path = path;
        
    }

    public void curriculumScan(){

    }
    public void planScan(){

    }
    public Plan fileRead(){
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(Validator.class, new InterfaceDeserializer<>())
            .create();
        return gson.fromJson(jsonTestString, Plan.class);
    }
    public void fileSave(){
        this.jsonTestString = new Gson().toJson(new TestClassGenerator().plan);
    }
}
