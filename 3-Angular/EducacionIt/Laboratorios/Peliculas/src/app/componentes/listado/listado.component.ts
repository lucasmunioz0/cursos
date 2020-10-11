import { PELICULAS } from './../../entidades/MockPeliculas';
import { Pelicula } from '../../entidades/Pelicula';
import { Component, OnInit } from '@angular/core';
import { PeliculasService } from 'src/app/peliculas.service';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html'
})
export class ListadoComponent implements OnInit {

  peliculas: Pelicula[];
  peliculaSeleccionada: number;

  constructor(private peliculasService: PeliculasService) { }

  ngOnInit(): void {
    this.peliculasService.getPeliculas()
                      .subscribe(data => this.peliculas = data);
  }

  editarPelicula(index: number){
    this.peliculaSeleccionada = index;
  }

  cancelar(event: any){
    this.peliculaSeleccionada = null;
  }
}
