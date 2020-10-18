import { ALERT_CLASS } from './../../utilities/alertUtilities';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-alert',
  template: `<div class={{alertClass}}>
              <div *ngIf="messages.length == 1">{{messages[0]}}</div>
              <ul *ngIf="messages.length > 1" class="mb-0"><li *ngFor="let message of messages">{{message}}</li></ul>
          </div>`
})
export class AlertComponent implements OnInit {
  @Input()
  type: string;
  @Input()
  messages: string[] = [];
  alertClass: string;

  constructor() { }

  ngOnInit(): void {
    this.alertClass = `alert ${this.type}`;
  }

}
