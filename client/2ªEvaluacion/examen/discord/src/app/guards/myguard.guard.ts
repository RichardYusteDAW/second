import { CanActivateFn, Router } from '@angular/router';
import { TareaService } from '../services/tarea.service';
import { inject } from '@angular/core';

export const myguardGuard: CanActivateFn = (route, state) => {

  const tareaService = inject(TareaService);
  const router = inject(Router);

  if (tareaService.getPassword()) {
    return true;
  } else {
    router.navigate(['/']);
    return false;
  }
};