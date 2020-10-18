import { FormGroup } from '@angular/forms';
import { IBase } from './ibase';
import { ALERT_CLASS } from './../utilities/alertUtilities';
import { Injectable } from '@angular/core';

@Injectable()
export class ComponentBase<T extends IBase> {
  action: number;
  idEntity: number;
  messages: Array<string> = [];
  typeMessage: ALERT_CLASS;
  loading: boolean;
  entities: Array<T> = [];

  do(action: number, idEntity?: number){
    this.action = action;
    this.idEntity = idEntity;
  }

  done(message: string){
    this.messages = [];
    if (message){
      this.messages.push(message);
      this.typeMessage = ALERT_CLASS.success;
    }
    this.action = null;
    this.idEntity = null;
  }

  showError(message: string){
    console.log(message);
    this.messages = [];
    this.messages.push(message);
    this.typeMessage = ALERT_CLASS.danger;
  }
}
