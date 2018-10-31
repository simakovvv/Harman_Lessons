package Lesson3.Task6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesOperator {
    public void addTextToFile(String pathDep, String pathDest, String text, String indentString) {
        try (FileInputStream fstream = new FileInputStream(new File(pathDep));
             BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
             FileOutputStream ostream = new FileOutputStream(new File(pathDest));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(ostream))) {
            String strLine;
            int indent = Integer.valueOf(indentString);
            int indentCount = 0;
            boolean firstEntry = false;
            while ((strLine = br.readLine()) != null) {
                indentCount += strLine.length();
                if (indentCount >= indent  && firstEntry == false) {
                    StringBuffer subStrLine = new StringBuffer(strLine);
                    subStrLine.insert((strLine.length() - (indentCount - indent)), text);
                    strLine = subStrLine.toString();
                    firstEntry = true;
                }
                bw.write(strLine + "\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printTextFile(String path) {
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( );
    }
}
