package ar.com.eduit.course.laboratories.laboratory1;

import java.util.ArrayList;
import java.util.List;

public class Goal {
    private int meters;
    private List<Horse> horses;

    public Goal(int meters) {
        this.meters = meters;
        horses = new ArrayList<>();
    }

    public boolean arrivedGoal(Horse horse){
        boolean arrived = false;
        if(horse.getMetersDone() >= meters){
            horses.add(horse);
            arrived = true;
        }
        
        return arrived;
    }
    
    public void positions(){
        for (int i = 0; i < horses.size(); i++) {
            System.out.printf("\n%d - %s", i, horses.get(i));
        }
    }
}