import { Producto } from './../models/producto';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  productos: Array<Producto>;

  constructor() {
    this.productos = new Array<Producto>();
    this.productos.push({
      id: 1,
      nombre: 'Coca Cola',
      tipo: 'Bebida',
      precio: 100
    });
    this.productos.push({
      id: 2,
      nombre: 'Milanesa Napolitana con Guarnición',
      tipo: 'Plato Principal',
      precio: 500
    });
    this.productos.push({
      id: 3,
      nombre: 'Lomito',
      tipo: 'Plato Principal',
      precio: 600
    });
    this.productos.push({
      id: 4,
      nombre: 'Empanadas',
      tipo: 'Entrada',
      precio: 60
    });
    this.productos.push({
      id: 5,
      nombre: 'Agua Mineral',
      tipo: 'Bebida',
      precio: 90
    });
    this.productos.push({
      id: 6,
      nombre: 'Picada',
      tipo: 'Entrada',
      precio: 300
    });
    this.productos.push({
      id: 7,
      nombre: 'Pure con papas',
      tipo: 'Guarnicion',
      precio: 100
    });
    this.productos.push({
      id: 8,
      nombre: 'Ensalada',
      tipo: 'Guarnicion',
      precio: 100
    });
  }

  getAll(): Array<Producto> {
    return this.productos;
  }

  filtrar(filtro) {
    let t = null;
    let productosAux = new Array<Producto>();
    for (let i = 0; i < this.productos.length; i++) {
      let producto = this.productos[i];
      if (
        producto.nombre.toLowerCase().includes(filtro.toLowerCase()) ||
        producto.tipo.toLowerCase().includes(filtro.toLowerCase())
      ) {
        productosAux.push(producto);
      }
    }
    return productosAux;
  }
}
