package com.micuper.form.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.micuper.form.services.IRolService;

@Component
public class RolesEditor extends PropertyEditorSupport{
	
	@Autowired
	private IRolService rolService;

	@Override
	public void setAsText(String idStr) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(idStr);
			setValue(rolService.obtenerPorId(id));
		}catch(NumberFormatException e) {
			setValue(null);
		}
	}
}
