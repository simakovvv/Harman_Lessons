package Lesson2.Task4;

public class SomeMethod {
    public synchronized void firstMethod(){
        System.out.println("the first synchronized method is called");
        secondMethod();
    }
    public synchronized void secondMethod(){
        System.out.println("the second synchronized method is called");
        thirdMethod();
    }
    public synchronized void thirdMethod(){
        System.out.println("the third synchronized method is called");
    }
}
