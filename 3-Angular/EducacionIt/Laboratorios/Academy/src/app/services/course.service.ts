import { ICourse } from '../interfaces/icourse';
import { BaseService } from './base.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';

const BASE_URL = `${environment.urlBackend}/courses`;

@Injectable()
export class CourseService extends BaseService<ICourse>{

  constructor(http: HttpClient) {
    super(http);
    this.BASE_URL = BASE_URL;
  }
}
