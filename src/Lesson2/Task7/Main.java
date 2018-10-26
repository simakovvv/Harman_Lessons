package Lesson2.Task7;

public class Main {
    public static void main(String[] args) {
        //Semafores are a widley used synchronization primitive --
        // but not one of the fundamental primitives provided by Java.
        // Implement a counting semaphore using synchronized(), wait(),
        //  and notify() in Java.
        int threadCount = 0;
        AccessСounter accessСounter = new AccessСounter();
        accessСounter.setMaximumAmount(3);
        new Thread(new SemaforeThread(threadCount++,accessСounter)).start();
        new Thread(new SemaforeThread(threadCount++,accessСounter)).start();
        new Thread(new SemaforeThread(threadCount++,accessСounter)).start();
        new Thread(new SemaforeThread(threadCount++,accessСounter)).start();
        new Thread(new SemaforeThread(threadCount++,accessСounter)).start();
    }
}
