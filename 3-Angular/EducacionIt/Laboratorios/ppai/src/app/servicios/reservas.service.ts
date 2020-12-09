import { Anulada } from './../modelos/estados/anulada';
import { Reserva } from './../modelos/reserva';
import { Injectable } from '@angular/core';
import { __spreadArrays } from 'tslib';
import { Estado } from '../modelos/estados/estado';
import { NoConfirmada } from '../modelos/estados/no-confirmada';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {

  constructor() { }

  obtenerReservas(){
    const reservas = new Array<Reserva>();
    const reserva0 = new Reserva('Cliente 1', 'Mesa 1' , 2);
    reserva0.setEstado(new Anulada(reserva0));
    const reserva1 = new Reserva('Cliente 1', 'Mesa 1' , 2);
    reserva1.setEstado(new NoConfirmada(reserva1));
    const reserva2 = new Reserva('Cliente 2', 'Mesa 2' , 3);
    reserva2.setEstado(new NoConfirmada(reserva2));
    const reserva3 = new Reserva('Cliente 3', 'Mesa 3' , 4);
    reserva3.setEstado(new NoConfirmada(reserva3));
    const reserva4 = new Reserva('Cliente 4', 'Mesa 4' , 2);
    reserva4.setEstado(new NoConfirmada(reserva4));
    const reserva5 = new Reserva('Cliente 5', 'Mesa 5' , 3);
    reserva5.setEstado(new NoConfirmada(reserva5));
    const reserva6 = new Reserva('Cliente 6', 'Mesa 6' , 4);
    reserva6.setEstado(new NoConfirmada(reserva6));
    reservas.push(reserva0);
    reservas.push(reserva1);
    reservas.push(reserva2);
    reservas.push(reserva3);
    reservas.push(reserva4);
    reservas.push(reserva5);
    reservas.push(reserva6);

    return reservas;
  }
}
