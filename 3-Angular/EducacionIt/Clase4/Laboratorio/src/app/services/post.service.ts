import { catchError } from 'rxjs/operators';
import { IPost } from './../interfaces/ipost';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = 'https://jsonplaceholder.typicode.com/';
const BASE_URL_POST = 'https://jsonplaceholder.typicode.com/posts';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  }
)};

@Injectable()
export class PostService {

  message: string;
  postSelected: number;

  constructor(private _http: HttpClient) { }

  posts(): Observable<Array<IPost>> {
    return this._http.get<Array<IPost>>(BASE_URL_POST).pipe(
      catchError(this._handleError)
    );
  }

  post(id: number): Observable<IPost> {
    return this._http.get<IPost>(`${BASE_URL_POST}/${id}`).pipe(
      catchError(this._handleError)
    );
  }

  add(post: IPost): Observable<IPost> {
    return this._http.post<IPost>(BASE_URL_POST, post, httpOptions).pipe(
      catchError(this._handleError)
    );
  }

  update(post: IPost): Observable<IPost> {
    return this._http.put<IPost>(`${BASE_URL_POST}/${post.id}`, post, httpOptions).pipe(
      catchError(this._handleError)
    );
  }

  delete(id: number): Observable<any> {
    return this._http.delete<IPost>(`${BASE_URL_POST}/${id}`).pipe(
      catchError(this._handleError)
    );
  }

  private _handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      this.message = `Ocurrió un error: ${error.error.message}`;
    } else {
      this.message = `Ocurrió un error en el backend: ${error.status} - ${error.message}`;
    }
    return throwError(this.message);
  }
}
