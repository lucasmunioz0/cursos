import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html'
})
export class NewsComponent implements OnInit {

  news = ['Hola', 'Noticia 2', 'Noticia 3', 'Noticia 4', 'Noticia 5'];
  new: string;
  id: number;
  error: string;

  constructor(private _route: ActivatedRoute) {

   }

  ngOnInit(): void {
    this._route.params.subscribe(
      (params) => {
        this.id = params['id'];
        this.new = this.news[this.id];
      },
      (error) => this.error = error
    );
  }

}
