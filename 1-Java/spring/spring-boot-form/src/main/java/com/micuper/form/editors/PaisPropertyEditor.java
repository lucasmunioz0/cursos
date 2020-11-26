package com.micuper.form.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.micuper.form.services.IServicioPais;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private IServicioPais servicioPais;

	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		try {
			setValue(servicioPais.obtenerPorId(Integer.parseInt(id)));
		} catch (NumberFormatException e) {
			setValue(null);
		}
	}
}
