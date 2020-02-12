package com.eduit.javaarchitect.clase3.bike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eduit.javaarchitect.clase3.bike.model.Bike;
import com.eduit.javaarchitect.clase3.bike.repository.BikeRepository;

@RestController
@RequestMapping("api/v1/bikes")
public class BikeController {
	
	@Autowired
	private BikeRepository bk;
	
	@GetMapping
	public List<Bike> lista(){
//		List<Bike> bikes = new ArrayList<>();
//		Bike b1 = new Bike();
//		b1.setName("Bike 1");
//		Bike b2 = new Bike();
//		b2.setName("Bike 2");
//		
//		bikes.add(b1);
//		bikes.add(b2);
		
		return bk.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Bike bike) {		
		bk.save(bike);
	}
	
	@DeleteMapping
	public void delete(@RequestBody Long id) {
		System.out.println(id);
		bk.deleteById(id);
	}
}