import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ICountry } from './../interfaces/icountry';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { BaseService } from './base.service';
import { handleError } from '../utilities/servicesUtilities';

const BASE_URL = `${environment.urlBackend}/countries`;

@Injectable()
export class CountryService extends BaseService<ICountry>{

  constructor(http: HttpClient){
    super(http);
    this.BASE_URL = BASE_URL;
  }

  getAll(): Observable<Array<ICountry>>{
    return this._http.get<Array<ICountry>>(this.BASE_URL).pipe(
      catchError(handleError)
    );
  }
}
