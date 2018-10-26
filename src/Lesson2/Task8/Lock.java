package Lesson2.Task8;

public class Lock {
    private int actionNum;
    private int threadNum;

    public Lock(int actionNum, int threadNum) {
        this.actionNum = actionNum;
        this.threadNum = threadNum;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public int getActionNum() {
        return actionNum;
    }

    public synchronized void someAction(Lock lock){
        System.out.format("Thread %s : thread %s appeals to me %n",threadNum,lock.getThreadNum());
        System.out.format("Thread %s : requested an answer thread %s %n",threadNum,lock.getThreadNum());
        System.out.format("Thread %s : waiting for a response..... %n",threadNum);
        lock.someActioionAnswer(this);


    }
    public synchronized void someActioionAnswer(Lock lock){
        System.out.format("Thread %s : thread %s sends the answer to me %n",threadNum,lock.getThreadNum());
    }
}
