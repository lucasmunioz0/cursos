import { EgresoService } from './../../servicios/egreso.service';
import { Egreso } from './../../entidades/egreso';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-egreso',
  templateUrl: './egreso.component.html',
  styles: [
  ]
})
export class EgresoComponent implements OnInit {

  egresos: Egreso[];
  @Input() ingresoTotal: number;

  constructor(private _egresoSvc: EgresoService) { }

  ngOnInit(): void {
    this.egresos = this._egresoSvc.egresos;
  }

  eliminarRegistro(egreso: Egreso) {
    this._egresoSvc.eliminarEgreso(egreso);
  }

  calcularPorcentaje(egreso: Egreso) {
    return egreso.valor / this.ingresoTotal;
  }

}
