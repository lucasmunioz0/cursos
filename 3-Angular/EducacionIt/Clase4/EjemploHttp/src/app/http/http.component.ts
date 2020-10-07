import { RestService } from './../rest.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subscriber } from 'rxjs';
import { Usuario } from '../usuario';

@Component({
  selector: 'app-http',
  templateUrl: './http.component.html'
})
export class HttpComponent implements OnInit {

  constructor(private client: HttpClient, private _servicio: RestService) { }

  public usuario: Usuario;
  public usuarios: Usuario[];

  ngOnInit(): void {
    this.client.get<Usuario>("http://localhost:3000/usuario/1")
    .subscribe(
      (data) => {this.usuario = data; },
      (error) => {console.log("Hubo un error: " + error); },
      () => {console.log("termino"); }
    );

    this._servicio.getUsuarios()
    .subscribe(
      (data) => {
        this.usuarios = data;
      }
    );

    this._servicio.getUsuariosById(3)
    .subscribe(
      (data) => {
        if (data.codigo != ""){
          this.usuario = data;
        }else{
          this.usuario = {id: 0, codigo: "", permiso: ""}
          //no mostrar usuario
        }
        },
      (error) => {console.log("Hubo un error: " + error); }
    );
  }

}
