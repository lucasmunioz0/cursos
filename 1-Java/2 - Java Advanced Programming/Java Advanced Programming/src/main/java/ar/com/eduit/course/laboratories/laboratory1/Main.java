package ar.com.eduit.course.laboratories.laboratory1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Goal goal = new Goal(1000);
        Racetrack race = new Racetrack(goal);
        
        Horse horse1 = new Horse("Tiro blanco1", goal);
        Horse horse2 = new Horse("Tiro blanco2", goal);
        Horse horse3 = new Horse("Tiro blanco3", goal);
        Horse horse4 = new Horse("Tiro blanco4", goal);
        Horse horse5 = new Horse("Tiro blanco5", goal);
        Horse horse6 = new Horse("Tiro blanco6", goal);
        race.addHorse(horse1);
        race.addHorse(horse2);
        race.addHorse(horse3);
        race.addHorse(horse4);
        race.addHorse(horse5);
        race.addHorse(horse6);
        
        race.startRace();
        
        Thread.sleep(2000);
        race.notifyPositions();
    }
}
