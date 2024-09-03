import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { unauthGuard } from './guards/unauth.guard';

export const routes: Routes = [
  { 
    path: '',
     component: HomeComponent ,
    
  },
  {
    path: 'auth',
    canActivate: [unauthGuard], 
    loadChildren : ()=> 
      import('./feature/auth/auth.routes').then((r) => r.auth_routes)
    
  },
  { 
    path: '404',
    component: NotFoundComponent 
  },
  { 
    path: '**',
    redirectTo: '404' 
  },
];

