import { Egreso } from './../entidades/egreso';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EgresoService {

  egresos: Egreso[] = [
    new Egreso('Renta departamento', 900),
    new Egreso('Ropa', 200)
  ];

  constructor() { }

  agregarEgreso(egreso: Egreso) {
    this.egresos.push(egreso);
  }

  eliminarEgreso(egreso: Egreso) {
    const index = this.egresos.indexOf(egreso);
    this.egresos.splice(index, 1);
  }
}
