package Lesson1.Exercise1_Arrays;

import java.util.OptionalDouble;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public class Arrays {
    private char[] massOfChar;
    private int[] massOfInt;//from Task5

    public Arrays(int max){
        massOfChar = new char[max];
    }
    public Arrays(int max, String type){
        massOfInt = new int[max];
    }
    public char[] getMassOfChar() {
        return massOfChar;
    }

    public char[] fillArray(){

        for (int i = 0; i < massOfChar.length; i++){
            massOfChar[i] =(char)i;
        }
        return massOfChar;
    }

    public void randomFillArray(int bound){
        Random random = new Random();
        if(massOfChar != null){
            for (int i = 0; i < massOfChar.length; i++)
                massOfChar[i] =(char)random.nextInt(bound);
        }    else {
            for (int i = 0; i < massOfInt.length; i++)
                massOfInt[i] =(char)random.nextInt(bound);
        }
    }

    //returns the sum of numbers in an array
    public long sumOfDigits(){
        long summ = 0;
        for (char c: massOfChar) {
            if((c >= 0) && (c < 10))
            summ+=c;
        }
        return summ;
    }
    public void printMass(){
        if(massOfChar != null){
            for (int i = 0; i < massOfChar.length; i++)
                System.out.print ("№"+i+":"+(int) massOfChar[i] +" ");
        }    else {
            for (int i = 0; i < massOfInt.length; i++)
                System.out.print ("№"+i+":"+(int) massOfInt[i] +" ");
        }

        System.out.println();
    }
    //input method for the first task
    public void keyboardInput(){
        System.out.println("Enter" + massOfChar.length + "numbers:");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter tree number: ");
        for (int i = 0; i<= massOfChar.length-1; i++)
            if (reader.hasNextInt())
               massOfChar[i] = (char)reader.nextInt(); // Scans the next token of the input as an int.
        //once finished
        reader.close();
    }

    //find two neighboring numbers in array
    public int findMinimalDistanceIndex(){
        int index =0;

        int distance = Math.abs(massOfChar[0]- massOfChar[1]);
        for (int i = 0; i < massOfChar.length-1; i++){
            if(distance > Math.abs(massOfChar[i]- massOfChar[i+1])){
                distance = Math.abs(massOfChar[i]- massOfChar[i+1]);
                index = i;
            }
        }
        return index;
    }


    public void printMassWithTab(int summOfColumn){

        int j =0;
        for (int i = 0; i < massOfChar.length; i++){
            System.out.print ("№" + i + ":" + (int) massOfChar[i] + "\t ");
            j++;
            if (j == summOfColumn){
                System.out.print("\n");
                j=0;
            }

        }
        System.out.println();
    }

    //find the average of the elements in the array
    public Double averageDigit(){
        int summ = 0;
        double average = 0;
        for(int i = 0; i < massOfChar.length; i++){
            summ+= massOfChar[i];
        }
        average = summ/ massOfChar.length;
        return average;
    }

    //find the average of the elements in the array with stream api
    public Double averageDigitWithStream(){
        // creating a stream
        IntStream stream = IntStream.of(2, 3, 4, 5, 6, 7, 8);
        // OptionalDouble is a container object
        // which may or may not contain a
        // doouble value.
        OptionalDouble obj = stream.average();
        // If a value is present, isPresent() will
        // return true and getAsDouble() will
        // return the value
        if (obj.isPresent()) {
            return obj.getAsDouble();
        }
        else {
            return -1.00;
        }
    }
}
