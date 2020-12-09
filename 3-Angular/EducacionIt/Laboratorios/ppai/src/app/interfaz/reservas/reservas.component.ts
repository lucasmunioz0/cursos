import { ReservasService } from './../../servicios/reservas.service';
import { GeneradorWhatsApp } from './../../modelos/generador-whats-app';
import { Reserva } from './../../modelos/reserva';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html'
})
export class ReservasComponent implements OnInit {
  public reservas: Array<Reserva>;
  public mensajesEnviados: Array<string>;

  constructor(private _reservasService: ReservasService) { }

  ngOnInit(): void {
    this.reservas = this._reservasService.obtenerReservas();
    this.mensajesEnviados = new Array();
  }

  enviarRecordatorios() {
    this.mensajesEnviados = new Array();
    const fechaActual = new Date();
    const generador = new GeneradorWhatsApp();
    let timer = 1000;
    this.reservas.forEach(reserva => {
      timer += 1000;
      setTimeout(() => {
        if (reserva.coincideFechaReservaConActual(fechaActual)) {
          if (reserva.esNoConfirmada()) {
            this.mensajesEnviados.push(
              generador.enviarRecordatorio(reserva.getFecha(), reserva.cliente, reserva.mesa, reserva.comensales));
            reserva.notificar();
          }
        }
      }, timer);
    });
  }

}
