package Lesson2.Task7;

public class AccessСounter {
    private int counter = 0;
    private int maximumAmount;

    public int getCounter() {
        return counter;
    }

    public boolean getAccess() {
        if(counter < maximumAmount) {
            counter++;
            return true;
        } else
            return false;
    }
    public void returnAccess(){
        counter--;
    }
    public void setMaximumAmount(int maximumAmount){
        this.maximumAmount = maximumAmount;
    }
}
