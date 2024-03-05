import { RouterModule, Routes } from '@angular/router';

import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { WelcomeComponent } from './welcome/welcome.component';
import {StanzeComponent} from "./stanze/stanze.component";

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'login', component: LoginComponent},
  {path:'welcome/:userId', component: WelcomeComponent},
  {path:'stanze',component:StanzeComponent},
  {path:'**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
