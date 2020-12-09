import { ProductoService } from './../services/producto.service';
import { Pedido } from './../models/pedido';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-confirmar-pedido',
  templateUrl: './confirmar-pedido.component.html'
})
export class ConfirmarPedidoComponent implements OnInit {

  @Input()
  pedido: Pedido;
  confirmar = false;

  constructor() {}
  ngOnInit() {}

  confirmarPedido() {}

}
