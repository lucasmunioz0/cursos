import { Cancelada } from './cancelada';
import { Reserva } from './../reserva';
import { Estado } from './estado';

export class Confirmada extends Estado{
  constructor(reserva: Reserva){
    super('', 'Confirmada', reserva);
  }

  esConfirmada(): boolean{
    return true;
  }

  cancelar(){
    const cancelar = new Cancelada(this.reserva);
    this.reserva.setEstado(cancelar);
  }
}
