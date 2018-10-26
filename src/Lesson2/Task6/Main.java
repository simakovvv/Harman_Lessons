package Lesson2.Task6;

import Lesson2.Task6.Version1.ListenerThread;
import Lesson2.Task6.Version1.Monitor;
import Lesson2.Task6.Version1.WriterThread;

public class Main {
    //Create an example of a "busy wait". One thread sleeps for a while and then
    // sets a flag to true. The second thread watches that flag inside a while loop
    // (this is a busy wait) and then the flag becomes true, set it back to false
    // and reports the change to the console. Note how much wasted time the program
    // spends inside the "busy wait" and create a second version of the program that
    // uses wait() instead of the "Busy wait"
    public static void main(String[] args) {

        System.out.println("First version of program. With Thread.sleep()");
        Monitor message = new Monitor();
        Thread writer = new Thread(new WriterThread(message));
        Thread listener =  new Thread(new ListenerThread(message));
        writer.start();
        listener.start();


        //waiting for the execution of the second thread
        try {
            listener.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------");


        System.out.println("First version of program. With with a common monitor (wait and notify)");
        Monitor message1 = new Monitor();
        Thread writer1 = new Thread(new Lesson2.Task6.Version2.WriterThread(message1));
        Thread listener1 = new Thread(new Lesson2.Task6.Version2.ListenerThread(message1));
        writer1.start();
        listener1.start();

    }
}
