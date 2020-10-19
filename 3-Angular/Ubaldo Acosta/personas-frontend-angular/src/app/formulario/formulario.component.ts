import { PersonaService } from './../services/persona-service.service';
import { LogginService } from './../services/LoggingService.service';
import { Persona } from './../entidades/persona';
import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html'
})
export class FormularioComponent implements OnInit {

  // @ViewChild('nombre') nombre: ElementRef;
  // @ViewChild('apellido') apellido: ElementRef;

  nombre: string;
  apellido: string;

  constructor(private _personaSvc: PersonaService) {
    this._personaSvc.saludar.subscribe(
      (index: number) => {
        alert('La persona seleccionada es: ' + index);
      }
    );
  }

  ngOnInit(): void {
  }

  onAgregarPersona(){
    // const persona = new Persona(this.nombre.nativeElement.value , this.apellido.nativeElement.value);
    const persona = new Persona(this.nombre, this.apellido);
    this._personaSvc.agregarPersona(persona);
  }
}
