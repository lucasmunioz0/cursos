import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppEjemplosComponent } from './app-ejemplos/app-ejemplos.component';
import { ColorcitoDirective } from './directivas/colorcito.directive';
import { PeliculaComponent } from './pelicula/pelicula.component';
import { PeliculaDetalleComponent } from './pelicula-detalle/pelicula-detalle.component';
import { EjemploReactiveFormComponent } from './ejemplo-reactive-form/ejemplo-reactive-form.component';
import { EjemploTemplateDrivenComponent } from './ejemplo-template-driven/ejemplo-template-driven.component';

@NgModule({
  declarations: [
    AppComponent,
    AppEjemplosComponent,
    ColorcitoDirective,
    PeliculaComponent,
    PeliculaDetalleComponent,
    EjemploReactiveFormComponent,
    EjemploTemplateDrivenComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
