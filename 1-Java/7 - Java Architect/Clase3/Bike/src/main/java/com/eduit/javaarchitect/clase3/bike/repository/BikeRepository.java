package com.eduit.javaarchitect.clase3.bike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eduit.javaarchitect.clase3.bike.model.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long>{
	
}
