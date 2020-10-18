import { FormGroup } from '@angular/forms';
import { IPost } from './../../../interfaces/ipost';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html'
})
export class DetailsComponent implements OnInit {
  @Input()
  post: IPost;
  @Input()
  action: string;
  @Output()
  done: EventEmitter<boolean> = new EventEmitter<boolean>();
  message: string;

  constructor(private _postSvc: PostService) { }

  ngOnInit(): void {
    if (!this.post){
      this.post = {id: null, userId: null, title: null, body: null};
    }
  }

  save(){
    if (this.action === 'New'){
      this._postSvc.add(this.post).subscribe(
        (data) => this.done.emit(true),
        (error) => this.message = error
      );
    }else{
      this._postSvc.update(this.post).subscribe(
        (data) => this.done.emit(true),
        (error) => this.message = error
      );
    }
  }

  back(){
    this.done.emit(false);
  }
}
