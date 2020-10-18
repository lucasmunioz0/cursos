import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IState } from '../interfaces/IState';
import { environment } from './../../environments/environment';
import { BaseService } from './base.service';

const BASE_URL = `${environment.urlBackend}/states`;

@Injectable()
export class StateService extends BaseService<IState>{

  constructor(http: HttpClient){
    super(http);
    this.BASE_URL = BASE_URL;
  }
}
