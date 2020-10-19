import { LogginService } from './LoggingService.service';
import { Persona } from './../entidades/persona';
import { EventEmitter, Injectable } from '@angular/core';

@Injectable()
export class PersonaService {
  personas: Persona[] = [
    new Persona('Lucas', 'Muñoz'),
    new Persona('Maria', 'Laura')
  ];

  saludar = new EventEmitter<number>();

  constructor(private _logginSvc: LogginService) { }

  agregarPersona(persona: Persona) {
    this._logginSvc.log(`Persona agregada: ${JSON.stringify(persona)}`);
    this.personas.push(persona);
  }
}
