import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-driven',
  templateUrl: './driven.component.html'
})
export class DrivenComponent implements OnInit {

  form: any;

  constructor() { }

  ngOnInit(): void {
  }

  submit(formulario){
    this.form = formulario;
  }

}
