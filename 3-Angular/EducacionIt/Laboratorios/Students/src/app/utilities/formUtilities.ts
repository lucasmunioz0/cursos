import { StringUtilities } from 'src/app/utilities/stringUtilities';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable()
export class FormUtilities {

  constructor(private _stringUtilities: StringUtilities) { }

  processError(form: FormGroup): Array<string> {
    const errors = [];
    let lengthError: any;
    // tslint:disable-next-line: forin
    for (const propertyControl in form.controls) {
      const control = form.get(propertyControl);
      // tslint:disable-next-line: forin
      for (const error in control.errors) {
        const property = this._getPropertyText(propertyControl);
        switch (error) {
          case 'required':
            errors.push(`${property} is required`);
            break;
          case 'minlength':
            lengthError = control.getError(error);
            errors.push(`${property} must have at least ${lengthError.requiredLength} characters`);
            break;
          case 'maxlength':
            lengthError = control.getError(error);
            errors.push(`${property} must have at most ${lengthError.requiredLength} characters`);
            break;
          default:
            errors.push(`The field ${property} have minimun`);
        }
      }
    }

    return errors;
  }

  private _getPropertyText(text: string) {
    if (text.startsWith('id')) {
      text = text.replace('id', '');
    }
    return this._stringUtilities.toCapitalize(text);
  }
}
