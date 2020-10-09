import { Pelicula } from './../entities/pelicula';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-validar-driven',
  templateUrl: './validar-driven.component.html'
})
export class ValidarDrivenComponent implements OnInit {
  generos = ['Aventura', 'Terror', 'Comedia', 'Drama'];
  modelo = new Pelicula(1, 'Dr Strange', this.generos[3], 'Scott Derrickson');
  submitted = false;

  constructor() { }

  ngOnInit(): void {
  }

  registrar(){
    this.submitted = true;
  }

  get diagnostico(){
    return JSON.stringify(this.modelo);
  }

  nuevaPelicula(){
    this.modelo = new Pelicula(11, '', '');
  }
}
