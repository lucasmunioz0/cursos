import { PersonaService } from './services/persona-service.service';
import { LogginService } from './services/LoggingService.service';
import { CalculadoraFormularioComponent } from './calculadora/formulario/formulario.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { PersonaComponent } from './persona/persona.component';
import { FormsModule } from '@angular/forms';
import { CalculadoraComponent } from './calculadora/calculadora.component';
import { ListadoPersonasComponent } from './listado-personas/listado-personas.component';
import { FormularioComponent } from './formulario/formulario.component';
import { ResultadoComponent } from './calculadora/resultado/resultado.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonaComponent,
    CalculadoraComponent,
    ListadoPersonasComponent,
    FormularioComponent,
    ResultadoComponent,
    CalculadoraFormularioComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [LogginService, PersonaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
