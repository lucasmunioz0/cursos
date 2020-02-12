package com.eduit.javaarchitect.clase2.services;

import com.eduit.javaarchitect.clase2.models.Bike;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/bikes")
public class BikeService {

    @GetMapping
    public List<Bike> getAll(){
        List<Bike> bikes = new ArrayList<>();
        Bike bike1 = new Bike();
        Bike bike2 = new Bike();
        Bike bike3 = new Bike();
        Bike bike4 = new Bike();
        Bike bike5 = new Bike();
        bike1.setName("Bike1");
        bike2.setName("Bike2asdasd");
        bike3.setName("Bike3");
        bike4.setName("Bike4");
        bike5.setName("Bike5");
        bikes.add(bike1);
        bikes.add(bike2);
        bikes.add(bike3);
        bikes.add(bike4);
        bikes.add(bike5);

        return bikes;
    }
}
