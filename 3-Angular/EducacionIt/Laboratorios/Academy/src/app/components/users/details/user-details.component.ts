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
export class UserDetailsComponent implements OnInit {
  @Input()
  action: number;
  @Input()
  userId: number;
  @Output()
  done: EventEmitter<string> = new EventEmitter<string>();

  loading: boolean;
  typeError: string;
  messages: string[] = [];
  user: IUser = { id: null, name: null, idRol: null, password: null, user: null, photo: null, rolDescription: null };
  roles: Array<IRol> = [];

  constructor(private _userSvc: UserService, private _rolSvc: RolService) {
  }

  ngOnInit(): void {
    this.loading = true;
    this._rolSvc.getAll().subscribe(
      (data) => { this.roles = data; },
      (error) => this.messages.push(error)
    );

    if (this.userId > 0) {
      this._userSvc.get(this.userId).subscribe(
        (data) => { this.user = data; this.messages = []; },
        (error) => this.messages.push(error),
        () => this.loading = false
      );
    } else {
      this.user = { id: null, name: null, idRol: null, password: null, user: null, photo: null, rolDescription: null };
      this.loading = false;
    }
  }

  title() {
    return toCapitalize(CRUD_ACTIONS[this.action - 1]);
  }

  submit(userForm: FormGroup) {
    this.messages = validateForm(userForm);
    if (this.messages.length > 0) {
      this.typeError = 'danger';
    } else {
      this.messages = [];
      if (this.user.id > 0) {
        this._userSvc.put(this.user).subscribe(
          (data) => this.back('Data saved succesfully'),
          (error) => { this._showError(error); }
        );
      } else {
        this._userSvc.post(this.user).subscribe(
          (data) => this.back('Data saved succesfully'),
          (error) => { this._showError(error); }
        );
      }
    }
  }

  delete() {
    this._userSvc.delete(this.user.id).subscribe(
      (data) => { this.back('Data saved succesfully'); },
      (error) => { this._showError(error); },
      () => this.back('Data saved successfully')
    );
  }

  back(message?: string) {
    this.done.emit(message);
  }

  private _showError(message: string) {
    this.typeError = 'error';
    this.messages.push(message);
  }
}
