import { Titular } from './../models/titular';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TitularService {
  titulares: Array<Titular>;

  constructor() {
    this.titulares = new Array<Titular>();
    this.titulares.push({ id: 1, nombre: 'Manuel' });
    this.titulares.push({ id: 2, nombre: 'Jose' });
    this.titulares.push({ id: 3, nombre: 'Pedro' });
  }

  getAll(): Titular[] {
    return this.titulares;
  }

  getByNombre(nombre: string) {
    let t = null;
    for (let i = 0; i < this.titulares.length; i++) {
      let taux = this.titulares[i];
      if (taux.nombre == nombre) {
        t = taux;
        break;
      }
    }
    return t;
  }
}
