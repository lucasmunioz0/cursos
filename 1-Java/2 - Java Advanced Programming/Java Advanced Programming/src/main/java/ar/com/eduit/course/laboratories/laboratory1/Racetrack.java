package ar.com.eduit.course.laboratories.laboratory1;

import java.util.ArrayList;
import java.util.List;

public class Racetrack {

    private final List<Horse> horses;
    private final Goal goal;

    public Racetrack(Goal goal) {
        horses = new ArrayList<>();
        this.goal = goal;
    }

    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    public void startRace() {
        horses.forEach(horse -> {
            new Thread(horse).start();
        });
    }

    public void notifyPositions() {
        System.out.println("\n\t\tPosiciones...");
        goal.positions();
    }
}