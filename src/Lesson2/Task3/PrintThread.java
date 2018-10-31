package Lesson2.Task3;

import Lesson2.Task2.CounterWithoutSync;
import Lesson2.Task2.ICounter;

public class PrintThread implements Runnable {
    private int threadNum;
    private ICounter instance;

    public PrintThread(ICounter instance, int threadNum) {
        this.instance = instance;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        if (instance instanceof CounterWithoutSync)
            System.out.println("Not-syncronised print method № " + threadNum + ": " + instance.getCounter());
        else
            System.out.println("Syncronised print method № " + threadNum + ": " + instance.getCounter());

    }
}
