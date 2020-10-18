import { AutoService } from './../servicios/auto.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dependencias',
  templateUrl: './dependencias.component.html'
})
export class DependenciasComponent implements OnInit {
  mensajeString: string;

  constructor(@Optional() private autoService: AutoService) { }

  ngOnInit(): void {
  }

  get mensaje(){
    console.log(this.autoService.drive());
    return this.autoService.drive();
  }

}
