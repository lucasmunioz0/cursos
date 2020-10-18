import { IBase } from './ibase';
import { IPermission } from './ipermission';

export interface IRol extends IBase{
  description: string;
  permissions: Array<IPermission>;
}
