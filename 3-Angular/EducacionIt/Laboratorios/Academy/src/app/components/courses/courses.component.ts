import { CourseService } from './../../services/course.service';
import { ComponentBase } from './../../interfaces/icomponent';
import { Component, OnInit } from '@angular/core';
import { ICourse } from 'src/app/interfaces/icourse';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  providers: [CourseService]
})
export class CoursesComponent extends ComponentBase<ICourse> implements OnInit {

  constructor(private _courseSvc: CourseService) {
    super();
  }

  ngOnInit(): void {
    this._courseSvc.getAll().subscribe(
      (courses) => this.entities = courses,
      (error) => this.showError(error)
    );
  }

}
