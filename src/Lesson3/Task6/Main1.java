package Lesson3.Task6;

public class Main1 {
    public static void main(String[] args) {
        //Task6 write an example what appends text string to a particular position in a file.
        // Name of modified file,  text string, and a position are specified as command line argument
        System.out.println("Task6 write an example what appends text string to a particular position in a file.");
        FilesOperator file = new FilesOperator();
        file.addTextToFile(args[0], args[1], args[2], args[3]);
        System.out.println("File before insertion:");
        file.printTextFile(args[0]);
        System.out.println("File after insertion:");
        file.printTextFile(args[1]);
    }
}
