import { CONFIG, APP_CONFIG } from './../../config';
import { NivelComponenteService } from './../../servicios/nivel-componente.service';
import { Component, Inject, OnInit, Optional } from '@angular/core';

@Component({
  selector: 'app-secundario',
  templateUrl: './secundario.component.html'
})
export class SecundarioComponent implements OnInit {

  constructor(
    @Optional() private _nivelComponente: NivelComponenteService,
    @Inject(CONFIG) private _config) { }

  ngOnInit(): void {
    if (this._nivelComponente != null) {
      this._nivelComponente.saludar('Componente secundario');
    }
  }

  get config(){
    return JSON.parse(JSON.stringify(this._config));
  }

}
