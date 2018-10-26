package Lesson2.Task5;

public class SecondSubclass implements Runnable {
    private LockObject lock;
    public SecondSubclass(LockObject t) {
        this.lock = t;
    }

    @Override
    public void run() {

        System.out.println("Second thread: started");
        synchronized (lock.getLock()) {
            System.out.println("Second thread: unlock the first thread");
            lock.getLock().notifyAll();
        }
    }
}
