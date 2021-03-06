package Lesson2.Task6.Version2;

import Lesson2.Task6.Version1.Monitor;

public class ListenerThread implements Runnable {
    private Monitor message;

    public ListenerThread(Monitor message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (message) {
            while (message.getMessage() == false) {
                System.out.println("Thread2 Listener: flag state:" + message.getMessage());
                System.out.println("Thread2 Listener: is alive...and wait");
                try {
                    message.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Thread2 Listener: woke up and change the flag:");
        message.setMessage(false);
        System.out.println("Thread2 Listener: flag state: " + message.getMessage());
    }
}
