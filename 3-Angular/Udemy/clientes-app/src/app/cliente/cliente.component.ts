import { ClienteService } from './cliente.service';
import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html'
})
export class ClienteComponent implements OnInit {

  clientes: Cliente[];

  constructor(private _clienteService: ClienteService) { }

  ngOnInit(): void {
    this._clienteService.getClientes().subscribe(
      (data) => this.clientes = data
    );
  }

  delete(cliente: Cliente): void {
    Swal.fire({
      title: '¿Está seguro?',
      text: `¿Seguro que desea eleiminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si'
    }).then((result) => {
      if (result.isConfirmed) {
        this._clienteService.delete(cliente.id).subscribe(
          response => {
            this.clientes = this.clientes.filter(cli => cli !== cliente);
            Swal.fire(
              'Borrado con éxito!',
              `El cliente ${cliente.nombre} fue eliminado con éxito`,
              'success'
            );
          }
        );
      }
    });
  }
}
