import { AutoService, Motor, Ruedas } from './servicios/auto.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DependenciasComponent } from './dependencias/dependencias.component';

@NgModule({
  declarations: [
    AppComponent,
    DependenciasComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [Motor, Ruedas],
  bootstrap: [AppComponent]
})
export class AppModule { }
