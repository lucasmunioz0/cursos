package com.datajpa.util.paginator;

import lombok.Getter;

public class PageItem {
	private @Getter int numero;
	private @Getter boolean actual;
	
	public PageItem(int numero, boolean actual) {
		this.numero = numero;
		this.actual = actual;
	}
	
	
}
