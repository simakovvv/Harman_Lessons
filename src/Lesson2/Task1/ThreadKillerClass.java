package Lesson2.Task1;

public class ThreadKillerClass {
    public static void callGC(int treadNum){
        System.out.println("now thread № " + treadNum + " caused Garbage Collector");
        System.gc();
    }
    public static void runFinalisation(int treadNum){
        System.out.println("now thread № " + treadNum + " caused runFinalisation() method");
        System.runFinalization();
    }
    public static void isAliveThread(Thread t, int threadNum){
        System.out.println("Thread № "+ threadNum + " is alive: " + t.isAlive());
        System.out.println("Thread № "+ threadNum + " is interrupted: " + t.isInterrupted());
    }
}
