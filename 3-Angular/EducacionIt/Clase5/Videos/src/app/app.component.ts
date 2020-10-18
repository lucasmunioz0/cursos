import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit{
  title = 'Videos';

  ngOnInit(){
    localStorage.setItem('currentUser', 'administrador');
  }
}
