package Lesson2.Task2;

public class CounterWithSync implements ICounter {
    private int counter = 0;

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized void setCounter(int i) {
        this.counter+=i;
    }

}
