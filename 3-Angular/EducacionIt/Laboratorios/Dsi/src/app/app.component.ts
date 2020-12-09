import { TitularService } from './services/titular.service';
import { MesaService } from './services/mesa.service';
import { Mesa } from './models/mesa';
import { Titular } from './models/titular';
import { Mozo } from './models/mozo';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit{
  apertura = false;
  entity: Mozo;
  title = 'Pedidos';
  titulares: Titular[];
  titular: Titular;
  mesas: Array<Mesa>;
  mesasSeleccionadas: Array<Mesa>;
  mesa: Mesa;

  constructor(
    private _titularService: TitularService,
    private _mesaService: MesaService
  ) {
    this.entity = {
      id: 5,
      nombre: 'Lucas',
      apellido: 'Muñoz'
    };
    this.mesasSeleccionadas = new Array<Mesa>();
  }

  ngOnInit() {
    this.mesas = this._mesaService.getAll();
    this.titulares = this._titularService.getAll();
  }

  do() {}

  buscarTitular() {
    //this.titular = this._titularService.getByNombre(this.titularCadena);
  }

  buscarMesa(input) {
    if (input.value == "") {
      this.mesas = this._mesaService.getAll();
    } else {
      this.mesas = this._mesaService.filtrar(input.value);
    }
  }

  letraInsertada(letra) {
    this.titular = this._titularService.getByNombre(letra.value);
  }

  agregarMesa(mesa: Mesa) {
    if (this.mesasSeleccionadas.includes(mesa)) {
      this.mesasSeleccionadas.splice(this.mesasSeleccionadas.indexOf(mesa), 1);
    } else {
      this.mesasSeleccionadas.push(mesa);
    }
  }

  estaSeleccionada(mesa) {
    return !this.mesasSeleccionadas.includes(mesa);
  }

  mostrarConsola() {
    console.log("Hola Mundo");
    this.apertura = true;
  }
}
