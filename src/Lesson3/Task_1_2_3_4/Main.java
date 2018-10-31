package Lesson3.Task_1_2_3_4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Task1 write an example counts the number of times particular character,
        // such as e, appears in a file.
        FilesOperator file = new FilesOperator();
        try {
            System.out.println("This letter occurs: " + file.copyFileWithChanges("resources/temp.txt", file.keyboardInput()) + " times");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------------------");

        //Task2 A file begins with a single long that tells you the offset of a
        // single int piece of data within the same file.
        FilesOperator file1 = new FilesOperator();
        System.out.println("indent from the beginning of the text:" + file1.offsetRead("resources/tempL3T2.txt"));
        System.out.println("---------------------------------------------------------");

        //Task3 Read a text file and make an alphabetical list of all the words in that file
        FilesOperator file3 = new FilesOperator();
        file3.alphabeticRead("resources/temp.txt");
        System.out.println("---------------------------------------------------------");

        // Task4 write a program that will count the number of lines in each file that is specified on the command line.
        FilesOperator file4 = new FilesOperator();
        file4.fileLinesCounter(args);
        System.out.println("---------------------------------------------------------");




    }
}
