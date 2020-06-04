import { Component, OnInit } from '@angular/core';
import { Persona } from '../persona.model';
import { PersonaService } from '../persona-service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styles: [
  ],
})
export class PersonasComponent implements OnInit {

  private personas: Persona[] = [];

  constructor(private personaService: PersonaService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.personaService.obtenerPersonas()
    .subscribe(
      (personas: Persona[]) => {
        //Cargamos los datos de persona obtenidos en el arreglo local
        this.personas = personas;
        this.personaService.setPersonas(this.personas);
        console.log('Personas obtenidas del subscriber: ' + this.personas);
      }
    );
  }

}
