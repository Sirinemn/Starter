import { CanActivateFn, Router } from '@angular/router';
import { SessionService } from '../service/session.service';
import { Inject } from '@angular/core';

export const unauthGuard: CanActivateFn = (route, state) => {

  const router = Inject(Router);
  const sessionService = Inject(SessionService);
  
  if (sessionService.isLogged) {
    router.navigate(['']);
    return false;
  }
  return true;
};
