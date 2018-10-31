package Lesson3.Task5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 5 Write an example that prints in reverse alphabetical order");
        FilesOperator file = new FilesOperator();
        System.out.println("alphabetical printing: ");
        Arrays.stream(file.printFoldersMember(args[0])).forEach(p -> System.out.println(p));
        System.out.println("reverse alphabetical printing: ");
        Arrays.stream(file.reverse(file.printFoldersMember(args[0]))).forEach(p -> System.out.println(p));
    }
}
