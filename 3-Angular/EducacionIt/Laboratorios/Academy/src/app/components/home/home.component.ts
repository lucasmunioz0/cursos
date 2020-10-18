import { Component, OnInit } from '@angular/core';
import { splitWords, toCapitalize } from 'src/app/utilities/stringutilities';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  message: string;

  constructor() { }

  ngOnInit(): void {
  }

  test(){
    this.message = 'Split: ' + splitWords('Lucas mUñoz');
    this.message = this.message + '/////To Capilize' + toCapitalize('Lucas mUñoz', false);
  }

}
