import { catchError } from 'rxjs/operators';
import { environment } from './../../environments/environment';
import { IUser } from './../interfaces/iuser';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable, Optional, InjectionToken, Injector, Inject } from '@angular/core';
import { handleError } from '../utilities/servicesUtilities';
import { BaseService } from './base.service';

const BASE_URL = `${environment.urlBackend}/users`;

@Injectable()
export class UserService extends BaseService<IUser> {

  constructor(http: HttpClient) {
    super(http);
    this.BASE_URL = BASE_URL;
  }
}
