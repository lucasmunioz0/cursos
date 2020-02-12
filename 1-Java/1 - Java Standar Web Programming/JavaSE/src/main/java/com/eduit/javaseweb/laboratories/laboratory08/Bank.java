package com.eduit.javaseweb.laboratories.laboratory08;

import java.util.Collection;
import java.util.HashSet;

public class Bank {
    private final Collection<Person> queue = new HashSet<>();
    
    public int howManyPeopleAre(){
        return queue.size();
    }
    
    public void addPerson(Person person){
        /*
        If we dont use Set, we can use the method "contains" 
        to control duplicated person aggregation.
        if(!queue.contains(person)) 
        */
        queue.add(person);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        queue.forEach(person -> {
            sb.append(person).append("\n");
        });
        
        return sb.toString();
    }
}
