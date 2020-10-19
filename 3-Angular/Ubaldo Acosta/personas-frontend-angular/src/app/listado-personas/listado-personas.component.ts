import { PersonaService } from './../services/persona-service.service';
import { LogginService } from './../services/LoggingService.service';
import { Persona } from './../entidades/persona';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listado-personas',
  templateUrl: './listado-personas.component.html'
})
export class ListadoPersonasComponent implements OnInit{

  personas: Persona[];

  constructor(private _personaSvc: PersonaService){}

  ngOnInit(){
    this.personas = this._personaSvc.personas;
  }
}
