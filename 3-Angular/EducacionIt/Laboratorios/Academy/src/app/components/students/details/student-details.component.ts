import { StateService } from './../../../services/state.service';
import { CountryService } from './../../../services/country.service';
import { CourseService } from './../../../services/course.service';
import { StudentService } from './../../../services/student.service';
import { IStudent } from './../../../interfaces/istudent';
import { ComponentChild } from './../../../interfaces/icomponent-child';
import { Component, OnInit } from '@angular/core';
import { Injectable, Input, EventEmitter, Output } from '@angular/core';
import { ICourse } from 'src/app/interfaces/icourse';
import { ICountry } from 'src/app/interfaces/ICountry';
import { IState } from 'src/app/interfaces/istate';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  providers: [StudentService, CourseService, CountryService, StateService]
})
export class StudentDetailsComponent extends ComponentChild<IStudent> implements OnInit {
  @Input()
  action: number;
  @Input()
  idEntity: number;
  @Output()
  done: EventEmitter<string> = new EventEmitter<string>();

  courses: Array<ICourse> = [];
  countries: Array<ICountry> = [];
  states: Array<IState> = [];
  countrySelected: ICountry = {id: 0, name: null, states: []};

  constructor(private _studentSvc: StudentService, private _courseSvc: CourseService,
    private _countrySvc: CountryService, private _stateSvc: StateService) {
    super(_studentSvc);
  }

  ngOnInit(): void {
    this.loading = true;
    this._courseSvc.getAll().subscribe(
      (courses) => this.courses = courses,
      (error1) => this.showError(error1)
    );
    this._countrySvc.getAll().subscribe(
      (countries) => {
        this.countries = countries;
        this.countries.unshift({ id: 0, name: 'Select...', states: [] });
      },
      (error3) => this.showError(error3)
    );
    if (this.idEntity > 0) {
      this._studentSvc.get(this.idEntity).subscribe(
        (student) => {
          this.entity = student;
          this._logCountry(student.idState);
        },
        (error) => this.showError(error),
        () => this.loading = false
      );
    } else {
      this.entity = { id: null, name: null, lastName: null, birthdate: null, address: null, idState: null, courses: null, email: null };
      this.loading = false;
    }
  }

  countryChange(country: number, reset: boolean = true) {
    this._stateSvc.getAll().subscribe(
      (states) => {
        this.states = states.filter(x => x.idCountry == country);
        this.states.unshift({ id: 0, name: 'Select...', idCountry: country });
      },
      (error2) => this.showError(error2)
    );

    if (reset) {
      this.entity.idState = null;
    }
  }

  private _logCountry(idState: number) {
    this.countrySelected = this.countries.find(c => c.states.filter(s => s.id == idState).length > 0);
    this.countryChange(this.countrySelected.id, false);
  }
}
