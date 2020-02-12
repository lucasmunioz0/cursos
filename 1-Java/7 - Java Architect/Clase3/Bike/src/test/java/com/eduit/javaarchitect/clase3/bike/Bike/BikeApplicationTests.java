package com.eduit.javaarchitect.clase3.bike.Bike;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eduit.javaarchitect.clase3.bike.controller.BikeController;
import com.eduit.javaarchitect.clase3.bike.model.Bike;

@SpringBootTest(classes = {Bike.class, BikeController.class})
class BikeApplicationTests {

	@Test
	public void shouldGetBikesList() {
		BikeController bike = new BikeController();
		List<Bike> bikes = bike.lista();
		System.out.println(bikes.size());
		assertEquals(2, bikes.size());
	}

}
