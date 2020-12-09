import { GeneradorWhatsApp } from './../generador-whats-app';
import { Notificada } from './notificada';
import { Reserva } from './../reserva';
import { Estado } from './estado';

export class NoConfirmada extends Estado{
  constructor(reserva: Reserva){
    super('', 'No Confirmada', reserva);
  }

  esNoConfirmada(): boolean{
    return true;
  }

  notificar(){
    const notificada = new Notificada(this.reserva);
    this.reserva.setEstado(notificada);
  }
}
