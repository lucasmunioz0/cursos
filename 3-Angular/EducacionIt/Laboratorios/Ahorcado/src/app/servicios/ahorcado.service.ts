import { Observable, Observer } from 'rxjs';
import { LoggerService } from './logger.service';
import { DIFICULTADES, GENEROS } from './../mocks/mock';
import { Injectable } from '@angular/core';
import { Dificultad } from '../entities/dificultad';
import { Genero } from './../entities/genero';

@Injectable({
  providedIn: 'root'
})
export class AhorcadoService {

  constructor(private _loggerService: LoggerService) { }

  getDificultades(): Observable<Array<Dificultad>> {
    this._loggerService.info('Ejecutando getDificultades()');
    return new Observable<Array<Dificultad>>((observer: Observer<Array<Dificultad>>) => {
      setTimeout(() => {
        observer.next(DIFICULTADES);
        observer.complete();
        this._loggerService.info('Termino getDificultades()');
      }, 2000);
    });
  }

  getGeneros(): Observable<Array<Genero>> {
    this._loggerService.info('Ejecutando getGeneros()');
    return new Observable<Array<Genero>>((observer: Observer<Array<Genero>>) => {
      observer.next(GENEROS);
      observer.complete();
      this._loggerService.info('Terminó getGeneros()');
    });
  }
}
