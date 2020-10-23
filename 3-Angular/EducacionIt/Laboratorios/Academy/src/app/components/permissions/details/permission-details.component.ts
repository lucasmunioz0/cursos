import { ComponentChild } from './../../../interfaces/icomponent-child';
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
export class PermissionDetailsComponent extends ComponentChild<IPermission> implements OnInit {
  @Input()
  action: number;
  @Input()
  idPermission: number;
  @Output()
  done: EventEmitter<string> = new EventEmitter<string>();


  constructor(private _permissionSvc: PermissionService) {
    super(_permissionSvc);
   }

  ngOnInit(): void {
    this.loading = true;
    if (this.idPermission > 0){
      this._permissionSvc.get(this.idPermission).subscribe(
        (data) => this.entity = data,
        (error) => this.showError(error),
        () => this.loading = false
      );
    }else{
      this.entity = {id: null, name: null, description: null};
    }
    this.loading = false;
  }
}
