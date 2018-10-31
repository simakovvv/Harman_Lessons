package Lesson2.Task5;

public class FirstSubclass implements Runnable {
    private LockObject lock;

    public FirstSubclass(LockObject t) {
        this.lock = t;
    }

    @Override
    public void run() {

        synchronized (lock.getLock()) {
            System.out.println("Fist thread: I'm a sleeep.");
            try {
                lock.getLock().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Fist thread: I woke up!");
        }
    }
}
