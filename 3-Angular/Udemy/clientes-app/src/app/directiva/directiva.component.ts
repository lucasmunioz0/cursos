import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva',
  templateUrl: './directiva.component.html'
})
export class DirectivaComponent implements OnInit {

  listaCurso: string[] = ['TypeScript', 'JavaScript', 'Java', 'C#', 'PHP'];
  ocultar: boolean = true;
  constructor() { }

  ngOnInit(): void {
  }

}
