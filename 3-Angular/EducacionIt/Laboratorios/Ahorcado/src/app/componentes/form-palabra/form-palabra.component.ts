import { ALTA } from './../../constantes';
import { LoggerService } from './../../servicios/logger.service';
import { AhorcadoService } from './../../servicios/ahorcado.service';
import { Genero } from './../../entities/genero';
import { Palabra } from './../../entities/palabra';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Dificultad } from 'src/app/entities/dificultad';

@Component({
  selector: 'app-form-palabra',
  templateUrl: './form-palabra.component.html'
})
export class FormPalabraComponent implements OnInit {
  @Input()
  modo: string;
  @Input()
  palabra: Palabra;

  @Output()
  resultado: EventEmitter<any> = new EventEmitter();

  generos: Array<Genero>;
  dificultades: Array<Dificultad>;
  minimo: number;
  maximo: number;

  constructor(private _ahorcadoService: AhorcadoService) {}

  ngOnInit(): void {
    if (this.modo === 'A') {
      this.palabra = {
        id: null,
        idDificultad: null,
        idGenero: null,
        texto: '',
        pista: ''
      };
    }

    this._ahorcadoService.getDificultades()
      .subscribe(data => {
        this.dificultades = data;
        this._ahorcadoService.getGeneros()
          .subscribe(data2 => this.generos = data2);
      });
  }

  submit() {
    if (this.modo === ALTA){
      this._ahorcadoService.addPalabra(this.palabra).subscribe(
        (data) => {
          this.resultado.emit(true);
        },
        (error) => alert(`Se produjo un error: ${error.message}`)
      );
    }
    console.log(this.palabra);
  }

  cambioDificultad() {
    if (this.palabra.idDificultad !== 0) {
      const dificultad = this.dificultades.find(x => x.id == this.palabra.idDificultad);
      if (dificultad) {
        this.minimo = dificultad.min;
        this.maximo = dificultad.max;
      } else {
        this.minimo = 0;
        this.maximo = 9999;
      }
    }
  }
}
