import { IngresoService } from './../../servicios/ingreso.service';
import { Ingreso } from './../../entidades/ingreso';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-ingreso',
  templateUrl: './ingreso.component.html',
  styles: []
})
export class IngresoComponent implements OnInit {

  ingresos: Ingreso[] = [];

  constructor(private _ingresoSvc: IngresoService) { }

  ngOnInit() {
    this.ingresos = this._ingresoSvc.ingresos;
  }

  eliminarRegistro(ingreso: Ingreso){
    this._ingresoSvc.eliminarIngreso(ingreso);
  }

}
