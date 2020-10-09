import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejemplos',
  templateUrl: './app-ejemplos.component.html'
})
export class AppEjemplosComponent implements OnInit {

  public nombre: string;
  public cargo: string;
  public tituloDeshabilitado: boolean;

  constructor() { }

  ngOnInit(): void {
    this.nombre = 'Lucas Muñoz';
    this.cargo = 'Desarrollador Java';
    this.tituloDeshabilitado = true;
  }

  habilitar(){
    this.tituloDeshabilitado =  !this.tituloDeshabilitado;
  }
}
