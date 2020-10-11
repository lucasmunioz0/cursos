import { NivelComponenteService } from './../../servicios/nivel-componente.service';
import { NivelModuloService } from './../../servicios/nivel-modulo.service';
import { OtroServicioService } from './../../servicios/otro-servicio.service';
import { LoggerService } from './../../servicios/logger.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  providers: [NivelComponenteService]
})
export class PrincipalComponent implements OnInit {

  constructor(
    private _logger: LoggerService,
    private _otroServicio: OtroServicioService,
    private _nivelModulo: NivelModuloService,
    private _nivelComponente: NivelComponenteService) { }

  ngOnInit(): void {
    this._logger.info('Entro al ngOnInit()');
    this._otroServicio.saludar('Hola mundo');
    this._nivelModulo.saludar('Desde otro modulo');
    this._nivelComponente.saludar('Desde el componente');
    console.dir(this._nivelComponente);
  }

}
