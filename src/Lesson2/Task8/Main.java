package Lesson2.Task8;

public class Main {
    public static void main(String[] args) {
        //Deadlocks are an inherent problem in concurent systems using locks
        //  or other blocking primitives. Implement a deadlock involving two threads and two locks in java
        int lockNum = 0;
        Lock lock = new Lock(lockNum++,0);
        Lock lock1 = new Lock(lockNum++,1);
        new Thread(new DeadLockThread(0, lock,lock1)).start();
        new Thread(new DeadLockThread(1, lock1,lock)).start();
    }
}
