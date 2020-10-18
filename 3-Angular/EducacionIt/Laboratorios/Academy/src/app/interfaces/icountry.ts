import { IBase } from './ibase';
import { IState } from './istate';

export interface ICountry extends IBase{
  states: Array<IState>;
}
