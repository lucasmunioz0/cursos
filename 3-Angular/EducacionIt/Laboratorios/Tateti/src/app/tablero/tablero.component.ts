import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tablero',
  templateUrl: './tablero.component.html'
})
export class TableroComponent implements OnInit {

  tablero: string[][];

  constructor() { }

  ngOnInit(): void {
  }

  celdaClick(fila: number, columna: number){
    
  }

}
