package Lesson2.Task5;

public class Main {
    public static void main(String[] args) {
        //Create two thread subclasses, one with a run() that starts up and then calls wait().
        // The other class's run() should capture the reference of the first Thread object.
        // Its run() should call notifyAll() for the first Thread after some number of seconds
        // have passed so that first thread can print a message

        LockObject lockObject = new LockObject();
        Thread thread1 = new Thread(new FirstSubclass(lockObject));
        thread1.start();
        Thread thread2 = new Thread(new SecondSubclass(lockObject));
        thread2.start();

    }
}
