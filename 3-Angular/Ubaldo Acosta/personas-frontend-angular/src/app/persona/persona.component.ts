import { PersonaService } from './../services/persona-service.service';
import { Persona } from './../entidades/persona';
import { Component, EventEmitter, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styles: [
  ],
})
export class PersonaComponent implements OnInit {

  @Input() persona: Persona;
  @Input() index: number;


  constructor(private _personaSvc: PersonaService) { }

  ngOnInit(): void {
  }

  emitirSaludo(){
    this._personaSvc.saludar.emit(this.index);
  }

}
