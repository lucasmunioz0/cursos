import { Injectable } from '@angular/core';

export class Motor{
  cilindros = 4;
}

export class Ruedas{
  marca = 'Bridesgtone';
}

@Injectable({
  providedIn: 'root'
})
export class AutoService {

  descripcion = 'DI';

  constructor(public motor: Motor, public ruedas: Ruedas) { }

  drive(){
    return `${this.descripcion} auto con ${this.motor.cilindros} y ruedas ${this.ruedas.marca}`;
  }
}
