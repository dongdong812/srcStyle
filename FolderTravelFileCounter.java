import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
public class FolderTravelFileCounter{
    static Map<File,Integer> folders; //a student is mapped to a folder
    
    public static void main(String[] args){
        //initialize all folders
        
        File[] files = new File("D:/javaWork/Labs/2017csUTF8").listFiles();
        folders = new HashMap<File, Integer>();
        for (File file: files){
            if(file.isDirectory()){
                folders.put(file, travel(file)); //
            }
         }
         //System.out.println(folders);
         for(Map.Entry<File,Integer> entry : folders.entrySet()){
             System.out.println(entry.getKey().getName() + "," + entry.getValue());
         }
    }
   
    static int travel(File folder){
        int sum = 0;
        if (folder.isDirectory()){//累加文件夹中的文件数
            File[] files = folder.listFiles();
            for(File file : files){
                   sum = sum + travel(file);
             }
         } else{  //单个文件             
                 if (folder.getName().endsWith("java")){
                      sum =  1;
                 }
         }
         return sum;
    }
} 