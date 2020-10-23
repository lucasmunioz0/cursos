import { ComponentBase } from './../../interfaces/icomponent';
import { RolService } from './../../services/rol.service';
import { CRUD_ACTIONS } from './../../utilities/formutilities';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { IUser } from 'src/app/interfaces/iuser';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  providers: [UserService, RolService]
})
export class UsersComponent extends ComponentBase<IUser> implements OnInit {

  constructor(private _userSvc: UserService, private _rolSvc: RolService) {
    super();
  }

  ngOnInit(): void {
    this.loading = true;
    setTimeout(() => {
      this._userSvc.getAll().subscribe(
        (users) => {
          this.entities = users; this.messages = [];
          this._rolSvc.getAll().subscribe(
            (roles) => {
              this.entities.forEach(x => x.rolDescription = roles.find(y => y.id == x.idRol).name);
            },
            (error) => this.showError(error)
          );
        },
        (error) => this.showError(error),
        () => this.loading = false
      );
    }, 500);
  }
}
