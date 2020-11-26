package com.micuper.form.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.micuper.form.domain.Pais;

@Service
public class PaisService implements IServicioPais {

	private List<Pais> paises;

	public PaisService() {
		paises = Arrays.asList(new Pais(1, "AR", "Argentina"), new Pais(2, "MX", "Mexico"), new Pais(3, "ES", "España"),
				new Pais(4, "CL", "Chile"));
	}

	@Override
	public List<Pais> getPaises() {
		return paises;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais pais = null;

		for (Pais p : paises) {
			if (p.getId() == id) {
				pais = p;
				break;
			}
		}

		return pais;
	}
}
