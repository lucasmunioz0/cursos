import { ComponentChild } from './../../../interfaces/icomponent-child';
import { CRUD_ACTIONS } from './../../../utilities/formutilities';
import { IRol } from './../../../interfaces/irol';
import { RolService } from './../../../services/rol.service';
import { UserService } from './../../../services/user.service';
import { FormGroup } from '@angular/forms';
import { toCapitalize } from 'src/app/utilities/stringutilities';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { validateForm } from 'src/app/utilities/formutilities';
import { IUser } from 'src/app/interfaces/iuser';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  providers: [UserService, RolService]
})
export class UserDetailsComponent extends ComponentChild<IUser> implements OnInit {
  @Input()
  action: number;
  @Input()
  userId: number;
  @Output()
  done: EventEmitter<string> = new EventEmitter<string>();
  roles: Array<IRol> = [];

  constructor(private _userSvc: UserService, private _rolSvc: RolService) {
    super(_userSvc);
  }

  ngOnInit(): void {
    this.loading = true;
    this._rolSvc.getAll().subscribe(
      (data) => { this.roles = data; },
      (error) => this.messages.push(error)
    );

    if (this.userId > 0) {
      this._userSvc.get(this.userId).subscribe(
        (data) => { this.entity = data; this.messages = []; },
        (error) => this.messages.push(error),
        () => this.loading = false
      );
    } else {
      this.entity = { id: null, name: null, idRol: null, password: null, user: null, photo: null, rolDescription: null };
      this.loading = false;
    }
  }
}
