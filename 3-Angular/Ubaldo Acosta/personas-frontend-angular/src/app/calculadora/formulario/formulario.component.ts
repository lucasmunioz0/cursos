import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-calculadora-formulario',
  templateUrl: './formulario.component.html',
  styles: [
  ],
})
export class CalculadoraFormularioComponent implements OnInit {
  operandoA: number;
  operandoB: number;

  @Output() resultado: EventEmitter<number> = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  onSumar(){
    this.resultado.emit(this.operandoA + this.operandoB);
  }
}
