import { toCapitalize } from 'src/app/utilities/stringutilities';
import { FormGroup } from '@angular/forms';

export const CRUD_ACTIONS = ['New', 'View', 'Edit', 'Delete'];

export enum ATTENDANCE_TYPE {
  PRESENT = 1,
  AUSENT = 2
}

export function validateForm(form: FormGroup): string[]{
    const result = [];
    if (!form.valid){
      // tslint:disable-next-line: forin
      for (const c in form.controls){
        const control = form.get(c);
        const controlName = toCapitalize(_getPropertyName(c), true);
        console.log(controlName)
        // tslint:disable-next-line: forin
        for (const e in control.errors){
          const error = control.getError(e);
          switch (e){
            case 'required':
              result.push(`${controlName} is required.`);
              break;
            case 'minlength':
              result.push(`${controlName} must have at least ${error.requiredLength} characters.`);
              break;
            case 'maxlength':
              result.push(`${controlName} must have at most ${error.requiredLength} characters.`);
              break;
            default:
              result.push(`${controlName} its invalid.`);
              break;
          }
        }
      }
    }
    return result;
}

function _getPropertyName(text: string): string{
    return text.startsWith('id') ? text.substr(2) : text;
}
