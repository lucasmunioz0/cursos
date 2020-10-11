import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DrivenComponent } from './driven/driven.component';
import { ValidarDrivenComponent } from './validar-driven/validar-driven.component';
import { ReactiveComponent } from './reactive/reactive.component';
import { CustomValidatorComponent } from './custom-validator/custom-validator.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    DrivenComponent,
    ValidarDrivenComponent,
    ReactiveComponent,
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
