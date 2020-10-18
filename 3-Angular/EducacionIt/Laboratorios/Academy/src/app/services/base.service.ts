import { IBase } from '../interfaces/ibase';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { handleError } from '../utilities/servicesUtilities';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class BaseService<T extends IBase> {
  BASE_URL: string;

  constructor(public _http: HttpClient) {}

  getAll(): Observable<Array<T>>{
    return this._http.get<Array<T>>(this.BASE_URL).pipe(
      catchError(handleError)
    );
  }

  get(id: number): Observable<T>{
    return this._http.get<T>(`${this.BASE_URL}/${id}`).pipe(
      catchError(handleError)
    );
  }

  post(t: T): Observable<T>{
    return this._http.post<T>(this.BASE_URL, t, environment.httpOptions).pipe(
      catchError(handleError)
    );
  }

  put(t: T): Observable<T>{
    return this._http.put<T>(`${this.BASE_URL}/${t.id}`, t, environment.httpOptions).pipe(
      catchError(handleError)
    );
  }

  delete(id: number): Observable<T>{
    return this._http.delete<T>(`${this.BASE_URL}/${id}`, environment.httpOptions).pipe(
      catchError(handleError)
    );
  }
}
