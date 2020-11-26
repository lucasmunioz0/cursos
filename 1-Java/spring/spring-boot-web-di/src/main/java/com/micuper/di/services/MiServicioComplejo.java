package com.micuper.di.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Service("miServicioComplejo")
@Primary
public class MiServicioComplejo implements IServicio{
	
	public String operacion() {
		return "ejecutando algún proceso importante complejo.";
	}
}
