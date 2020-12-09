import { GeneradorWhatsApp } from './../generador-whats-app';
import { Notificada } from './notificada';
import { Cancelada } from './cancelada';
import { Reserva } from './../reserva';
import { Estado } from './estado';

export class Creada extends Estado{
  constructor(reserva: Reserva){
    super('', 'Creada', reserva);
  }

  esCreada(): boolean{
    return true;
  }

  cancelar(){
    const cancelar = new Cancelada(this.reserva);
    this.reserva.setEstado(cancelar);
  }

  notificar(){
    const notificada = new Notificada(this.reserva);
    this.reserva.setEstado(notificada);
  }
}
