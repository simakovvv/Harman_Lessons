package Lesson2.Task1;

public class MyThread implements Runnable {
    private int count;

    public int getCount() {
        return count;
    }

    private String killMethod;

    public MyThread(int count, String killMethod) {
        this.killMethod = killMethod;
        this.count = count;
        System.out.println("MyThread № " + count + " is Alive!");
    }

    private void isAlive() {
        System.out.println("MyThread№ " + count + "  is running!");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        isAlive();
        isAlive();
        isAlive();
        switch (killMethod) {
            case "GarbageCollector":
                ThreadKillerClass.callGC(count);
                break;
            case "runFinalisation":
                ThreadKillerClass.runFinalisation(count);
                break;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("MyThread № " + count + " is dead");
        super.finalize();
    }
}
