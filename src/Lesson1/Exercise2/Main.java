package Lesson1.Exercise2;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task1 sort by ascending three values");
        Sorts sort = new Sorts();
        sort.keyboardInput(3);
        System.out.println("before sorting:");
        sort.printArray();
        sort.sortByAscending();
        System.out.println("after sorting");
        sort.printArray();
        System.out.println("---------------------------------------------");

        System.out.println("Task2 find the maximum element of array");
        Sorts array = new Sorts();
        array.randomFilling(10);// you can set the value of the array
        array.printArray();
        System.out.print("maximum element of array: ");
        System.out.println(array.findMaxInt());
        System.out.println("---------------------------------------------");

        System.out.println("Task3 do item 2 Java 8 streams");
        Sorts array1 = new Sorts();
        array1.randomFilling(10);// you can set the value of the array
        array1.printArray();
        System.out.print("maximum element of array: ");
        System.out.println(array1.findMaxInt());
        System.out.println("---------------------------------------------");

        System.out.println("Task 4 Sort an integer without usung Arrays.sort");
        Sorts array2 = new Sorts();
        array2.randomFilling(10);// you can set the value of the array
        array2.printArray();
        array2.sortArrayWithStream();
        System.out.println();
        System.out.println("---------------------------------------------");

        System.out.println("Task5 write a function to compare to integer arrays");
        Sorts array3 = new Sorts(10);
        Sorts array4 = new Sorts(20);
        int i = array3.equalsArray(array4.getTask());
        switch (i) {
            case -1:
                System.out.println("the first is less than the second");
                break;
            case 0:
                System.out.println("arrays are equal");
                break;
            case 1:
                System.out.println("the first is greater than the second");
                break;
            default:
                System.out.println("Incorrect value");
                break;
        }
        System.out.println("---------------------------------------------");

    }
}
