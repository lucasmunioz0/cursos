import { toCapitalize } from 'src/app/utilities/stringutilities';
import { routes } from 'src/app/app-routing.module';
import { Routes } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {

  routes: Routes;

  constructor() {
    this.routes = routes.filter(x => x.component && !x.path.includes(':'));
   }

  ngOnInit(): void {
  }

}
