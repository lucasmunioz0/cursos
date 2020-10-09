import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-driven',
  templateUrl: './driven.component.html'
})
export class DrivenComponent implements OnInit {

  formulario: any;

  constructor() { }

  ngOnInit(): void {
  }

  registrar(formulario){
    console.log(formulario.value.nombre);
    console.log(formulario.value.apellido);
    console.log(formulario.value.email);
    this.formulario = formulario.value;
  }
}
