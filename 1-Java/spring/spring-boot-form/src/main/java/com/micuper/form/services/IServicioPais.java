package com.micuper.form.services;

import java.util.List;

import com.micuper.form.domain.Pais;

public interface IServicioPais {

	List<Pais> getPaises();
	Pais obtenerPorId(Integer id);
	
}
