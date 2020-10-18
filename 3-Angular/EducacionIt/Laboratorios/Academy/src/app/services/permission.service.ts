import { HttpClient, HttpParams } from '@angular/common/http';
import { IPermission } from './../interfaces/ipermission';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { BaseService } from './base.service';

const BASE_URL = `${environment.urlBackend}/permissions`;

@Injectable()
export class PermissionService extends BaseService<IPermission>{

  constructor(http: HttpClient) {
    super(http);
    this.BASE_URL = BASE_URL;
  }
}
