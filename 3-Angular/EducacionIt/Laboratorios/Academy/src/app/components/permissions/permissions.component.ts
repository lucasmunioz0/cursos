import { ComponentBase } from './../../interfaces/icomponent';
import { PermissionService } from './../../services/permission.service';
import { Component, OnInit } from '@angular/core';
import { IPermission } from 'src/app/interfaces/ipermission';
import { ALERT_CLASS } from 'src/app/utilities/alertUtilities';

@Component({
  selector: 'app-permissions',
  templateUrl: './permissions.component.html',
  providers: [PermissionService]
})
export class PermissionsComponent extends ComponentBase<IPermission> implements OnInit  {

  constructor(private _permissionSvc: PermissionService) {
    super();
   }

  ngOnInit(): void {
    this.loading = true;
    this._permissionSvc.getAll().subscribe(
      (data) => this.entities = data,
      (error) => {this.messages.push(error); this.typeMessage = ALERT_CLASS.danger; },
      () => this.loading = false
    );
  }
}
