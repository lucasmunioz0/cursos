import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-click-me',
  templateUrl: './click-me.component.html'
})
export class ClickMeComponent implements OnInit {
  mensaje: string;

  constructor() { }

  ngOnInit(): void {
  }

  hicisteClick(){
    this.mensaje = 'Hola, que bueno verte';
  }

}
