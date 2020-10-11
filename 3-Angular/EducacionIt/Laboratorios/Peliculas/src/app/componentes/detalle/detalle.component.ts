import { Pelicula } from '../../entidades/Pelicula';
import { Component, Input, OnInit, Output,EventEmitter} from '@angular/core';
import { PeliculasService } from 'src/app/peliculas.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html'
})
export class DetalleComponent implements OnInit {
  @Input()
  idPelicula: number;
  pelicula: Pelicula;

  @Output()
  cancelar = new EventEmitter();

  constructor(private peliculasService: PeliculasService) { }

  ngOnInit(): void {
    this.peliculasService.buscarPelicula(this.idPelicula)
    .subscribe(data => this.pelicula = data);
  }

  cancelarEdicion(){
    this.cancelar.emit(false);
  }

  guardarCambios(){
    console.log('Datos a Enviar: ', this.pelicula);
  }



}
