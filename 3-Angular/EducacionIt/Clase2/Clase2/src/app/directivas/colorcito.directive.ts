import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appColorcito]'
})
export class ColorcitoDirective {

  constructor(el: ElementRef) {
    el.nativeElement.style.backgroundColor = 'yellow';
  }
}
