package Lesson2.Task3;

import Lesson2.Task2.CounterWithoutSync;
import Lesson2.Task2.ICounter;


public class Main {
    public static void main(String[] args) {
        //write a short program in which one thread increments an integer 1000000 times,
        // and a  second thread prints the integer  - without waiting for it to finish.
        // Now modify the program to use a condition variable to signal completion
        // of the addition task by the first thread before the second thread prints value

        int threadCounter = 0;
        ICounter counterWithSync = new CounterWithSync();
        ICounter counterWithoutSync = new CounterWithoutSync();

        CounterThread counterThread = new CounterThread(counterWithSync, threadCounter++);
        PrintThread printThread = new PrintThread(counterWithSync, threadCounter++);

        Thread firstTread = new Thread(counterThread);
        Thread secondThread = new Thread(printThread);

        firstTread.start();
        secondThread.start();


        CounterThread counterThread1 = new CounterThread(counterWithoutSync, threadCounter++);
        PrintThread printThread1 = new PrintThread(counterWithoutSync, threadCounter++);

        Thread firstTread1 = new Thread(counterThread1);
        Thread secondThread1 = new Thread(printThread1);

        firstTread1.start();
        secondThread1.start();

    }
}
