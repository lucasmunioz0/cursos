import { Injectable } from '@angular/core';
import { stringify } from 'querystring';

@Injectable({
  providedIn: 'root'
})
export class StringUtilities {
  constructor() { }

  toCapitalize(text: string): string {
    text = this._splitCamelCase(text);
    const splitText = text.split(' ');
    const result = new Array<string>(splitText.length);
    splitText.forEach(x => result.push(x.charAt(0).toUpperCase().concat(x.substr(1, x.length))));
    return result.join(' ');
  }

  private _splitCamelCase(text: string): string {
    let result = '';

    for (let i = 0; i < text.length; i++) {
      const c = text.charAt(i);
      result += c === c.toUpperCase() ? ' ' + c : c;
    }
    return result;
  }
}
