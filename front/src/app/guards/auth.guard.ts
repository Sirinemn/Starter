import { Inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { SessionService } from '../service/session.service';


export const authGuard: CanActivateFn = (route, state) => {

  const router = Inject(Router);
  const sessionService = Inject(SessionService);
  
  if (sessionService.isLogged) {
    router.navigate(['']);
    return false;
  }
  return true;
};
