package Lesson2.Task2;

import Lesson2.Task1.ThreadKillerClass;

public class Main {
    public static void main(String[] args) {
        //write a short program in which two threads both increment a shared integer repeatedly,
        // without proper synchronization, 1000000 times, printing the result at the end of the program.
        // Modify the program to use synchronised to ensure that increment on the shared variable are atomic

        int threadCounter = 0;
        ICounter counterWithoutSync = new CounterWithoutSync();
        ICounter counterWithSync = new CounterWithSync();

        CounterThread counterThread = new CounterThread(counterWithoutSync, threadCounter++);
        CounterThread counterThread1 = new CounterThread(counterWithoutSync, threadCounter++);

        Thread firstThread = new Thread(counterThread);
        Thread secondThread = new Thread(counterThread1);

        firstThread.start();
        secondThread.start();

        CounterThread counterThread2 = new CounterThread(counterWithSync, threadCounter++);
        CounterThread counterThread3 = new CounterThread(counterWithSync, threadCounter++);

        Thread thirdThread = new Thread(counterThread2);
        Thread fourthThread = new Thread(counterThread3);

        thirdThread.start();
        fourthThread.start();







    }
}
