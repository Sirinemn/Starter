import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ActivateAcountComponent } from './components/activate-acount/activate-acount.component';

const routes: Routes = [
  { 
    title: 'Login', 
    path: 'login', 
    component: LoginComponent 
  },
  { 
    title: 'Activate-Account', 
    path: 'activate-account', 
    component: ActivateAcountComponent 
  },
  { 
    title: 'Register',
    path: 'register', 
    component: RegisterComponent 
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {}