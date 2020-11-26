package com.micuper.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.micuper.di.models.Cliente;
import com.micuper.di.models.Factura;
import com.micuper.di.models.ItemFactura;
import com.micuper.di.models.Producto;
import com.micuper.di.services.IServicio;
import com.micuper.di.services.MiServicio;
import com.micuper.di.services.MiServicioComplejo;

@Configuration
public class AppConfig {

	@Bean("miServicioSimple")
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	@Primary
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}
	
//	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		List<ItemFactura> lista = new ArrayList<>(3);
		ItemFactura itemFactura;
		Producto producto;
		for	(int i = 1; i <= 3; i++) {
			producto = new Producto("Producto " + i, i * 200);
			itemFactura = new ItemFactura(producto, i);
			lista.add(itemFactura);
		}
		
		return lista;
	}
	
	@Bean
	public List<Factura> registrarFacturas(){
		System.out.println("ReGISTRANDO FACTURAS");
		Factura factura;
		List<Factura> facturas = new ArrayList<>(4); 
		
		for (int i = 1; i <= facturas.size(); i++) {
			factura = new Factura("Factura " + i, new Cliente("Cliente " + i, "Apellido"), registrarItems());
			facturas.add(factura);
		}
		
		return facturas;
	}
}
