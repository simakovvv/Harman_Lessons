package Lesson2.Task2;

public class CounterWithoutSync implements ICounter{
    private int counter = 0;


    public int getCounter() {
        return counter;
    }

    public void setCounter(int i) {
        this.counter+=i;
    }
}
