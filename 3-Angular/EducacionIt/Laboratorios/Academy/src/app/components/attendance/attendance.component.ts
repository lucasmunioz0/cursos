import { StudentService } from './../../services/student.service';
import { AttendanceService } from './../../services/attendance.service';
import { Component, OnInit } from '@angular/core';
import { ICourse } from 'src/app/interfaces/icourse';
import { IStudent } from 'src/app/interfaces/istudent';
import { CourseService } from 'src/app/services/course.service';
import { error } from 'protractor';
import { IAttendance } from 'src/app/interfaces/iattendance';

@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  providers: [CourseService, AttendanceService, StudentService]
})
export class AttendanceComponent implements OnInit {
  action: number;
  courses: Array<ICourse> = [];
  loading: boolean;
  course: ICourse = { id: null, name: null, description: null, lessons: null };
  students: Array<IStudent> = [];
  attendances: Array<IAttendance> = [];

  constructor(private _courseSvc: CourseService, private _attendanceSvc: AttendanceService, private _studentSvc: StudentService) { }

  ngOnInit(): void {
    this.loading = true;
    this._courseSvc.getAll().subscribe(
      (courses) => {
        this.courses = courses;
        this.courses.unshift({ id: 0, name: 'Select...', lessons: 0, description: null });
      },
      (error) => console.log(error),
      () => this.loading = false
    );
  }

  logStudents(idCourse: number) {
    this.loading = true;
    this.course = this.courses.find(x => x.id == idCourse);
    this._studentSvc.getByCourse(this.course.id).subscribe(
      (students) => this.students = students,
      (error2) => console.log(error2),
      () => {
        this.attendances = new Array<IAttendance>(this.course.lessons);
        this.loading = false;
        // this._attendanceSvc.getByCourse(this.course.id).subscribe(
        //   (attendances) => this.attendances = attendances,
        //   (error) => console.log(error),
        //   () => this.loading = false
        // );
      }
    );
  }

  logAttendance(idStudent: number, idLesson: number, type: number){

  }
}
