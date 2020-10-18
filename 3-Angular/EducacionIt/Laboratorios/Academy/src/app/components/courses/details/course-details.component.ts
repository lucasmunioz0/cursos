import { CourseService } from './../../../services/course.service';
import { ComponentChild } from '../../../interfaces/icomponent-child';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { ICourse } from 'src/app/interfaces/icourse';

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  providers: [CourseService]
})
export class CourseDetailsComponent extends ComponentChild<ICourse> implements OnInit {
  @Input()
  action: number;
  @Input()
  idEntity: number;
  @Output()
  done: EventEmitter<string> = new EventEmitter<string>();

  constructor(private _courseSvc: CourseService) {
    super(_courseSvc);
  }

  ngOnInit(): void {
    this.loading = true;
    if (this.idEntity > 0) {
      this._courseSvc.get(this.idEntity).subscribe(
        (course) => this.entity = course,
        (error) => this.showError(error),
        () => this.loading = false
      );
    } else {
      this.entity = { id: null, name: null, description: null, lessons: null };
      this.loading = false;
    }
  }
}
