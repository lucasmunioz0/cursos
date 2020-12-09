import { Pedido } from './../models/pedido';
import { ProductoService } from './../services/producto.service';
import { DetallePedido } from './../models/detalle-pedido';
import { Producto } from './../models/producto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html'
})
export class PedidoComponent implements OnInit {

  productos: Array<Producto>;
  detalles: Array<DetallePedido>;
  confirmar = false;
  pedido: Pedido;

  constructor(public _productoService: ProductoService) {}
  ngOnInit() {
    this.productos = this._productoService.getAll();
    this.detalles = new Array<DetallePedido>();
  }

  filtrarProductos(input) {
    if (input.value == "") {
      this.productos = this._productoService.getAll();
    } else {
      this.productos = this._productoService.filtrar(input.value);
    }
  }

  agregarProducto(input, producto) {
    if (input.value > 0) {
      let detalle: DetallePedido = {
        id: this.detalles.length + 1,
        cantidad: input.value,
        producto: producto,
        subTotal: input.value * producto.precio
      };
      this.detalles.push(detalle);
      input.value = "";
    }
  }

  eliminarDetalle(detalle) {
    if (this.detalles.includes(detalle)) {
      this.detalles.splice(this.detalles.indexOf(detalle), 1);
    }
  }

  crearPedido() {
    if (this.detalles.length > 0) {
      this.pedido = new Pedido(null, null, 1, null, this.detalles, null);
    }
  }

}
