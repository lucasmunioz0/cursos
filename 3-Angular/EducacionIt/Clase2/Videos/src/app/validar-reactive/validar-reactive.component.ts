import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { validadorTelefono } from '../custom-validator/validadorTelefono';

@Component({
  selector: 'app-validar-reactive',
  templateUrl: './validar-reactive.component.html'
})
export class ValidarReactiveComponent implements OnInit {

  registroForm = new FormGroup({
    nombre: new FormControl('Lucas', [Validators.minLength(3), Validators.maxLength(5), Validators.required]),
    apellido: new FormControl('', [Validators.required, Validators.minLength(3)]),
    email: new FormControl('', [Validators.required, validadorTelefono(/^[456]{1}[0-9]{9}$/)])
  });

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.registroForm.value);
  }
}
