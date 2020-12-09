import { GeneradorWhatsApp } from './../generador-whats-app';
import { Reserva } from './../reserva';
export abstract class Estado {
  constructor(protected ambito: string, protected nombre: string, protected reserva: Reserva ){}

  anular(){}
  cancelar(){}
  confirmar(){}
  cumplimentar(){}
  demorar(){}
  esAnulada(): boolean{ return false; }
  esCancelada(): boolean{ return false; }
  esConfirmada(): boolean{ return false; }
  esCreada(): boolean{ return false; }
  esCumplimentada(): boolean{ return false; }
  esDemorada(): boolean{ return false; }
  esNoConfirmada(): boolean{ return false; }
  esNotificada(): boolean{ return false; }
  notificar(){}
}
