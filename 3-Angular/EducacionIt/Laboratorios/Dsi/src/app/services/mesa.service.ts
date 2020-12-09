import { Mesa } from './../models/mesa';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MesaService {
  mesas: Array<Mesa>;

  constructor() {
    this.mesas = new Array<Mesa>();
    this.mesas.push({
      id: 1,
      asignacion: true,
      seccion: 'A',
      sector: 'patio',
      piso: '1'
    });
    this.mesas.push({
      id: 2,
      asignacion: false,
      seccion: 'A',
      sector: 'terraza',
      piso: '2'
    });
    this.mesas.push({
      id: 3,
      asignacion: true,
      seccion: 'B',
      sector: 'vereda',
      piso: '1'
    });
    this.mesas.push({
      id: 4,
      asignacion: false,
      seccion: 'C',
      sector: 'comedor',
      piso: '1'
    });
    this.mesas.push({
      id: 5,
      asignacion: true,
      seccion: 'A',
      sector: 'bar',
      piso: '2'
    });
    this.mesas.push({
      id: 6,
      asignacion: false,
      seccion: 'B',
      sector: 'bar',
      piso: '2'
    });
  }

  getAll(): Array<Mesa> {
    return this.mesas;
  }

  filtrar(nombre: string) {
    let mesasAux = new Array<Mesa>();
    for (let i = 0; i < this.mesas.length; i++) {
      let mesa = this.mesas[i];
      if (
        mesa.seccion == nombre ||
        mesa.sector == nombre ||
        mesa.piso == nombre
      ) {
        mesasAux.push(mesa);
      }
    }
    return mesasAux;
  }
}
