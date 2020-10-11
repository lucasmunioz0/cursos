import { IPelicula } from './../entities/ipelicula';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-validar-driven',
  templateUrl: './validar-driven.component.html'
})
export class ValidarDrivenComponent implements OnInit {
  pelicula: IPelicula;
  generos: Array<string>;
  hidden: boolean;
  form: string;

  constructor() { }

  ngOnInit(): void {
    this.generos = new Array<string>();
    this.generos.push('Drama');
    this.generos.push('Comedia');
    this.generos.push('Acción');
    this.hidden = true;
    this.pelicula = {nombre: '', director: '', genero: ''};
  }

  submit(formulario){
    this.form = formulario.value;
    this.hidden = false;
  }

}
