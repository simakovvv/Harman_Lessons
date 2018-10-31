package Lesson3.Task_1_2_3_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class FilesOperator {
    // keyboard input for task1
    public char keyboardInput() {
        char achar;
        System.out.println("Enter character to search ");
        try (Scanner scanner = new Scanner(System.in)) {
            achar = scanner.nextLine().charAt(0);
        }
        return achar;
    }

    // finding the number of occurrences
    public int copyFileWithChanges(String source, char aChar) throws IOException {
        int count = 0;
        try (FileInputStream fstream = new FileInputStream(source);
             BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
                count += strLine.length() - strLine.replace(String.valueOf(aChar), "").length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void printCharArr(char[] mass) {
        for (char c : mass) {
            System.out.print(c);
        }
        System.out.println();
        System.out.println();
    }

    //indented reading for task2
    public int offsetRead(String source) {
        File file = new File(source);
        long indent = 0;
        try (FileInputStream fstream = new FileInputStream(file);
             BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
            indent = Long.valueOf(br.readLine());
            char[] mass = new char[(int) file.length()];
            char[] massIndent = new char[(int) indent];//in this array, read the characters that you want to skip
            br.read(massIndent);
            br.read(mass);
            printCharArr(mass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (int) indent;
    }

    // Alphabetic reader for task3
    public void alphabeticRead(String source) {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner file = new Scanner(new File(source))) {
            while (file.hasNext()) {
                list.add(file.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        printList(list);
    }

    public void printList(ArrayList arrayList) {
        arrayList.stream().forEach((p) ->
                System.out.println(p));
        System.out.println();
    }

    //Task4 program that will count the number of lines in each file
    public void fileLinesCounter(String... source) {

        for (int i = 0; i < source.length; i++) {
            int count = 0;
            try (Scanner file = new Scanner(new File(source[i]))) {
                while (file.hasNext()) {
                    file.nextLine();
                    count++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            printFileLines(name(source[i]), count);
        }
    }

    public String name(String fileName) {
        int pos = fileName.lastIndexOf(".");
        int pathPos = fileName.lastIndexOf("/");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }
        if (pathPos > 0) {
            fileName = fileName.substring(pathPos + 1, pos);
        }
        return fileName;
    }

    public void printFileLines(String name, int lines) {
        System.out.format("File \"%s\" contains: %d lines ", name, lines);
        System.out.println();
    }

}
