import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  template: `<p>&copy; Copyright: 2020 | Developed by Lucas Muñoz</p>`
})
export class FooterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
