import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { validadorTelefono } from './validadorTelefono';

@Component({
  selector: 'app-custom-validator',
  templateUrl: './custom-validator.component.html'
})
export class CustomValidatorComponent implements OnInit {

  formulario = new FormGroup({
    nombre: new FormControl('', [Validators.required, Validators.minLength(4)]),
    apellido: new FormControl('', [Validators.required]),
    telefono: new FormControl('', [Validators.required, validadorTelefono(/^[456]{1}[0-9]{9}$/)])
  });

  constructor() { }

  ngOnInit(): void {
  }

  registrar(): void{
    console.log(this.formulario.value);
  }

  get nombre(){ return this.formulario.get('nombre'); }
  get apellido(){ return this.formulario.get('apellido'); }
  get telefono(){ return this.formulario.get('telefono'); }

}
