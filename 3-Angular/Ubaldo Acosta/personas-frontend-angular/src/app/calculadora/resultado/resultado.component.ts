import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora-resultado',
  templateUrl: './resultado.component.html',
  styles: [
  ],
})
export class ResultadoComponent implements OnInit {

  @Input() resultado: number;

  constructor() { }

  ngOnInit(): void {
  }

}
