package Lesson2.Task1;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task1");
        //Inherit a class from Thread and override the run() method. Inside run(),
        // print a message, and then call sleep(). Repeat this three times, then return from run().
        // Put a start-up message in the constructor and override finalize() to print a shut-down message.
        // Make a separate thread class that calls System.gc() and System.runFinalization() inside run(),
        // printing a message as it does so. Make several thread objects of both types and run them to see that happens.
        int count = 0;
        MyThread myThread = new MyThread(count++, "GarbageCollector");
        Thread exampleThread = new Thread(myThread);
        exampleThread.start();

        MyThread myThread1 = new MyThread(count++, "runFinalisation");
        Thread exampleThread1 = new Thread(myThread1);
        exampleThread1.start();

        try {

            exampleThread.join();
            ThreadKillerClass.isAliveThread(exampleThread,myThread.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {

            exampleThread1.join();
            ThreadKillerClass.isAliveThread(exampleThread1,myThread1.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
