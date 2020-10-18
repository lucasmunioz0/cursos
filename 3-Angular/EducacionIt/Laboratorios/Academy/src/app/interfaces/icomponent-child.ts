import { EventEmitter } from '@angular/core';
import { validateForm } from 'src/app/utilities/formutilities';
import { CRUD_ACTIONS } from './../utilities/formutilities';
import { toCapitalize } from 'src/app/utilities/stringutilities';
import { BaseService } from './../services/base.service';
import { FormGroup } from '@angular/forms';
import { IBase } from './ibase';
import { ALERT_CLASS } from '../utilities/alertUtilities';

export class ComponentChild<T extends IBase> {
  action: number;
  idEntity: number;
  done: EventEmitter<string> = new EventEmitter<string>();
  messages: Array<string> = [];
  typeMessage: ALERT_CLASS;
  loading: boolean;
  entity: T;

  constructor(private _baseService: BaseService<T>) {

  }

  title() {
    return toCapitalize(CRUD_ACTIONS[this.action - 1]);
  }

  submit(form: FormGroup) {
    this.messages = validateForm(form);
    if (this.messages.length > 0) {
      this.typeMessage = ALERT_CLASS.danger;
    } else {
      this.messages = [];
      if (this.entity.id > 0) {
        this._baseService.put(this.entity).subscribe(
          (data) => this.back('Data saved succesfully'),
          (error) => { this.showError(error); }
        );
      } else {
        this._baseService.post(this.entity).subscribe(
          (data) => this.back('Data saved succesfully'),
          (error) => { this.showError(error); }
        );
      }
    }
  }

  delete() {
    this._baseService.delete(this.entity.id).subscribe(
      (data) => { this.back('Data saved succesfully'); },
      (error) => { this.showError(error); },
      () => this.back('Data saved successfully')
    );
  }

  back(message?: string) {
    this.done.emit(message);
  }

  showError(message: string) {
    this.messages = [];
    this.typeMessage = ALERT_CLASS.danger;
    this.messages.push(message);
  }
}
