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

    //Task3 Copy file1.txt to file2.txt
    public void copyFile(String source, String dest) throws IOException {

        try(FileInputStream fstream = new FileInputStream(source);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream))){

            try(FileOutputStream ostream = new FileOutputStream(dest);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ostream))) {

                String strLine;
                while ((strLine = br.readLine()) != null) {
                    bw.write(strLine + "\n");
                    bw.flush();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private int getScorePercent(long total, int percent){
        System.out.println(total+" " +((total * percent) / 100));
        return (int) ((total * percent) / 100);
    }

    // Task4 Split single text file to two different files having 30% and 70% information
    public void splitFile(File f) throws IOException {
        int partCounter = 1;//fotmat of name parts from 001, 002, 003, ...
        int sizeOfFile1 = getScorePercent(f.length(),30);// get file size
        int sizeOfFile2 = getScorePercent(f.length(),70);// get file size
        byte[] buffer = new byte[(int) f.length()];
        String fileName = f.getName();
        //try-with-resources to ensure closing stream
        try (FileInputStream fis = new FileInputStream(f);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int bytesAmount = bis.read(buffer);
            //write each chunk of data into separate file with different number in name
            String filePartName = String.format("%s.%03d", fileName, partCounter++);
            File newFile = new File(f.getParent(), filePartName);

            String filePartName1 = String.format("%s.%03d", fileName, partCounter++);
            File newFile1 = new File(f.getParent(), filePartName1);

            try (FileOutputStream out = new FileOutputStream(newFile)) {
                out.write(buffer, 0, sizeOfFile1);
            }
            try (FileOutputStream out = new FileOutputStream(newFile1)) {
                out.write(buffer, sizeOfFile1, sizeOfFile2);
            }
        }
    }

}
