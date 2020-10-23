import { ComponentChild } from './../../../interfaces/icomponent-child';
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
export class RolDetailsComponent extends ComponentChild<IRol> implements OnInit {
  @Input()
  action: number;
  @Input()
  idRol: number;
  @Output()
  done: EventEmitter<string> = new EventEmitter<string>();

  permissions: Array<IPermission> = [];

  constructor(private _permissionSvc: PermissionService, private _rolSvc: RolService) {
    super(_rolSvc);
   }

  ngOnInit(): void {
    this.loading = true;
    this._permissionSvc.getAll().subscribe(
      (data) => this.permissions = data,
      (error) => this.showError(error)
    );
    if (this.idRol > 0){
      this._rolSvc.get(this.idRol).subscribe(
        (data) => this.entity = data,
        (error) => this.showError(error),
        () => this.loading = false
      );
    }else{
      this.entity = {id: 0, name: null, description: null, permissions: null};
      this.loading = false;
    }
  }
}
