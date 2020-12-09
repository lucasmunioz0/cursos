import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente} from './cliente';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { formatDate } from '@angular/common';


@Injectable()
export class ClienteService {

  private urlEndPoint = 'http://localhost:8080/api/clientes';

  private httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(private _http: HttpClient, private _router: Router) {}

  getClientes(): Observable<Cliente[]>{
    return this._http.get<Cliente[]>(this.urlEndPoint).pipe(
      map(response => {
        const clientes = response as Cliente[];
        return clientes.map(cliente => {
          cliente.nombre = cliente.nombre.toUpperCase();
          //cliente.createdAt = formatDate(cliente.createdAt, 'EEEE dd, MMMM yyyy', 'es-ES');
          return cliente;
        });
      })
    );
  }

  create(cliente: Cliente): Observable<Cliente>{
    return this._http.post<Cliente>(this.urlEndPoint, cliente, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        if (e.status == 400){
          return throwError(e);
        }
        Swal.fire('Error al crear', e.error , 'error');
        return throwError(e);
      })
    );
  }

  getCliente(id: number): Observable<Cliente>{
    return this._http.get<Cliente>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        this._router.navigate(['/clientes']);
        Swal.fire('Error al editar', e.error , 'error');
        return throwError(e);
      })
    );
  }

  update(cliente: Cliente): Observable<Cliente>{
    return this._http.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`, cliente, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        if (e.status == 400){
          return throwError(e);
        }
        Swal.fire('Error al editar', e.error , 'error');
        return throwError(e);
      })
    );
  }

  delete(id: number): Observable<Cliente>{
    return this._http.delete<Cliente>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        this._router.navigate(['/clientes']);
        Swal.fire('Error al eliminar', e.error , 'error');
        return throwError(e);
      })
    )
    ;
  }
}
