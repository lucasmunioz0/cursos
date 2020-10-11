import { LoggerService } from './logger.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NuevoLoggerService extends LoggerService{

  constructor() { super(); }

  info(mensaje: string){
    console.log('Saludando desde el nuevo Logger');
    super.info(mensaje);
  }
}
