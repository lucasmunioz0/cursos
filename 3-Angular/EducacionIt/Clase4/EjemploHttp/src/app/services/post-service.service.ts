import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { IPost } from './../entidades/usuario';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostServiceService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'my-auth-token'
    })
  };


  BASE_URL = 'https://jsonplaceholder.typicode.com';

  constructor(private _http: HttpClient) { }

  getPosts(): Observable<Array<IPost>>{
    return this._http.get<Array<IPost>>(`${this.BASE_URL}/posts`)
    .pipe(
      catchError(this._manejarError)
    );
  }

  private _manejarError(error: HttpErrorResponse){
    if (error.error instanceof ErrorEvent){
      console.log('Ocurrió un error: ', error.error.message);
    } else{
      console.log('El backend retorno el código' + error.status + '. El cuerpo del mensaje de error es: ' + error.message);
    }
    return throwError('Algo salio mal');
  }
}
