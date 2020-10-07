import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Usuario } from './usuario';
import { catchError, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private _client: HttpClient) { }

  public getUsuarios():Observable<Usuario[]>{
    return this._client.get<Usuario[]>("http://localhost:3000/usuario");
  }

  public getUsuariosById(id: number): Observable<Usuario>{
    return this._client.get<Usuario>("http://localhost:3000/usuario/" + id)
    .pipe (
      catchError(
        error => {
          console.log("Fasllo dentro del servicio ");
          return throwError(error);
        }
      )
    )
  }


}
