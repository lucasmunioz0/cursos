package com.micuper.di.services;

import org.springframework.stereotype.Service;

//@Service("miServicioSimple")
public class MiServicio implements IServicio{
	
	public String operacion() {
		return "ejecutando algún proceso importante simple.";
	}
}
