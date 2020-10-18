import { RolService } from './../../../services/rol.service';
import { PermissionService } from './../../../services/permission.service';
import { FormGroup } from '@angular/forms';
import { IRol } from './../../../interfaces/irol';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CRUD_ACTIONS, validateForm } from 'src/app/utilities/formutilities';
import { IPermission } from 'src/app/interfaces/ipermission';

@Component({
  selector: 'app-rol-details',
  templateUrl: './rol-details.component.html',
  providers: [PermissionService, RolService]
})
export class RolDetailsComponent implements OnInit {
  @Input()
  action: number;
  @Input()
  idRol: number;
  @Output()
  done: EventEmitter<string> = new EventEmitter<string>();
  messages: Array<string> = [];
  typeError: string;
  rol: IRol = {id: null, name: null, description: null, permissions: null};
  permissions: Array<IPermission> = [];
  loading: boolean;

  constructor(private _permissionSvc: PermissionService, private _rolSvc: RolService) { }

  ngOnInit(): void {
    this.loading = true;
    this._permissionSvc.getAll().subscribe(
      (data) => this.permissions = data,
      (error) => this._showError(error)
    );
    if (this.idRol > 0){
      this._rolSvc.get(this.idRol).subscribe(
        (data) => this.rol = data,
        (error) => this._showError(error),
        () => this.loading = false
      );
    }else{
      this.loading = false;
    }
  }

  title() {
    return CRUD_ACTIONS[this.action - 1];
  }

  submit(form: FormGroup) {
    this.messages = validateForm(form);
    if (this.messages.length > 0){
        this.typeError = 'danger';
    }else{
      if (this.rol.id > 0){
        this._rolSvc.put(this.rol).subscribe(
          (data) => this.back('Data saved succesfully'),
          (error) => this._showError(error)
        );
      }else{
        this._rolSvc.post(this.rol).subscribe(
          (data) => this.back('Data saved succesfully'),
          (error) => this._showError(error)
        );
      }
    }
  }

  delete(){
    this._rolSvc.delete(this.rol.id).subscribe(
      (data) => this.back('Data saved succesfully'),
      (error) => this._showError(error)
    );
  }

  back(message?: string) {
    this.done.emit(message);
  }

  private _showError(error: string){
    this.messages = [];
    this.messages.push(error);
    this.typeError = 'danger';
  }
}
