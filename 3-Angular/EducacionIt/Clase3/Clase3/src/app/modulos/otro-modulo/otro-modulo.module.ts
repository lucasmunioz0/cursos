import { NivelComponenteService } from './../../servicios/nivel-componente.service';
import { NivelModuloService } from './../../servicios/nivel-modulo.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    NivelModuloService,
    NivelComponenteService
  ]
})
export class OtroModuloModule { }
