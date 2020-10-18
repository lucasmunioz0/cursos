import { StudentDto } from './../../dtos/student-dto';
import { StringUtilities } from 'src/app/utilities/stringUtilities';
import { ALERTS_TYPE } from './../../utilities/alerts';
import { CRUD_ACTIONS } from './../../utilities/abmc-actions';
import { ConfigurationService } from './../../services/configuration.service';
import { StudentService } from './../../services/student.service';
import { Student } from './../../entities/student';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html'
})
export class StudentComponent implements OnInit {
  students: Array<StudentDto>;
  idStudent: number;
  action: number;
  alert: string;
  message: string;

  constructor(private _studentSvc: StudentService, private _configSvc: ConfigurationService, private _stringUtilities: StringUtilities) {
    this._studentSvc.getStudents2()
      .subscribe(data => this.students = data);
    console.log("hola mundo");
  }

  ngOnInit(): void { }

  on(action: number, idStudent?: number) {
    this.action = action;
    this.idStudent = idStudent;
  }

  done(action: boolean) {
    if (action) {
      this._studentSvc.getStudents2()
        .subscribe(
          (data) => {
            this.students = data;
            this.action = null;
          },
          () => {
            this._notify('success', 'The changes were saved successfully.');
          }
        );
    } else {
      this.alert = null;
      this.message = null;
      this.action = null;
    }
  }

  private _notify(alert: string, message: string) {
    this.alert = 'alert ' + ALERTS_TYPE.find(x => x.includes(alert));
    this.message = message;
  }
}
