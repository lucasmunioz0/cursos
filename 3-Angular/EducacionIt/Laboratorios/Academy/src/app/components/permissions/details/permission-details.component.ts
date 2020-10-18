import { FormGroup } from '@angular/forms';
import { PermissionService } from '../../../services/permission.service';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { IPermission } from 'src/app/interfaces/ipermission';
import { CRUD_ACTIONS, validateForm } from 'src/app/utilities/formutilities';

@Component({
  selector: 'app-permission-details',
  templateUrl: './permission-details.component.html',
  providers: [PermissionService]
})
export class PermissionDetailsComponent implements OnInit {
  @Input()
  action: number;
  @Input()
  idPermission: number;
  @Output()
  done: EventEmitter<string> = new EventEmitter<string>();
  permission: IPermission = {id: null, name: null, description: null};
  loading: boolean;
  messages: Array<string> = [];
  typeError: string;

  constructor(private _permissionSvc: PermissionService) { }

  ngOnInit(): void {
    this.loading = true;
    if (this.idPermission > 0){
      this._permissionSvc.get(this.idPermission).subscribe(
        (data) => this.permission = data,
        (error) => this._showError(error),
        () => this.loading = false
      );
    }
    this.loading = false;
  }

  title(){
    return CRUD_ACTIONS[this.action - 1];
  }

  submit(form: FormGroup){
    this.messages = validateForm(form);
    if (this.messages.length > 0){
      this.typeError = 'danger';
    }else{
      if (this.permission.id > 0){
        this._permissionSvc.put(this.permission).subscribe(
          (data) => this.back('Data saved successfully.'),
          (error) => this._showError(error)
        );
      }else{
        this._permissionSvc.post(this.permission).subscribe(
          (data) => this.back('Data saved successfully.'),
          (error) => this._showError(error)
        );
      }
    }
  }

  delete(){
    this._permissionSvc.delete(this.permission.id).subscribe(
      (data) => this.back('Data saved successfully.'),
      (error) => this._showError(error)
    );
  }

  back(message?: string){
    this.done.emit(message);
  }

  private _showError(error: string){
    this.messages = [];
    this.messages.push(error);
    this.typeError = 'danger';
  }
}
