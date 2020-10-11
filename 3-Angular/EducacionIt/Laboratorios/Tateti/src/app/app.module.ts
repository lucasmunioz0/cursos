import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FichaComponent } from './ficha/ficha.component';
import { JuegoComponent } from './juego/juego.component';
import { JugadorComponent } from './jugador/jugador.component';
import { TableroComponent } from './tablero/tablero.component';

@NgModule({
  declarations: [
    AppComponent,
    FichaComponent,
    JuegoComponent,
    JugadorComponent,
    TableroComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
