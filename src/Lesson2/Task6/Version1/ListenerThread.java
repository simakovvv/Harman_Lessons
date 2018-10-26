package Lesson2.Task6.Version1;

public class ListenerThread implements Runnable {
    private Monitor message;

    public ListenerThread(Monitor message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (message.getMessage() == false) {
            System.out.println("Thread2 Listener: flag state:" + message.getMessage());
            System.out.println("Thread2 Listener: is alive...and wait");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread2 Listener: woke up and change the flag:");
        message.setMessage(false);
        System.out.println("Thread2 Listener: flag state: " + message.getMessage());
    }
}
