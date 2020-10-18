import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { FormPalabraComponent } from './componentes/form-palabra/form-palabra.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PalabrasListadoComponent } from './components/palabras-listado/palabras-listado.component';

@NgModule({
  declarations: [
    AppComponent,
    FormPalabraComponent,
    PalabrasListadoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
