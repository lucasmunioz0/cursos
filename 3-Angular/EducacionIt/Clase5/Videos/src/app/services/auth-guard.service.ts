import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | Promise<boolean> | boolean{
    console.log(next.routeConfig.path);
    if ( localStorage.getItem('currentUser') == 'administrador'){
      return true;
    }else{
      this.router.navigate(['home'], {queryParams: {returnUrl: state.url}});
      return false;
    }
  }
}
