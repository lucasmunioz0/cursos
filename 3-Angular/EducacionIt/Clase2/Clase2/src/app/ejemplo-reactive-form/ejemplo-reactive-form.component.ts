import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-ejemplo-reactive-form',
  templateUrl: './ejemplo-reactive-form.component.html'
})
export class EjemploReactiveFormComponent implements OnInit {

  formulario = new FormGroup({
    nombreUsuario: new FormControl('', Validators.required),
    codigoUsuario: new FormControl(''),
    email: new FormControl('', Validators.email),
    password: new FormControl('')
  });

  constructor() { }

  ngOnInit(): void {
    // this.formulario.controls.nombreUsuario.setValue('Lucas Muñoz');
    this.formulario.get('nombreUsuario').setValue('Lucas Muñoz');
  }

  registrar(){
    console.log(this.formulario.valid);
    console.log(this.formulario.value);
  }

  cancelar(){
    this.formulario.setValue({
      nombreUsuario: '',
      codigoUsuario: '',
      email: '',
      password: ''
    });
  }

}
