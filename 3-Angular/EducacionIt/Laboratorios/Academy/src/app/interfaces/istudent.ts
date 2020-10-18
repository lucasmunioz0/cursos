import { ICourse } from './icourse';
import { IBase } from './ibase';
export interface IStudent extends IBase{
  lastName: string;
  birthdate: Date;
  address: string;
  idState: number;
  stateName?: string;
  email: string;
  courses: Array<ICourse>;
}
