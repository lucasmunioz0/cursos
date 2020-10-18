import { RolesComponent } from './components/roles/roles.component';
import { StudentsComponent } from './components/students/students.component';
import { CoursesComponent } from './components/courses/courses.component';
import { UsersComponent } from './components/users/users.component';
import { PermissionsComponent } from './components/permissions/permissions.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AttendanceComponent } from './components/attendance/attendance.component';

export const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'students', component: StudentsComponent},
  {path: 'courses', component: CoursesComponent},
  {path: 'attendance', component: AttendanceComponent},
  {path: 'users', component: UsersComponent},
  {path: 'permissions', component: PermissionsComponent},
  {path: 'roles', component: RolesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
