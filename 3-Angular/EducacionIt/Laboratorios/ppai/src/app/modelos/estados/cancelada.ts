import { Reserva } from './../reserva';
import { Estado } from './estado';

export class Cancelada extends Estado{
  constructor(reserva: Reserva){
    super('', 'Cancelada', reserva);
  }

  esCancelada(): boolean{
    return true;
  }
}
