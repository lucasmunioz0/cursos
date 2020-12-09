import { Reserva } from './../reserva';
import { Estado } from './estado';

export class Cumplimentada extends Estado{
  constructor(reserva: Reserva){
    super('', 'Cumplimentada', reserva);
  }

  esCumplimentada(): boolean{
    return true;
  }
}
