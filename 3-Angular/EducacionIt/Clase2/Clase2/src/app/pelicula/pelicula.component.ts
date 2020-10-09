import { Component, OnInit } from '@angular/core';
import { Pelicula } from '../interfaces/pelicula';

@Component({
  selector: 'app-pelicula',
  templateUrl: './pelicula.component.html'
})
export class PeliculaComponent implements OnInit {
  peliculas: Array<Pelicula>;
  peliculaSeleccionada: Pelicula;

  constructor() { }

  ngOnInit(): void {
    this.peliculas = [
      { nombre: 'Volver al Futuro', director: 'Spielberg', anio: 1985},
      { nombre: 'Volver al Futuro II', director: 'Spielberg', anio: 1986},
      { nombre: 'Otra película', director: 'Bla', anio: 1990},
    ];
  }

  seleccionarPelicula(pelicula: Pelicula){
    this.peliculaSeleccionada = pelicula;
  }

}
