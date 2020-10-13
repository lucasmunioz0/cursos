import { Sex } from './../interfaces/sex';
import { Country } from './../interfaces/country';
import { ConfigurationService } from 'src/app/services/configuration.service';
import { StudentDto } from './../dtos/student-dto';
import { Observable, Observer } from 'rxjs';
import { Student } from './../entities/student';
import { Injectable } from '@angular/core';
import { Course } from '../interfaces/course';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private _configSvc: ConfigurationService) { }

  students = [
    new Student(1, 'Lucas', 'Muñoz', 'San Juan 1549', 1, 1, 2),
    new Student(2, 'Pedro', 'Picapiedra', 'Saavedra 156', 1, 3, 6),
    new Student(3, 'Carolina', 'Ogando', 'Cochimba 540', 2, 1, 7),
    new Student(4, 'Jose', 'Listorti', 'Estados Unidos 500', 1, 2, 4),
    new Student(5, 'Maria', 'Castro', 'Siemprevivas 240', 2, 1, 1),
  ];

  getStudents(): Observable<Array<Student>> {
    return new Observable<Array<Student>>((observer: Observer<Array<Student>>) => {
      observer.next(this.students);
      observer.complete();
    });
  }

  getStudents2(): Observable<Array<StudentDto>> {
    return new Observable<Array<StudentDto>>((observer: Observer<Array<StudentDto>>) => {
      const students = new Array<StudentDto>();
      let countries: Array<Country>;
      let sexs: Array<Sex>;
      let courses: Array<Course>;
      this._configSvc.countries().subscribe(data => countries = data);
      this._configSvc.courses().subscribe(data => courses = data);
      this._configSvc.sexs().subscribe(data => sexs = data);

      this.students.forEach(e => {
        const studentDto = this._transform(e, countries, sexs, courses);
        students.push(studentDto);
      });

      observer.next(students);
      observer.complete();
    });
  }

  private _transform(e: Student, countries, sexs, courses): StudentDto{
    const studentDto = new StudentDto(e);
    const country = countries.filter(x => x.states.filter(y => y.id == e.idState).length > 0).shift();
    if (e.idSex){
      studentDto.sex = sexs.filter(x => x.id == e.idSex).shift().name;
    }
    if (e.idCourse){
      studentDto.course = courses.find(x => x.id == e.idCourse).name;
    }
    studentDto.country = country.name;
    studentDto.state = country.states.filter(x => x.id == e.idState).shift().name;
    return studentDto;
  }

  getStudent(id: number): Observable<Student> {
    return new Observable<Student>((observer: Observer<Student>) => {
      const student = this.students.filter(x => x.id == id).shift();
      observer.next(student);
      observer.complete();
    });
  }

  saveStudent(student: Student): Observable<boolean> {
    return new Observable<boolean>((observer: Observer<boolean>) => {
      let flag = true;
      if (student.id > 0) {
        const index = this.students.findIndex(x => x.id == student.id);
        if (index >= 0) {
          this.students[index] = student;
        } else {
          flag = false;
        }
      } else {
        student.id = Number.parseInt((Math.random() * 10).toString(), 12);
        this.students.push(student);
      }

      observer.next(flag);
      observer.complete();
    });
  }

  removeStudent(id: number): Observable<boolean> {
    return new Observable<boolean>((observer: Observer<boolean>) => {
      let flag = false;
      if (id > 0) {
        const index = this.students.findIndex(x => x.id === id);
        if (index >= 0) {
          this.students.splice(index, 1);
          flag = true;
        }
      }
      observer.next(flag);
      observer.complete();
    });
  }
}
