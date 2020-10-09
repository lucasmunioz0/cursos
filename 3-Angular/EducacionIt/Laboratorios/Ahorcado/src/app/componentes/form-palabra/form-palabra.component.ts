import { Genero } from './../../entities/genero';
import { Palabra } from './../../entities/palabra';
import { Component, OnInit } from '@angular/core';
import { Dificultad } from 'src/app/entities/dificultad';

@Component({
  selector: 'app-form-palabra',
  templateUrl: './form-palabra.component.html'
})
export class FormPalabraComponent implements OnInit {
  palabra: Palabra;
  generos: Array<Genero>;
  dificultades: Array<Dificultad>;

  constructor() {

  }

  ngOnInit(): void {
    this.palabra = {
      codigo: '',
      idDificultad: -1,
      idGenero: -1,
      texto: '',
      pista: ''
    };

    this.dificultades = new Array<Dificultad>();
    this.dificultades.push({id: 1, descripcion: 'Fácil', min: 3, max: 6});
    this.dificultades.push({id: 2, descripcion: 'Medio', min: 7, max: 10});
    this.dificultades.push({id: 3, descripcion: 'Difícil', min: 10, max: 15});

    this.generos = new Array<Genero>();
    this.generos.push({id: 1, descripcion: 'Peliculas'});
    this.generos.push({id: 2, descripcion: 'Comidas'});
    this.generos.push({id: 3, descripcion: 'Series'});
    this.generos.push({id: 4, descripcion: 'Proceres'});
  }

  submit(){
    console.log(this.palabra);
  }
}
