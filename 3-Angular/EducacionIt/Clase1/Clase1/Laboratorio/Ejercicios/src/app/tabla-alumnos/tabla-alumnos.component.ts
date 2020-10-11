import { Component, OnInit } from '@angular/core';
import { Alumno } from '../alumno';

@Component({
  selector: 'app-tabla-alumnos',
  templateUrl: './tabla-alumnos.component.html'
})
export class TablaAlumnosComponent implements OnInit {
  alumnos: Array<Alumno>;
  alumnoSeleccionado: Alumno;

  constructor() {
    this.alumnos = new Array<Alumno>();
    this.alumnos.push({nombre: 'Jose', apellido: 'Castro', edad: 25});
    this.alumnos.push({nombre: 'Matias', apellido: 'Gomez', edad: 18});
    this.alumnos.push({nombre: 'Lucas', apellido: 'Morenos', edad: 42});
    this.alumnos.push({nombre: 'Maria', apellido: 'Gimenez', edad: 60});
    this.alumnos.push({nombre: 'Josefina', apellido: 'Alfa', edad: 32});
    this.alumnos.push({nombre: 'Carla', apellido: 'Beta', edad: 40});
  }

  ngOnInit(): void {}

  seleccionarAlumno(alumno: Alumno){
    this.alumnoSeleccionado = alumno;
  }

}
