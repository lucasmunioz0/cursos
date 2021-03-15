import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-abmc-title',
  templateUrl: './abmc-title.component.html',
  styleUrls: ['./abmc-title.component.css']
})
export class AbmcTitleComponent implements OnInit {

  @Input()
  title = '';

  constructor() { }

  ngOnInit(): void {
  }

}
