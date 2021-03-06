package Lesson1.Exercise4_Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {

        //Task1 Open a file so that the file one line at a time. Read each line as a String
        // and place that String object into a linkedlist. Print all of the lines in the LinkedList in reverse order
        System.out.println("Task1 Open a file so that the file one line at a time");
        Files file = new Files();
        try {
            file.printList(file.getListWithText());
            System.out.println();
            file.reversePrintList(file.getListWithText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------");


        System.out.println("Task2 Print a list of files with txt extension in a specified folder");
        Files file1 = new Files();
        try {
            file1.printFileList(file1.getResourceFiles("resources"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------");

        System.out.println("Task3 Copy file1.txt to file2.txt");
        Files file2 = new Files();
        try {
            file2.copyFile("resources/temp.txt", "resources/tempForTask3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("... file copied to resources path");
        System.out.println("---------------------------------------------");

        System.out.println("Task4 Split single text file to two different files having 30% and 70% information");
        Files file3 = new Files();
        try {
            file3.splitFile(new File("resources/temp.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("... file splitted");
        System.out.println("---------------------------------------------");

        System.out.println("Task5 Read a text file and write it to a target text file," +
                " changing all lowercase to uppercase and double spacing output text");
        Files file4 = new Files();
        try {
            file4.copyFileWithChanges("resources/temp.txt", "resources/tempForTask5.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("... file copied to resources path");
        System.out.println("---------------------------------------------");


    }
}
