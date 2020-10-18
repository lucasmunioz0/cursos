import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { IAttendance } from './../interfaces/iattendance';
import { BaseService } from './base.service';
import { handleError } from '../utilities/servicesUtilities';

const BASE_URL = `${environment.urlBackend}/attendances`;

@Injectable()
export class AttendanceService extends BaseService<IAttendance>{

  constructor(http: HttpClient){
    super(http);
    this.BASE_URL = BASE_URL;
  }

  getByCourse(idCourse): Observable<Array<IAttendance>>{
    return this._http.get<Array<IAttendance>>(`${this.BASE_URL}?idCourse=${idCourse}`).pipe(
      catchError(handleError)
    );
  }
}
