package Lesson2.Task3;

import Lesson2.Task2.ICounter;//

public class CounterThread implements Runnable {
    private int threadNum;
    private int length = 1000000;
    private ICounter instance;

    public CounterThread(ICounter instance, int threadNum) {
        this.instance = instance;
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        for (int i = 0; i <= length - 1; i++) {
            instance.setCounter(1);
        }

    }
}
