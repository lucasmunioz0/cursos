import { Producto } from './producto';
export interface DetallePedido {
  id: number;
  producto: Producto;
  cantidad: number;
  subTotal: number;
}

