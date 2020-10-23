import { EjemploService } from './../../services/ejemplo.service';
import { IEjemplo } from './../../interfaces/iejemplo';
import { ComponentBase } from './../../interfaces/icomponent';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ejemplo',
  templateUrl: './ejemplo.component.html',
  providers: [EjemploService]
})
export class EjemploComponent extends ComponentBase<IEjemplo> implements OnInit {

  constructor(private _ejemploSvc: EjemploService) {
    super();
  }

  ngOnInit(): void {
  }

}
