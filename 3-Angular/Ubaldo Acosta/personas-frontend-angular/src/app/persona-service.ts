import { Injectable } from '@angular/core';
import { Persona } from './persona.model';
import { DataService } from './data-service';

@Injectable()
export class PersonaService {
  private personas: Persona[] = [];

  constructor(private dataService: DataService) {

  }

  //Se usa para modificar el valor del arreglo devido a la llamada asíncrona.
  setPersonas(personas: Persona[]) {
    this.personas = personas;
  }

  agregarPersona(persona: Persona) {
    console.log('Persona a agregar: ' + persona.nombre);
    this.dataService.agregarPersona(persona)
      .subscribe(
        (persona: Persona) => {
          //Recuperamos el objeto persona con el IdPersona recién agregado.
          console.log('Se agrega al arreglo la persona recién insertada suscriber: ' + persona.nombre + ', ' + persona.idPersona);
          this.personas.push(persona);
        },
        (error) => console.log('Error agregando la persona ' + error)
      );
  }

  encontrarPersona(idPersona: number) {
    const persona: Persona = this.personas.find(persona => persona.idPersona == idPersona);
    console.log('Persona encontrada: (' + persona.idPersona + ') ' + persona.nombre);
    return persona;
  }

  modificarPersona(idPersona: number, persona: Persona) {
    console.log('Persona a modificar: ' + persona.nombre + ', ' + persona.idPersona);
    this.dataService.modificarPersona(idPersona, persona);
  }

  eliminarPersona(idPersona: number){
    console.log('Eliminar persona con Id: ' + idPersona);
    const index = this.personas.findIndex(persona => persona.idPersona == idPersona); //Encontramos el índice en el arreglo.
    this.personas.splice(index, 1);
    this.dataService.eliminarPersona(idPersona);
  }

  obtenerPersonas(){
    return this.dataService.cargarPersonas();
  }
}
