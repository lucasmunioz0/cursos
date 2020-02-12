package ar.com.eduit.course.laboratories.laboratory1;

public class Horse implements Runnable{

    private final String name;
    private final Goal goal;
    private int metersDone;
    private long startTime;
    private long endTime;

    public Horse(String name, Goal goal) {
        this.name = name;
        this.goal = goal;
    }
    
    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while(!goal.arrivedGoal(this)){
            endTime = System.currentTimeMillis();
            avanzar();
            System.out.println(String.format("%s: -  %dm", name, metersDone));
        }
        System.out.println(this);
    }   
    
    private synchronized void avanzar() {
        metersDone += (int) (Math.random() * 10);
    }

    public int getMetersDone() {
        return metersDone;
    }

    @Override
    public String toString() {
        return String.format("%s Done in: %d miliSeconds", name, ((endTime - startTime)));
    }
}