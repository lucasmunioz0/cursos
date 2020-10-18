import { IBase } from './ibase';
export interface IUser extends IBase{
  user: string;
  photo: string;
  password: string;
  idRol: number;
  rolDescription: string;
}
