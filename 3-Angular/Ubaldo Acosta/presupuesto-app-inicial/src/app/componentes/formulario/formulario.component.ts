import { Egreso } from './../../entidades/egreso';
import { Ingreso } from './../../entidades/ingreso';
import { EgresoService } from './../../servicios/egreso.service';
import { IngresoService } from './../../servicios/ingreso.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styles: [
  ]
})
export class FormularioComponent implements OnInit {
  tipo = 'ingreso';
  descripcion: string;
  valor: number;

  constructor(private _ingresoSvc: IngresoService, private _egresoSvc: EgresoService) { }

  ngOnInit(): void {
  }

  tipoOperacion(event) {
    console.log(event);
    this.tipo = event.target.value;
    console.log(this.tipo);
  }

  agregar(form: FormGroup) {
    if (form.valid) {
      if (this.tipo == 'ingreso') {
        const ingreso = new Ingreso(this.descripcion, this.valor);
        this._ingresoSvc.agregarIngreso(ingreso);
      } else {
        const egreso = new Egreso(this.descripcion, this.valor);
        this._egresoSvc.agregarEgreso(egreso);
      }
    }

  }

}
