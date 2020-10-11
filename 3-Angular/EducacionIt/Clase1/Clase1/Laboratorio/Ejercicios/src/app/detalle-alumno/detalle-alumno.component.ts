import { Alumno } from './../alumno';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-detalle-alumno',
  templateUrl: './detalle-alumno.component.html'
})
export class DetalleAlumnoComponent implements OnInit {

  @Input()
  public alumnoSeleccionado: Alumno;

  constructor() { }

  ngOnInit(): void {
  }

}
