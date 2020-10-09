import { Component } from '@angular/core';

class Alumno{
  nombre: string;
  apellido: string;
  curso: string;

  constructor(nombre: string, apellido: string, curso: string){
    this.nombre = nombre;
    this.apellido = apellido;
    this.curso = curso;
  }
}

const ALUMNOS = [
  new Alumno('Lucas', 'Muñoz', 'Angular'),
  new Alumno('Matias', 'Gonzales', 'PHP'),
  new Alumno('Maria', 'Castro', 'C#'),
  new Alumno('Ana', 'Gomez', 'C++')
];

@Component({
  selector: 'app-home',
  templateUrl: './home.template.html',
  styleUrls: ['./home.style.css']
})
export class HomeComponent{
  titulo = 'Hola como estas?';
  alumnos: Alumno[] = ALUMNOS;
  detalle: string = '';
  alumnoSeleccionado: Alumno;

  mostrarDetalle(i: number){
      this.detalle = `${this.alumnos[i].nombre}, ${this.alumnos[i].apellido} estudia: ${this.alumnos[i].curso}`;
  }

  mostrarDetalleAlumno(alumno: Alumno){
    this.detalle = `${alumno.nombre}, ${alumno.apellido} estudia: ${alumno.curso}`;
    this.alumnoSeleccionado = alumno;
  }

  cerrarModal(){
    this.alumnoSeleccionado = null;
  }
}
