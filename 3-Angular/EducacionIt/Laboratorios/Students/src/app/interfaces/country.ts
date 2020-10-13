import { State } from './state';
import { BaseInterface } from './../interfaces/baseInterface';
export interface Country extends BaseInterface{
  states: Array<State>;
}
