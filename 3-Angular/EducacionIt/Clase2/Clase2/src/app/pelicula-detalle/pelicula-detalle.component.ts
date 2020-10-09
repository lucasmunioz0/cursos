import { Component, Input, OnInit } from '@angular/core';
import { Pelicula } from '../interfaces/pelicula';

@Component({
  selector: 'app-pelicula-detalle',
  templateUrl: './pelicula-detalle.component.html'
})
export class PeliculaDetalleComponent implements OnInit {

  @Input()
  peliculaSeleccionada: Pelicula;

  constructor() {
    this.peliculaSeleccionada = {nombre: '', director: '', anio: 0};
  }

  ngOnInit(): void {
  }
}
