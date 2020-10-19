import { EgresoService } from './servicios/egreso.service';
import { IngresoService } from './servicios/ingreso.service';
import { Egreso } from './entidades/egreso';
import { Ingreso } from './entidades/ingreso';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'presupuesto-app';

  ingresos: Ingreso[] = [];
  egresos: Egreso[] = [];

  constructor(private _ingresoSvc: IngresoService, private _egresoSvc: EgresoService) {
    this.ingresos = this._ingresoSvc.ingresos;
    this.egresos = this._egresoSvc.egresos;
  }

  getIngresoTotal() {
    let ingresoTotal = 0;
    this.ingresos.forEach( ingreso => ingresoTotal += ingreso.valor);
    return ingresoTotal;
  }

  getEgresoTotal() {
    let egresoTotal = 0;
    this.egresos.forEach( egreso => egresoTotal += egreso.valor);
    return egresoTotal;
  }

  getPorcentajeTotal() {
    return this.getEgresoTotal() / this.getIngresoTotal();
  }

  getPresupuestoTotal() {
    return this.getIngresoTotal() - this.getEgresoTotal();
  }
}
