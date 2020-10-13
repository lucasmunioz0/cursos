import { Student } from './../entities/student';
export class StudentDto {
  id: number;
  name: string;
  lastName: string;
  adress: string;
  sex: string;
  course: string;
  state: string;
  country: string;

  constructor(student: Student) {
    this.id = student.id;
    this.name = student.name;
    this.lastName = student.lastName;
    this.adress = student.adress;
  }

  stateFormat(){
    return `${this.adress? this.adress : ' - '} (${this.country} - ${this.state})`;
  }
}
