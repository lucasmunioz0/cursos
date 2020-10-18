import { PostServiceService } from './../services/post-service.service';
import { IPost } from './../entidades/usuario';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-simple-request',
  templateUrl: './simple-request.component.html'
})
export class SimpleRequestComponent implements OnInit {
  posts: Array<IPost>;
  loading = false;
  error = '';

  constructor(private _http: HttpClient, private _postSvc: PostServiceService) { }

  ngOnInit(): void {
  }

  makeRequest() {
    this.loading = true;
    this._postSvc.getPosts()
      .subscribe(
        res => {
          this.posts = res;
          this.loading = false;
        },
        error => this.error = error
      );
  }

}
