package Lesson1.Exercise4_Files;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import static com.sun.org.apache.xerces.internal.utils.SecuritySupport.getResourceAsStream;

public class Files {
    private String folder;
    public List<String> getListWithText() throws IOException {
        List<String> list = new LinkedList<>();
        try{
            FileInputStream fstream = new FileInputStream("resources/temp.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                list.add(strLine);
            }

            br.close();
            fstream.close();
        }catch (IOException e){
            System.out.println("Ошибка");
        }
        return list;
    }
    public void reversePrintList(List<String> list){

        Collections.reverse(list);
        System.out.println("List sorted in ReverseOrder: ");
        for (String s: list) {
            System.out.println(s);
        }
    }
    public void printList(List<String> list){
        System.out.println("List sorted in Order: ");
        for (String s: list) {
            System.out.println(s);
        }
    }
    public void printFileList(List<File> list){
        System.out.println("List sorted in Order: ");
        for (File s: list) {
            System.out.println(s);
        }
    }

    // list of files with txt extension in a specified folder
    public List<File> getResourceFiles(String path) throws IOException {
        File dir = new File(path); //path указывает на директорию
        File[] arrFiles = dir.listFiles(new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".txt");
            }
        });
        List<File> list = Arrays.asList(arrFiles);
        return list;
    }

    public void copyFile(String source, String dest) throws IOException {

        try{
            FileInputStream fstream = new FileInputStream(source);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            FileOutputStream ostream = new FileOutputStream(dest);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ostream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                bw.write(strLine+"\n");
                bw.flush();
            }

        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }
}
