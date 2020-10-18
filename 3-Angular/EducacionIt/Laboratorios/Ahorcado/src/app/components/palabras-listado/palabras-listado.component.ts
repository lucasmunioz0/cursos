import { MODIFICAR, ALTA } from './../../constantes';
import { Palabra } from './../../entities/palabra';
import { Component, OnInit } from '@angular/core';
import { AhorcadoService } from 'src/app/servicios/ahorcado.service';

@Component({
  selector: 'app-palabras-listado',
  templateUrl: './palabras-listado.component.html'
})
export class PalabrasListadoComponent implements OnInit {

  palabras: Array<Palabra>;
  palabraSeleccionada: Palabra;
  modo: string;
  error: string;
  message = '';

  constructor(private _ahorcadoSvc: AhorcadoService) {
    console.log('constructor');
   }

  ngOnInit(): void {
    console.log('inicializando...');
    this._ahorcadoSvc.getPalabras().subscribe(
      (data) => this.palabras = data,
      (error) => this.error = error
    );
    this.palabraSeleccionada = null;
    this.modo = null;
  }

  editarPalabra(id: number){
    this.modo = MODIFICAR;
    this._ahorcadoSvc.getPalabra(id).subscribe(
      (data) => this.palabraSeleccionada = data,
      (error) => this.error = error
    );
  }

  eliminarPalabra(id: number){
    this._ahorcadoSvc.deletePalabra(id).subscribe(
      (data) => {
        if (data){
          console.log('Eliminado con éxito');
        }
      },
      (error) => {
        this.error = error;
      }
    );
  }

  agregarPalabra(){
    this.modo = ALTA;
  }

  resultado(event){
    console.log(event);
    this.message = event;
  }

}
