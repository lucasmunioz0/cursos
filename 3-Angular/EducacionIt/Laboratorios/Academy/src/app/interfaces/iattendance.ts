import { IBase } from './ibase';

export interface IAttendance extends IBase{
  idStudent: number;
  idCourse: number;
  type: number;
}
