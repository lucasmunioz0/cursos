import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Persona } from './persona.model';

@Injectable()
export class DataService {
  private urlBase = "http://localhost:8080/personas-backend-java/webservice/personas";

  constructor(private httpClient: HttpClient) {
  }

  cargarPersonas() {
    return this.httpClient.get(this.urlBase);
  }

  agregarPersona(persona: Persona) {
    return this.httpClient.post(this.urlBase, persona);
  }

  modificarPersona(idPersona: number, persona: Persona) {
    let url: string;
    url = this.urlBase + "/" + idPersona;

    this.httpClient.put(url, persona)
      .subscribe(
        (response) => {
          console.log('Resultado de modificar persona: ' + response);
        },
        (error) => console.log('Error en modificar persona: ' + error)
      );
  }

  eliminarPersona(idPersona: number) {
    let url: string;
    url = this.urlBase + "/" + idPersona;

    this.httpClient.delete(url)
      .subscribe(
        (response) => {
          console.log('Resultado de eliminar persona: ' + response);
        },
        (error) => console.log('Error eliminando persona: ' + error)
      );
  }
}
