import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-ficha',
  templateUrl: './ficha.component.html'
})
export class FichaComponent implements OnInit {
  @Input()
  imagen: string;

  constructor() { }

  ngOnInit(): void {
  }

}
