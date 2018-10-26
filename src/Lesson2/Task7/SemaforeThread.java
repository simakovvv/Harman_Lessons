package Lesson2.Task7;

import Lesson2.Task4.SomeMethod;

public class SemaforeThread implements Runnable {
    private int threadNum;
    private AccessСounter semaphore;

    public SemaforeThread(int threadNum, AccessСounter semaphore) {
        this.threadNum = threadNum;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Thread "+threadNum+" waiting for permission");
        synchronized (semaphore){

            while (!semaphore.getAccess()){
                try {
                    semaphore.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread "+threadNum+" get access and do work with task:");
            for (int i = 0; i < 10; i++){
                System.out.print(".."+i+"..");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("Thread "+threadNum+" finished work with the task and returns access");
            semaphore.returnAccess();
            semaphore.notify();
        }
    }
}
