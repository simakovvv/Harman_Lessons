package Lesson2.Task4;

public class SomeThread implements Runnable {
    private SomeMethod someMethod;
    public SomeThread(SomeMethod someMethod) {
        this.someMethod = someMethod;
    }

    @Override
    public void run() {
        someMethod.firstMethod();
    }
}
