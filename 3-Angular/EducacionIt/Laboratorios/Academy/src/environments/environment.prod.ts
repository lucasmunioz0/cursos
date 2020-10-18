import { HttpHeaders } from '@angular/common/http';
export const environment = {
  production: true,
  urlBackend: 'http://localhost:3000',
  httpOptions: { headers: new HttpHeaders({
      'Content-Type': 'application/json'
  })}
};
