import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html'
})
export class NewsComponent implements OnInit {

  id: number;

  constructor(activatedRoutes: ActivatedRoute) {
    activatedRoutes.params.subscribe( params => {
      this.id = params.id; // o params['id'];
    });
  }

  ngOnInit(): void {
  }

}
