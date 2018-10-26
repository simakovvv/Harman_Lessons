package Lesson2.Task8;


public class DeadLockThread implements Runnable {
    private int threadNum;
    private Lock lock1;
    private Lock lock2;

    public DeadLockThread(int threadNum, Lock lock1, Lock lock2) {
        this.threadNum = threadNum;
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        lock1.someAction(lock2);
    }
}
