package com.datajpa.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;

public class PageRender<T> {
	private @Getter String url;
	private Page<T> page;
	private @Getter int totalPaginas;
	private int elementosPorPagina;
	private @Getter int paginaActual;
	private @Getter List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.elementosPorPagina = this.page.getSize();
		this.totalPaginas = this.page.getTotalPages();
		this.paginaActual = this.page.getNumber() + 1;
		this.paginas = new ArrayList<>();
		
		int desde, hasta;
		if(totalPaginas <= elementosPorPagina) {
			desde = 1;
			hasta = totalPaginas;
		}else {
			if(paginaActual <= elementosPorPagina/2) {
				desde = 1;
				hasta = elementosPorPagina;
			}else if(paginaActual >= totalPaginas - elementosPorPagina/2) {
				hasta = elementosPorPagina;
				desde = totalPaginas - elementosPorPagina + 1;				
			}else {
				hasta = elementosPorPagina;
				desde = paginaActual - elementosPorPagina/2;
			}
		}
		
		for(int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde + i));
		}
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
