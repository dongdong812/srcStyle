import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
public class FolderTravelWhiteSpace{
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
         String s = null;
         for(Map.Entry<File,Integer> entry : folders.entrySet()){
             s=entry.getKey().getName();
             System.out.println(s + "," + entry.getValue());
         }
    }
   
    static int travel(File folder){
        int sum = 0;
        if (folder.isDirectory()){//累加文件夹中的空白字符数
            File[] files = folder.listFiles();
            for(File file : files){
                   sum = sum + travel(file);
             }
         } else{  //单个文件的空白字符数             
                 if (folder.getName().endsWith("java")){
                      sum =  countWhiteSpaces(folder);
                 }
         }
         return sum;
    }
    
    static int countWhiteSpaces(File file){
        int  N = 0;
        int ch = 0;
        try (FileReader reader = new FileReader(file)){
            ch = reader.read();
            while (ch != -1) {
                 //if (Character.isWhitespace(ch)) { N++;}
                 if ((char)ch == ' '){N = N + 1;} //one tab is equal to 4 blanks.
                 ch = reader.read();
            }
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
        return N;
    }
}