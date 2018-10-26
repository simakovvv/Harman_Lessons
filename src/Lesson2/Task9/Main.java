package Lesson2.Task9;




public class Main {

    public static void main(String[] args) {
        //Data races occur when there is insufficient synhronization around composite operations.
        // Write a short program that illustrates a data race
        //This program should print only even numbers.
        Count count = new Count();
        new Thread(new CounterThread(count)).start();
        new Thread(new PrinterThread(count)).start();

    }
}
class CounterThread implements Runnable{
    private Count count;

    public CounterThread(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i =0; i < 50;i++){
            count.setCount(count.getCount()+1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count.setStop(true);
    }
}
class PrinterThread implements Runnable{
    private Count count;

    public PrinterThread(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (!count.isStop()){
            if(count.getCount()%2 == 0){//at this stage, odd numbers should be eliminated
                if (count.getCount() % 2 != 0) {
                    System.out.println("Count= " + count.getCount() + " ");
                }
            }
        }
    }
}
class Count{
    static volatile Integer count = 0;
    private boolean stop = false;

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
