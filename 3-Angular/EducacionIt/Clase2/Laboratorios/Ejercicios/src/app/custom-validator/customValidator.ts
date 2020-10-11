import { ValidatorFn, AbstractControl } from '@angular/forms';

export function validarTelefono(exp: RegExp): ValidatorFn{
  return (control: AbstractControl): {[key: string]: any} => {
    const telefono = exp.test(control.value);
    return !telefono ? {'nombreTelefono': {value: control.value}} : null;
  };
}

