package Lesson2.Task3;

import Lesson2.Task2.ICounter;

public class CounterWithSync implements ICounter {
    private volatile int counter = 0;

    public synchronized int getCounter() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return counter;
    }

    public synchronized void setCounter(int i) {

        this.counter+=i;
        if(counter == 100000){
            notify();
        }
    }

}
