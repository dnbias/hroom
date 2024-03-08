import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';

import { AuthappService } from './authapp.service';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private BasicAuth: AuthappService, private route: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state:  RouterStateSnapshot)  {

    if (!this.BasicAuth.isLogged()) {
      this.route.navigate(['login'], { queryParams: {nologged: true}});
      return false;
    } else {
      return true;
    }
  }
}
