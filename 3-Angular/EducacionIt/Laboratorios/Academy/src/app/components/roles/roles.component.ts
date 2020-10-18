import { ComponentBase } from './../../interfaces/icomponent';
import { PermissionService } from './../../services/permission.service';
import { RolService } from './../../services/rol.service';
import { IRol } from '../../interfaces/irol';
import { IPermission } from '../../interfaces/ipermission';
import { Component, OnInit } from '@angular/core';
import { CRUD_ACTIONS } from 'src/app/utilities/formutilities';

@Component({
  selector: 'app-rol',
  templateUrl: './roles.component.html',
  providers: [RolService, PermissionService]
})
export class RolesComponent extends ComponentBase<IPermission> implements OnInit {

  constructor(private _rolSvc: RolService) {
    super();
   }

  ngOnInit(): void {
    this.loading = true;
    this._rolSvc.getAll().subscribe(
      (data) => this.entities = data,
      (error) => this.showError(error),
      () => this.loading = false
    );
  }
}
