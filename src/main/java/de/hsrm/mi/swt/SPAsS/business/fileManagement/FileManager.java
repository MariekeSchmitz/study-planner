package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public FileManager(String path) {
        this.path = path;
        testPlan = new TestClassGenerator().plan;
    }

    public List<String> curriculumScan() {
        return readFolderContent(FileType.CURRICULA);
    }

    public List<String> planScan() {
        return readFolderContent(FileType.PLAN);
    }

    private List<String> readFolderContent(FileType type) {
        List<String> fileNames = new ArrayList<>();
        String typePath = type == FileType.PLAN ? "plans" : "curricula";
        File folder = new File(path + File.separator + typePath);
        folder = new File(folder.getAbsolutePath());
        if (!folder.exists())
            return fileNames;
        for (File file : folder.listFiles()) {
            if (file.isDirectory())
                ;
            else {
                String name = file.getName();
                if (name.contains(".json")) {
                    fileNames.add(name.replace(".json", ""));
                }
            }
        }
        return fileNames;
    }

    public Plan fileRead(FileType type, String name) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Validator.class, new InterfaceDeserializer<>())
                .create();
        String typePath = type == FileType.PLAN ? "plans" : "curricula";
        try {
            return gson.fromJson(new FileReader(path + File.separator + typePath + File.separator + name + ".json"),
                    Plan.class);
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void fileSave(Plan p) {
        this.jsonTestString = new Gson().toJson(p);
        try {
            FileWriter out = new FileWriter(path + File.separator + "plans" + File.separator + p.getName() + ".json");
            out.write(jsonTestString);
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void test(boolean syso) {
        this.fileSave(testPlan);
        String s = jsonTestString;
        Plan p = this.fileRead(FileType.PLAN, testPlan.getName());
        fileSave(p);
        if (syso) {
            System.out.println("Plans:");
            for (String st : this.planScan())
                System.out.println(st);
            System.out.println();
            System.out.println("Curricula:");
            for (String st : this.curriculumScan())
                System.out.println(st);
            System.out.println();
            if (s.equals(jsonTestString))
                System.out.println("Parser still workinng");
            else
                System.out.println("you killed the parser");
        } 
        
    }
}
