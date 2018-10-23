package Lesson1.Exercise3_Strings;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Strings {

    private String word;
    private StringBuilder word1;
    private char aChar;
    private Scanner reader = new Scanner(System.in); // Reading from System.in

    public Strings() {
    }
    public Strings(String word) {
        this.word = word;
    }
    public void keyboardStringInput(){

        System.out.println("Enter some word: ");
        word = reader.nextLine(); // Scans the next token of the input as an String.
        //once finished
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public char keyboardCharInput()  {
        System.out.println("Enter the character for searching: ");
        String s = reader.nextLine();
        aChar = s.charAt(0); // Scans the next token of the input as an int.
        //once finished
        reader.close();
        return aChar;
    }
    public char[] keyboardCharArrInput()  {
        System.out.println("Enter the word for searching: ");
        String s = reader.nextLine();
        char[] aChar = s.toCharArray(); // Scans the next token of the input as an int.
        //once finished
        reader.close();
        return aChar;
    }

    public String getInitials(String str) {
        String[] tempArray = str.split(" ");
        String rezult = tempArray[0] + " ";
        for (int i = 1; i < tempArray.length; i++) {
            rezult += tempArray[i].substring(0, 1).toUpperCase() + ". ";
        }
        return rezult.trim();
    }

    public int getIndexForWord(char[] character){
        System.out.println("entry index:");
        return word.indexOf(String.copyValueOf(character));
    }
    public int getIndex(char character){
           return word.indexOf(character);
   }
    public boolean checkAnagramm(Strings someWord){
        boolean result;
        if(someWord.equals(word1.reverse())){
            return result = true;
        } else {
            return result = false;
        }
    }

}
