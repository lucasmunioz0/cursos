import { EstadoPedido } from './estados/estadoPedido';
import { DetallePedido } from './detalle-pedido';
import { Titular } from './titular';
import { Mozo } from './mozo';
import { Mesa } from './mesa';
export class Pedido {
  public fecha: Date;
  constructor(
    public mesas: Array<Mesa>,
    public mozo: Mozo,
    public comensales: number,
    public titular: Titular,
    public detalles: Array<DetallePedido>,
    public estado: EstadoPedido
  ) {
    this.fecha = new Date();
  }

  obtenerTotal(): number {
    let total = 0;
    this.detalles.forEach(detalle => {
      total += detalle.subTotal;
    });
    return total;
  }
}
