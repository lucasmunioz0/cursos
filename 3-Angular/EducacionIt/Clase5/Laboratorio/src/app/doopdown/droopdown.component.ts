import { Routes} from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { routes } from 'src/app/app-routing.module';

@Component({
  selector: 'app-droopdown',
  templateUrl: './droopdown.component.html'
})
export class DroopdownComponent implements OnInit {
  routes: Routes;

  constructor() { }

  ngOnInit(): void {
    this.routes = routes.filter(x => x.component && !x.path.includes(':'));
  }

}
