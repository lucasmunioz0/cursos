import { catchError } from 'rxjs/operators';
import { Palabra } from './../entities/palabra';
import { HttpClient } from '@angular/common/http';
import { Observable, Observer, throwError } from 'rxjs';
import { LoggerService } from './logger.service';
import { DIFICULTADES, GENEROS } from './../mocks/mock';
import { Injectable } from '@angular/core';
import { Dificultad } from '../entities/dificultad';
import { Genero } from './../entities/genero';
import { error } from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class AhorcadoService {
  URL_BASE = "http://localhost:3000";
  URL_BASE_PALABRAS = `${this.URL_BASE}/palabras`;
  URL_BASE_DIFICULTADES = `${this.URL_BASE}/dificultades`;
  URL_BASE_GENEROS = `${this.URL_BASE}/generos`;

  constructor(private _loggerService: LoggerService, private _http: HttpClient) { }

  getDificultades(): Observable<Array<Dificultad>> {
    return this._http.get<Array<Dificultad>>(this.URL_BASE_DIFICULTADES);
    // this._loggerService.info('Ejecutando getDificultades()');
    // return new Observable<Array<Dificultad>>((observer: Observer<Array<Dificultad>>) => {
    //   setTimeout(() => {
    //     observer.next(DIFICULTADES);
    //     observer.complete();
    //     this._loggerService.info('Termino getDificultades()');
    //   }, 2000);
    // });
  }

  getGeneros(): Observable<Array<Genero>> {
    return this._http.get<Array<Genero>>(this.URL_BASE_GENEROS);
    // this._loggerService.info('Ejecutando getGeneros()');
    // return new Observable<Array<Genero>>((observer: Observer<Array<Genero>>) => {
    //   observer.next(GENEROS);
    //   observer.complete();
    //   this._loggerService.info('Terminó getGeneros()');
    // });
  }

  getPalabras(): Observable<Array<Palabra>> {
    return this._http.get<Array<Palabra>>(this.URL_BASE_PALABRAS);
  }

  getPalabra(id: number): Observable<Palabra> {
    return this._http.get<Palabra>(this.URL_BASE_PALABRAS + "/" + id);
  }

  deletePalabra(id: number): Observable<Palabra> {
    return this._http.delete<Palabra>(this.URL_BASE_PALABRAS + "/" + id);
  }

  addPalabra(palabra: Palabra): Observable<Palabra> {
    return this._http.post<Palabra>(this.URL_BASE_PALABRAS, palabra)
    .pipe(
      catchError( (error) => throwError(`Se produjo un error: ${error.message}`))
    )
  }

  updatePalabra(palabra: Palabra): Observable<Palabra> {
    return this._http.put<Palabra>(this.URL_BASE_PALABRAS + "/" + palabra.id, palabra);
  }
}
