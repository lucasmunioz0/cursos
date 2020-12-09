import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { PedidoComponent } from './pedido/pedido.component';
import { ConfirmarPedidoComponent } from './confirmar-pedido/confirmar-pedido.component';

@NgModule({
  declarations: [
    AppComponent,
    PedidoComponent,
    ConfirmarPedidoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
