import { IPost } from './../../interfaces/ipost';
import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  providers: [PostService]
})
export class PostsComponent implements OnInit {
  posts: Array<IPost>;
  message: string;
  post: IPost;
  action: string;

  constructor(private _postSvc: PostService) { }

  ngOnInit(): void {
    this._postSvc.posts().subscribe(
      (data) => {
        this.posts = data;
        this.message = null;
      },
      (error) => this.message = error
    );
  }

  selectPost(id: number) {
    this._postSvc.post(id).subscribe(
      (data) => this.post = data,
      (error) => this.message = error,
      () => this.action = 'Select'
    );
  }

  delete(id: number) {
    this._postSvc.delete(id).subscribe(
      (data) => { this.post = null; console.log(data); },
      (error) => this.message = error
    );
  }

  edit(id: number) {
    this._postSvc.post(id).subscribe(
      (data) => this.post = data,
      (error) => this.message = error,
      () => this.action = 'Edit'
    );
  }

  new() {
    this.action = 'New';
  }

  done(event) {
    if (event) {
      this.message = 'Changes saved successfully';
    }
    this.post = null;
    this.action = null;
  }
}
