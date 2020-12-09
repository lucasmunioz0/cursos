import { Reserva } from './../reserva';
import { Estado } from './estado';

export class Anulada extends Estado{
  constructor(reserva: Reserva){
    super('', 'Anulada', reserva);
  }

  esAnulada(): boolean{
    return true;
  }
}
