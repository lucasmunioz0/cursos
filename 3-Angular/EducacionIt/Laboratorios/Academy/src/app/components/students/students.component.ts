import { ICountry } from 'src/app/interfaces/ICountry';
import { StateService } from './../../services/state.service';
import { CountryService } from './../../services/country.service';
import { StudentService } from './../../services/student.service';
import { IStudent } from './../../interfaces/istudent';
import { ComponentBase } from './../../interfaces/icomponent';
import { Component, OnInit } from '@angular/core';
import { IState } from 'src/app/interfaces/IState';
import { error } from 'protractor';
import { stat } from 'fs';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  providers: [StudentService, CountryService, StateService]
})
export class StudentsComponent extends ComponentBase<IStudent> implements OnInit {

  constructor(private _studentSvc: StudentService, private _countrySvc: CountryService, private _stateSvc: StateService) {
    super();
  }

  ngOnInit(): void {
    this.loading = true;
    const states = new Array<IState>();
    const countries = new Array<ICountry>();
    this._studentSvc.getAll().subscribe(
      (data) => {
        this.entities = data;
        let state: IState;
        let country: ICountry;
        this.entities.forEach(student => {
          this._stateSvc.get(student.idState).subscribe(
            (stateResp) => state = stateResp,
            (error) => this.showError(error),
            () => {
              if (!states.find(x => x.id == state.id)){
                states.push(state);
              }
              this._countrySvc.get(state.idCountry).subscribe(
                (countryResp) => country = countryResp,
                (error2) => this.showError(error2),
                () => {
                  if (!countries.find(x => x.id == country.id)){
                    countries.push(country);
                  }
                  student.stateName = `(${state.name} - ${country.name})`;
                }
              );
              this.loading = false;
            }
          );
        });
      });
  }
}
