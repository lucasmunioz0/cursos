import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-cabecero',
  templateUrl: './cabecero.component.html'
})
export class CabeceroComponent implements OnInit {
  @Input() presupuesto: number;
  @Input() ingreso: number;
  @Input() egreso: number;
  @Input() porcentaje: number;

  constructor() { }

  ngOnInit() {
  }

}
