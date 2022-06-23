import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
public class FolderTravelNullLines{
    static Map<File,Integer> folders; //a case is mapped to a folder
    
    public static void main(String[] args){
        File[] files = new File("D:/javaWork/Labs/2017csUTF8").listFiles();

        folders = new HashMap<File, Integer>();
        for (File file: files){
            if(file.isDirectory()){
                folders.put(file, travel(file)); //
            }
         }
         //System.out.println(folders);C:\Users\Donald\AppData\Roaming\Notepad++\plugins\config\PythonScript\scripts
         String s = null;
         for(Map.Entry<File,Integer> entry : folders.entrySet()){
             s=entry.getKey().getName();
             System.out.println(s + "," + entry.getValue());
         }
    }
   
    static int travel(File folder){
        int sum = 0;
        if (folder.isDirectory()){
            File[] files = folder.listFiles();
            for(File file : files){
                   sum = sum + travel(file);
             }
         } else{           
                 if (folder.getName().endsWith("java")){
                      sum =  countWhiteSpaces(folder);
                 }
         }
         return sum;
    }
    
    static int countWhiteSpaces(File file){
        int  N = 0;
        String line = null;
        try (Scanner reader = new Scanner(file)){
            while (reader.hasNextLine()) {
                 //if (Character.isWhitespace(ch)) { N++;}
                 ///if ((char)ch == '\n'){N = N + 1;} //one tab is equal to 4 blanks.
                 line = reader.nextLine();
                 if (line.trim().length() == 0) {//if empty line
                     N = N + 1;
                 }
            }
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
        return N;
    }
}