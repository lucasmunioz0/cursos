import { Ingreso } from './../entidades/ingreso';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IngresoService {

  ingresos: Ingreso[] = [
    new Ingreso('Salario', 4000),
    new Ingreso('Venta Coche', 3000)
  ];

  constructor() { }

  agregarIngreso(ingreso: Ingreso) {
    this.ingresos.push(ingreso);
  }

  eliminarIngreso(ingreso: Ingreso) {
    const index = this.ingresos.indexOf(ingreso);
    this.ingresos.splice(index, 1);
  }
}
