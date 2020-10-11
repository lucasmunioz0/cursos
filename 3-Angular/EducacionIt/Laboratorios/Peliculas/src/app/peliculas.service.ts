import { PELICULAS } from './entidades/MockPeliculas';
import { observable, Observable, Observer } from 'rxjs';
import { Pelicula } from './entidades/Pelicula';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class PeliculasService {

  constructor() { }

  getPeliculas(): Observable<Pelicula[]>{
      return new Observable((observer: Observer<Pelicula[]>) => {
        observer.next(PELICULAS);
        observer.complete();
      });
  }

  buscarPelicula(id: number): Observable<Pelicula>{
    return new Observable<Pelicula>((observer: Observer<Pelicula>) => {
        const result = PELICULAS.find(pelicula => pelicula.id_pelicula === id);
        observer.next(result);
        observer.complete();
    });
  }
}
