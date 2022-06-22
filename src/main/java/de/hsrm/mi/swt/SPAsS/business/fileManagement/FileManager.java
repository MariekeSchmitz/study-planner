package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

public class FileManager {
    private String path;
    public String jsonTestString;
    Plan testPlan;

    public FileManager(String path){
        this.path = path;   
        testPlan = new TestClassGenerator().plan;
    }

    public void curriculumScan(){

    }
    public void planScan(){

    }
    public Plan fileRead(String name){
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(Validator.class, new InterfaceDeserializer<>())
            .create();
        try {
            return gson.fromJson(new FileReader(name+".json"), Plan.class);
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    public void fileSave(Plan p){
        this.jsonTestString = new Gson().toJson(p);
        try {
            FileWriter out = new FileWriter(p.getName()+".json");
            out.write(jsonTestString);
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void test(){
		this.fileSave(testPlan);
		System.out.println(this.jsonTestString);
        String s = jsonTestString;
		Plan p = this.fileRead(testPlan.getName());
        fileSave(p);
        if(s.equals(jsonTestString)) System.out.println("Parser still workinng");
        else System.out.println("you killed the parser");
    }
}
