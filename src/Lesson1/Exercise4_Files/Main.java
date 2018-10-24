package Lesson1.Exercise4_Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {

        //Task1 Open a file so that the file one line at a time. Read each line as a String
        // and place that String object into a linkedlist. Print all of the lines in the LinkedList in reverse order
       /* System.out.println("Task1 Open a file so that the file one line at a time");
        Files file = new Files();
        try {
            file.printList(file.getListWithText());
            System.out.println();
            file.reversePrintList(file.getListWithText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------");*/


        /*System.out.println("Task2 Print a list of files with txt extension in a specified folder");
        Files file1 = new Files();
        try {
            file1.printFileList(file1.getResourceFiles("resources"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------");*/

        System.out.println("Task3 Copy file1.txt to file2.txt");
        Files file2 = new Files();
        try {
            file2.copyFile("resources/temp.txt", "resources/temp1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------");


    }
}
