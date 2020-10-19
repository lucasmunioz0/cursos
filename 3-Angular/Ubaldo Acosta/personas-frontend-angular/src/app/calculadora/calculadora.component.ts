import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styles: [
  ],
})
export class CalculadoraComponent {
  resultado: number;

  onResultado(resultado: number){
    this.resultado = resultado;
  }

}
