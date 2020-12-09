import { Cancelada } from './cancelada';
import { Reserva } from './../reserva';
import { Estado } from './estado';

export class Demorada extends Estado{
  constructor(reserva: Reserva){
    super('', 'Demorada', reserva);
  }

  esDemorada(): boolean{
    return true;
  }

  cancelar(){
    const cancelar = new Cancelada(this.reserva);
    this.reserva.setEstado(cancelar);
  }
}
