import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { ValidarReactiveComponent } from './validar-reactive/validar-reactive.component';
import { DrivenComponent } from './driven/driven.component';
import { ValidarDrivenComponent } from './validar-driven/validar-driven.component';
import { CustomValidatorComponent } from './custom-validator/custom-validator.component';

@NgModule({
  declarations: [
    AppComponent,
    ValidarReactiveComponent,
    DrivenComponent,
    ValidarDrivenComponent,
    CustomValidatorComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
