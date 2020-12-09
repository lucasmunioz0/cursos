import { ClienteService } from './cliente.service';
import { Cliente } from './cliente';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

  titulo = 'Formulario';
  cliente: Cliente;
  errores: Array<string>;

  constructor(private _clienteService: ClienteService, private _router: Router, private _acRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.cliente = new Cliente();
    this.cargarCliente();
  }

  cargarCliente(): void{
    this._acRoute.params.subscribe(params => {
      const id = params['id'];
      if (id){
        this._clienteService.getCliente(id).subscribe(
          (cliente) => this.cliente = cliente,
          (error) => console.dir(error)
        );
      }
    });
  }

  create(): void{
    this._clienteService.create(this.cliente).subscribe(
      cliente => {
        this._router.navigate(['/clientes']);
        Swal.fire('Nuevo Cliente', `El cliente ${cliente.nombre} se ha creado con éxito`, 'success');
      },
      error => {
        this.errores = error.error.errors as Array<string>;
        console.log(this.errores);
        /* Swal.fire('Nuevo Cliente', `El cliente ${cliente.nombre} se ha creado con éxito`, 'success'); */
      }
    );
  }

  update(): void{
    this._clienteService.update(this.cliente).subscribe(
      cliente => {
        this._router.navigate(['/clientes']);
        Swal.fire('Cliente Actualizado', `El cliente ${cliente.nombre} se ha modificado con éxito`, 'success');
      },
      error => {
        this.errores = error.error.errors as Array<string>;
        console.log(this.errores);
        /* Swal.fire('Nuevo Cliente', `El cliente ${cliente.nombre} se ha creado con éxito`, 'success'); */
      }
    );
  }
}
