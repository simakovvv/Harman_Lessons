package Lesson2.Task5;

public class LockObject {
    private static final class Lock { }
    private final Object lock = new Lock();

    public Object getLock() {
        return lock;
    }
}
