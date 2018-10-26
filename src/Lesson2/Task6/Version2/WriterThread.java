package Lesson2.Task6.Version2;

import Lesson2.Task6.Version1.Monitor;

public class WriterThread implements Runnable {
    private Monitor message;

    public WriterThread(Monitor message) {
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (message) {
            try {
                System.out.println("Thread1 Writer: flag state:" + message.getMessage());
                System.out.println("Thread1 Writer: is alive...and sleep");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 Writer: woke up and change the flag:");
            message.setMessage(true);
            System.out.println("Thread1 Writer: flag state:" + message.getMessage());
            message.notifyAll();
        }
    }
}
