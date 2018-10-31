package Lesson1.Exercise3_Strings;

public class Main {
    public static void main(String[] args) {
        //Task1  Index is specifed by the end user
        System.out.println("Task1 write a program to get the character at the given index within the string. ");
        Strings string = new Strings();
        string.keyboardStringInput();
        System.out.println("the index of the entered letter is equal to:");
        System.out.println(string.getIndex(string.keyboardCharInput()));
        System.out.println("---------------------------------------------");


        System.out.println("Task2 program to test if a given string contains the specifed sequence of char value");
        Strings string2 = new Strings();
        string2.keyboardStringInput();
        System.out.println(string2.getIndexForWord(string2.keyboardCharArrInput()));
        System.out.println("---------------------------------------------");

        System.out.println("Task3 program that computes your initials from you full name and displays them");
        Strings string3 = new Strings();
        string3.keyboardStringInput();
        System.out.println("Your initials: " + string3.getInitials(string3.getWord()));
        System.out.println("---------------------------------------------");

        System.out.println("Task4 program, that cheks to given strings whetherone is anagram of ther other");
        Strings string4 = new Strings("Internet");
        Strings string5 = new Strings("Tine Rent");
        System.out.println("Words: " + string4.getWord() + ", " + string5.getWord() + ":");
        System.out.println("Is anagram: " + string4.checkAnagramm(string5));
        System.out.println();
        System.out.println("---------------------------------------------");

        System.out.println("Task5 Convert hexadecimal strings to their decimal representation");
        Strings string6 = new Strings("F2C22A3B6CA109A4");
        System.out.println("Word: " + string6.getWord() + " in hexadecimal system = " + string6.toHexadecimal());
        System.out.println("---------------------------------------------");


    }
}
