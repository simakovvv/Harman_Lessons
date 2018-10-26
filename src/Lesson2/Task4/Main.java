package Lesson2.Task4;

public class Main {
    public static void main(String[] args) {
        ///Demonstrate that a synchronized method in a class can call
        // a second synchronized method in the same class, which can them call
        // a third synchronized method in the same class.
        // Create a separate Thread object that invokes the first  synhronized method
        new Thread(new SomeThread(new SomeMethod())).start();
    }
}
