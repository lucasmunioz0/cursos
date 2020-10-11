import { CONFIG, APP_CONFIG } from './config';
import { NuevoLoggerService } from './servicios/nuevo-logger.service';
import { LoggerService } from './servicios/logger.service';
import { OtroServicioService } from './servicios/otro-servicio.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PrincipalComponent } from './componentes/principal/principal.component';
import { OtroModuloModule } from './modulos/otro-modulo/otro-modulo.module';
import { SecundarioComponent } from './componentes/secundario/secundario.component';

@NgModule({
  declarations: [
    AppComponent,
    PrincipalComponent,
    SecundarioComponent
  ],
  imports: [
    BrowserModule,
    OtroModuloModule
  ],
  providers: [
    OtroServicioService,
    {provide: LoggerService, useClass: NuevoLoggerService},
    {provide: CONFIG, useValue: APP_CONFIG}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
