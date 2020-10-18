import { throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';

export function handleError(error: HttpErrorResponse){
  let message = '';
  if (error.error instanceof ErrorEvent){
    message = `Something get wrong at client side: ${error.error.message}`;
  }else{
    message = `Something get wrong at server side: ${error.status} - ${error.message}`;
  }
  return throwError(message);
}
