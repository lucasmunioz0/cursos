import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { IStudent } from '../interfaces/istudent';
import { BaseService } from './base.service';
import { Injectable } from '@angular/core';
import { handleError } from '../utilities/servicesUtilities';

const BASE_URL = `${environment.urlBackend}/students`;

@Injectable()
export class StudentService extends BaseService<IStudent> {

  constructor(http: HttpClient) {
    super(http);
    this.BASE_URL = BASE_URL;
  }

  getByCourse(idCourse): Observable<Array<IStudent>>{
    return this._http.get<Array<IStudent>>(`${this.BASE_URL}?courses_like=${idCourse}`).pipe(
      catchError(handleError)
    );
  }
}
