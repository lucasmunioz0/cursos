import { IBase } from './ibase';
export interface ICourse extends IBase {
  description: string;
  lessons: number;
}
