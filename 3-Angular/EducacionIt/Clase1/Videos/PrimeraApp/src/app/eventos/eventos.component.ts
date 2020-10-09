import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-eventos',
  templateUrl: './eventos.template.html'
})
export class EventoComponent implements OnInit{
  mensaje: string;
  valorUno: string = '';
  valorDos: string = '';

  constructor(){

  }

  ngOnInit(){

  }

  hicisteClick(): void{
    this.mensaje = 'Hola Mundo';
  }

  onKey(event: any): void{
    this.valorUno += event.target.value + ' -- ';
  }

  validar(event: KeyboardEvent){
    this.valorDos += (event.target as HTMLInputElement).value + ' -- ';
  }
}
