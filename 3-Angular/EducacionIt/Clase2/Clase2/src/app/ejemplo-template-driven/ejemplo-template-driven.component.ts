import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-ejemplo-template-driven',
  templateUrl: './ejemplo-template-driven.component.html'
})
export class EjemploTemplateDrivenComponent implements OnInit {
  nombre: string;
  codigo: string;
  password: string;

  constructor() { }

  ngOnInit(): void {
    this.nombre = '';
    this.codigo = '';
    this.password = '';
  }

  aceptar() {

  }

  cancelar() {
    this.nombre = '';
    this.codigo = '';
    this.password = '';
  }

  submit(formulario) {
    console.dir(formulario.value);
  }

}
