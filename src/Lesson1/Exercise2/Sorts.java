package Lesson1.Exercise2;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Sorts {
    private ArrayList<Integer> task = new ArrayList<>();
    // sort by ascending three values



    public int equalsArray(ArrayList<Integer> task){
        int i = -2;// incorrect value
        if (this.task.size() == task.size()){
            i = 0;
        } else if(this.task.size() < task.size()){
            i = -1;
        } else if(this.task.size() > task.size()){
            i = 1;
        }
        return i;
    }

    public Sorts() {
    }
    public Sorts(int length) {
        randomFilling(length);
    }


    public void sortByAscending(){
       Collections.sort(task);
    }

    public ArrayList<Integer> getTask() {
        return task;
    }

    public void printArray(){
        task.stream().forEach((p) ->
        System.out.print( p + separator(p)));
        System.out.println();
    }

    public String separator(int p){
        if(p == task.get(task.size()-1)) {

            return ".";
        }else {
            return ", ";
        }

    }

    //input method for the first task
    public void keyboardInput(int length){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter tree number: ");
        for (int i = 0; i<= length-1;i++)
           task.add(reader.nextInt()); // Scans the next token of the input as an int.
        //once finished
        reader.close();
    }

    public void randomFilling(int length){

        Random random = new Random();
        for (int i = 0; i <=length; i++){
            task.add(random.nextInt(length));
        }
    }

    public int findMaxInt(){
        return Collections.max(task);
    }

    public int findMaxIntWithStreams(){
        return task.stream().collect(Collectors.summarizingInt(Integer::intValue)).getMax();
    }

    public void sortArrayWithStream(){
        task.stream().sorted().forEach((p) ->
                System.out.print( p + separator(p)));
    }

    public void compareArrays(ArrayList<Integer> task1){

    }


}
