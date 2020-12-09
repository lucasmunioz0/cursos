import { Estado } from './estados/estado';

export class Reserva {
  private fecha: Date;
  private estado: Estado;
  constructor(public cliente: string, public mesa: string, public comensales: number) {
    this.fecha = new Date();
  }

  getFecha(): Date {
    return this.fecha;
  }

  getEstado(): Estado {
    return this.estado;
  }

  setEstado(estado: Estado) {
    this.estado = estado;
  }

  esNoConfirmada(): boolean {
    return this.estado.esNoConfirmada();
  }

  notificar() {
    this.estado.notificar();
  }

  coincideFechaReservaConActual(fecha: Date) {
    if (fecha.getDate() === this.fecha.getDate() &&
      fecha.getMonth() === this.fecha.getMonth() &&
      fecha.getFullYear() === this.fecha.getFullYear()) {
      return true;
    }
    return false;
  }
}
