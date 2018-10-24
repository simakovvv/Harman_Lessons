package Lesson1.Exercise3_Strings;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Strings {

    private String word;
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
        return aChar;
    }
    public char[] keyboardCharArrInput()  {
        System.out.println("Enter the word for searching: ");
        String s = reader.nextLine();
        char[] aChar = s.toCharArray(); // Scans the next token of the input as an int.
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
        // Early termination check, if strings are of unequal lengths,
        // delete spaces and set lower case
        word=word.toLowerCase().replaceAll("\\s+","");;
        someWord.setWord(someWord.getWord().toLowerCase().replaceAll("\\s+",""));
        // translate into char[] and sort
        char[] c1 = word.toCharArray();
        char[] c2 = someWord.getWord().toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String sc1 = new String(c1);
        String sc2 = new String(c2);
        return sc1.equals(sc2);
    }

    public BigInteger toHexadecimal(){
       BigInteger num = new BigInteger(word, 16);
       return num;
    }


}
