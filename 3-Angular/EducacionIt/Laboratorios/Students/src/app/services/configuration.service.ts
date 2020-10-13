import { Course } from './../interfaces/course';
import { Sex } from './../interfaces/sex';
import { COUNTRIES, SEXS, COURSES } from './../mocks/mock';
import { Country } from './../interfaces/country';
import { Observable, Observer } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigurationService {

  constructor(){}

  countries(): Observable<Array<Country>>{
    return new Observable<Array<Country>>( (observer: Observer<Array<Country>>) =>{
      observer.next(COUNTRIES);
      observer.complete();
    });
  }

  sexs(): Observable<Array<Sex>>{
    return new Observable<Array<Sex>>( (observer: Observer<Array<Sex>>) =>{
      observer.next(SEXS);
      observer.complete();
    });
  }

  courses(): Observable<Array<Course>>{
    return new Observable<Array<Course>>( (observer: Observer<Array<Course>>) =>{
      observer.next(COURSES);
      observer.complete();
    });
  }
}
