import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { validarTelefono } from './customValidator';

@Component({
  selector: 'app-custom-validator',
  templateUrl: './custom-validator.component.html'
})
export class CustomValidatorComponent implements OnInit {

  formulario = new FormGroup({
    nombre: new FormControl('', [Validators.required, Validators.minLength(4)]),
    apellido: new FormControl('', Validators.required),
    telefono: new FormControl('', [Validators.required, validarTelefono(/^[456]{1}[0-9]{9}$/)]),
  });
  hidden = true;

  constructor() { }

  ngOnInit(): void {
  }

  submit(){
    this.hidden = false;
  }

  get nombre(){ return this.formulario.get('nombre'); }
  get apellido(){ return this.formulario.get('apellido'); }
  get telefono(){ return this.formulario.get('telefono'); }

}
