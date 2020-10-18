import { StudentDetailsComponent } from './components/students/details/student-details.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { StudentsComponent } from './components/students/students.component';
import { CoursesComponent } from './components/courses/courses.component';
import { HomeComponent } from './components/home/home.component';
import { AttendanceComponent } from './components/attendance/attendance.component';
import { UsersComponent } from './components/users/users.component';
import { UserDetailsComponent } from './components/users/details/user-details.component';
import { PermissionsComponent } from './components/permissions/permissions.component';
import { AlertComponent } from './components/alert/alert.component';
import { RolesComponent } from './components/roles/roles.component';
import { RolDetailsComponent } from './components/roles/roles-details/rol-details.component';
import { PermissionDetailsComponent } from './components/permissions/details/permission-details.component';
import { CourseDetailsComponent } from './components/courses/details/course-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    StudentsComponent,
    StudentDetailsComponent,
    CoursesComponent,
    CourseDetailsComponent,
    HomeComponent,
    AttendanceComponent,
    UsersComponent,
    UserDetailsComponent,
    PermissionsComponent,
    PermissionDetailsComponent,
    AlertComponent,
    RolesComponent,
    RolDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
