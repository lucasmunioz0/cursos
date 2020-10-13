import { COUNTRIES } from './../../../mocks/mock';
import { ALERTS_TYPE } from './../../../utilities/alerts';
import { FormsModule, NgForm, FormGroup } from '@angular/forms';
import { Student } from './../../../entities/student';
import { State } from './../../../interfaces/state';
import { Sex } from './../../../interfaces/sex';
import { Country } from './../../../interfaces/country';
import { StudentService } from './../../../services/student.service';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { CRUD_ACTIONS } from 'src/app/utilities/abmc-actions';
import { ConfigurationService } from 'src/app/services/configuration.service';
import { Course } from 'src/app/interfaces/course';
import { StringUtilities } from 'src/app/utilities/stringUtilities';
import { FormUtilities } from 'src/app/utilities/formUtilities';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  providers: [FormUtilities]
})
export class DetailsComponent implements OnInit {
  @Input()
  idStudent: number = 0;
  @Input()
  action: number;
  @Output()
  done: EventEmitter<boolean> = new EventEmitter<boolean>();

  student: Student = new Student(null, null, null, null, null, null, null);
  countries: Array<Country>;
  courses: Array<Course>;
  sexs: Array<Sex>;
  states: Array<State>;
  alert: string;
  messages: Array<string>;
  countrySelected: Country = { id: 0, name: '', states: [] };

  constructor(private _studentSvc: StudentService, private _configSvc: ConfigurationService, private _stringUtilities: StringUtilities
    , private _formUtilities: FormUtilities) {}

  ngOnInit(): void {
    this._configSvc.sexs().subscribe(data => this.sexs = data);
    this._configSvc.countries().subscribe(data => this.countries = data);
    this._configSvc.courses().subscribe(data => this.courses = data);

    if (this.idStudent > 0) {
      this._studentSvc.getStudent(this.idStudent).subscribe(data => {
        this.student = data;
        this._logCountry();
      });
    }
  }

  title() {
    return CRUD_ACTIONS[this.action - 1] + ' Student';
  }

  changeCountry(id: number, reset: boolean = true) {
    this.countrySelected = this.countries.find(x => x.id == id);
    this.states = Object.assign([], this.countries.find(x => x.id == id).states);
    this.states.unshift({ id: 0, name: 'Seleccione...' });
    if (reset) {
      this.student.idState = null;
    }
  }

  delete() {
    this._studentSvc.removeStudent(this.idStudent).subscribe(data => {
      if (data) {
        this.done.emit(true);
      } else {
        this._notify('danger', ['no se pudo eliminar']);
      }
    });
  }

  back() {
    this.done.emit(false);
  }

  submit(form: FormGroup) {
    if (form.valid) {
      form.removeControl('country');
      this.student = form.value;
      this.student.id = this.idStudent;
      this._studentSvc.saveStudent(this.student).subscribe(
        data => {
          if (data) {
            this.done.emit(true);
          } else {
            this._notify('danger', ['Error en el guardado']);
          }
        }
      );
    } else {
      const errors = this._formUtilities.processError(form);
      this._notify('danger', errors);
    }
  }

  private _logCountry() {
    this.countrySelected = this.countries.filter(x => x.states.filter(y => y.id == this.student.idState).length > 0).shift();
    this.changeCountry(this.countrySelected.id, false);
  }

  private _notify(alert: string, messages: Array<string>) {
    this.alert = 'alert ' + ALERTS_TYPE.find(x => x.includes(alert));
    this.messages = messages;
  }
}
