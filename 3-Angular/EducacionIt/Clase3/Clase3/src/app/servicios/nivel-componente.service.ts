import { Injectable } from '@angular/core';

export class NivelComponenteService {

  constructor() { }

  saludar(mensaje: string){
    console.log(`NivelComponente: ` + mensaje);
  }
}
