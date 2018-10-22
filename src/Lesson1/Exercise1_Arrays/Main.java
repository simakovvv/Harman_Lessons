package Lesson1.Exercise1_Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task1 sum of digit char[] to long");
        Arrays array = new Arrays(9);
        array.fillArray();// fills ascending
        //array.keyboardInput();
        array.printMass();
        System.out.println("Summ of digits in array:" + array.sumOfDigits());
        System.out.println("---------------------------------------------");
        System.out.println();

        System.out.println("Task2 find two neighboring numbers in array:");
        Arrays array1 = new Arrays(10);
        //array1.keyboardInput();
        array1.randomFillArray(100);// set bounds
        array1.printMass();
        System.out.println("Minimal distance between elements:" + array1.findMinimalDistanceIndex() + " and " + (array1.findMinimalDistanceIndex()+1));
        System.out.println("Distantion: " +
                Math.abs((array1.getMassOfChar()[array1.findMinimalDistanceIndex()+1] - array1.getMassOfChar()[array1.findMinimalDistanceIndex()])));
        System.out.println("---------------------------------------------");
        System.out.println();

        System.out.println("Task3 Use the tabulator from prints out the multiplication table");
        Arrays array2 = new Arrays(10);
        array2.fillArray();
        array2.printMassWithTab(4); //set summ of column
        System.out.println("---------------------------------------------");
        System.out.println();


        System.out.println("Task4 progtram to get the average of all numbers in array");
        Arrays array3 = new Arrays(10);
        array3.randomFillArray(10);
        array3.printMass();
        System.out.println("Average digit:" + array3.averageDigit());

        System.out.println("Task5 progtram to get the average of all numbers in array with using StreamAPI");
        Arrays array4 = new Arrays(10,"int");
        array3.randomFillArray(10);
        array3.printMass();
        System.out.println("Average digit:" + array3.averageDigitWithStream());


    }
}
