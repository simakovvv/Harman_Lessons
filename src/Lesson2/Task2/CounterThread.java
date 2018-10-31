package Lesson2.Task2;

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
        if (instance instanceof CounterWithoutSync)
            System.out.println("Not-syncronised counter № " + threadNum + ": " + instance.getCounter());
        else
            System.out.println("Syncronised counter № " + threadNum + ": " + instance.getCounter());
    }
}
