package de.hsrm.mi.swt.SPAsS.business.fileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import de.hsrm.mi.swt.SPAsS.business.planManagement.Plan;
import de.hsrm.mi.swt.SPAsS.business.restrictionManagement.Validator;

/**
 * Class that we use to read file and create Java Objects out of file and vice-versa.
 */
public class FileManager {
    private String path;
    public String jsonTestString;
    private Plan testPlan;

    public FileManager(String path) {
        this.path = path;
//      testPlan = new TestClassGenerator().plan;
    }

    
    /** 
     * @return List<String>
     */
    public List<String> curriculumScan() {
        return readFolderContent(FileType.CURRICULA);
    }

    
    /** 
     * @return List<String>
     */
    public List<String> planScan() {
        return readFolderContent(FileType.PLAN);
    }

    
    /** 
     * searches all json files in either curricula or plan-folder
     * @param type curriculum or plan
     * @return List<String> all found files as list of Strings
     * 
     */
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

    
    /** 
     * creates Plan out of file
     * @param type
     * @param name
     * @return Plan
     
     */
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
    
    
    /** 
     * creates Plan out of directory
     * @param dir
     * @return Plan
     */
    public Plan fileReadFromDirectory(String dir) {
    	
    	Gson gson = new GsonBuilder()
                .registerTypeAdapter(Validator.class, new InterfaceDeserializer<>())
                .create();
    	try {
            return gson.fromJson(new FileReader(dir),
                    Plan.class);
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    
    /** 
     * saves Plan into json file
     * @param type curriclum or Plan
     * @param p plan
     */
    public void fileSave(FileType type, Plan p) {
        this.jsonTestString = new Gson().toJson(p);
        String typePath = type == FileType.PLAN ? "plans" : "curricula";
    	String fileName = type == FileType.PLAN ? p.getName().replace(" ", "-") : p.getStudiengang().replace(" ", "-");

        try {
            FileWriter out = new FileWriter(path + File.separator + typePath + File.separator + fileName + ".json");
            out.write(jsonTestString);
            out.flush();
            out.close();
            createMetaFile(type, p);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
//    public void duplicateFile(FileType type, File file, String fileName) throws IOException {
//
//        String typePath = type == FileType.PLAN ? "plans" : "curricula";
//        String outPath = path + File.separator + typePath + File.separator + fileName + ".json";
//    	 
//        Path in = Paths.get(file.getAbsolutePath());
//        Path out= Paths.get(outPath);
//       
//        Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING);
//
//    }
    
    /** 
     * creates Meta File out of plan (Metafile contains name, Studiengang and Hochschule of Plan/Curriculum)
     * @param type
     * @param p plan

     * @throws IOException
     */
    public void createMetaFile(FileType type, Plan p) throws IOException{
        String typePath = type == FileType.PLAN ? "plans" : "curricula";
    	String fileName = type == FileType.PLAN ? p.getName().replace(" ", "-") : p.getStudiengang().replace(" ", "-");
        FileWriter out = new FileWriter(path + File.separator + typePath + File.separator + fileName + ".meta");
        StringBuilder s = new StringBuilder();
        s.append(MetaEnum.NAME.toString()+":"+p.getName()+"\n");
        s.append(MetaEnum.STUDIENGANG.toString()+":"+p.getStudiengang()+"\n");
        s.append(MetaEnum.HOCHSCHULE.toString()+":"+p.getHochschule()+"\n");
        out.write(s.toString());
        out.flush();
        out.close();
    }

    
    /** 
     * Parses Metafile into usable Object
     * @param type
     * @param name
     * @return HashMap<String, String>
     * @throws FileNotFoundException
     */
    public HashMap<String, String> readMeta(FileType type, String name) throws FileNotFoundException{
        HashMap<String,String> map = new HashMap<>();
        String typePath = type == FileType.PLAN ? "plans" : "curricula";
        Scanner sc = new Scanner(new File(path + File.separator + typePath + File.separator + name + ".meta"));
        while(sc.hasNext()){
            String line = sc.nextLine();
            String [] splitLine = line.split(":");
            if(splitLine.length>1) map.put(splitLine[0], splitLine[1]); 
            else map.put(splitLine[0], ""); 
        }
        return map;
    }

    
    /** 
     * Tests the class
     * @param syso
     */
    public void test(boolean syso) {
        this.fileSave(FileType.PLAN, testPlan);
        String s = jsonTestString;
        Plan p = this.fileRead(FileType.PLAN, testPlan.getName());
        fileSave(FileType.PLAN, p);
        try{
        System.out.println(this.readMeta(FileType.PLAN, testPlan.getName()).get(MetaEnum.NAME.toString()));
        System.out.println(this.readMeta(FileType.PLAN, testPlan.getName()).get(MetaEnum.HOCHSCHULE.toString()));
        System.out.println(this.readMeta(FileType.PLAN, testPlan.getName()).get(MetaEnum.STUDIENGANG.toString()));
        }catch (Exception e) {
            //TODO: handle exception
        }

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
