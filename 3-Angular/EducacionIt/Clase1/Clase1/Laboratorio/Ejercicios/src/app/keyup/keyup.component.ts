import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-keyup',
  templateUrl: './keyup.component.html'
})
export class KeyupComponent implements OnInit {
  key: string;
  keyBoard: string;
  textoIngresado: string;

  constructor() { }

  ngOnInit(): void {
  }

  onKey(event: any){
    this.key += event.key;
  }

  onKeyBoard(event: KeyboardEvent){
    this.keyBoard += event.key;
  }

  mostrarTexto(texto: string){
    this.textoIngresado = texto;
  }
}
