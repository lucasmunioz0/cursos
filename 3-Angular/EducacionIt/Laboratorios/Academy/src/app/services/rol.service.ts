import { IRol } from './../interfaces/irol';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { environment } from 'src/environments/environment';

const BASE_URL = `${environment.urlBackend}/roles`;

@Injectable()
export class RolService extends BaseService<IRol>{

  constructor(http: HttpClient) {
    super(http);
    this.BASE_URL = BASE_URL;
  }
}
