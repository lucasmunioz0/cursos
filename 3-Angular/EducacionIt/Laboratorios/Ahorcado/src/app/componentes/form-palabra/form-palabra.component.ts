import { LoggerService } from './../../servicios/logger.service';
import { AhorcadoService } from './../../servicios/ahorcado.service';
import { Genero } from './../../entities/genero';
import { Palabra } from './../../entities/palabra';
import { Component, OnInit } from '@angular/core';
import { Dificultad } from 'src/app/entities/dificultad';

@Component({
  selector: 'app-form-palabra',
  templateUrl: './form-palabra.component.html'
})
export class FormPalabraComponent implements OnInit {
  palabra: Palabra;
  generos: Array<Genero>;
  dificultades: Array<Dificultad>;
  minimo: number;
  maximo: number;

  constructor(private _ahorcadoService: AhorcadoService) {}

  ngOnInit(): void {
    this.palabra = {
      codigo: '',
      idDificultad: null,
      idGenero: null,
      texto: '',
      pista: ''
    };

    this._ahorcadoService.getDificultades()
      .subscribe(data => {
        this.dificultades = data;
        this._ahorcadoService.getGeneros()
          .subscribe(data2 => this.generos = data2);
      });
  }

  submit(){
    console.log(this.palabra);
  }

  cambioDificultad(){
    if (this.palabra.idDificultad !== 0){
      const dificultad = this.dificultades.find(x => x.id == this.palabra.idDificultad);
      if (dificultad){
        this.minimo = dificultad.min;
        this.maximo = dificultad.max;
      }else{
        this.minimo = 0;
        this.maximo = 9999;
      }
    }
  }
}
