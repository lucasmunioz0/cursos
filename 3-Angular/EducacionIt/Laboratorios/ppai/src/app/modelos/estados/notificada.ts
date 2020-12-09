import { Confirmada } from './confirmada';
import { Anulada } from './anulada';
import { Reserva } from './../reserva';
import { Estado } from './estado';

export class Notificada extends Estado{
  constructor(reserva: Reserva){
    super('', 'Notificada', reserva);
  }

  anular(){
    const anulada = new Anulada(this.reserva);
    this.reserva.setEstado(anulada);
  }

  confirmar(){
    const confirmada = new Confirmada(this.reserva);
    this.reserva.setEstado(confirmada);
  }

  esNotificada(): boolean{
    return true;
  }
}

