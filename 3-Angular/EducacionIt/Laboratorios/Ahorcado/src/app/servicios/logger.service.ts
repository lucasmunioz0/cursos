import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  constructor() { }

  private _log(logLevel: string, msg: string){
    console.log(`${logLevel} - ${msg}`);
  }

  error(msj: string){
    this._log('ERROR', msj);
  }

  info(msj: string){
    this._log('INFO', msj);
  }
}
