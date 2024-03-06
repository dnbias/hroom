import { RouterModule, Routes } from '@angular/router';
import { StanzeComponent } from './stanze/stanze.component';
import { ErrorComponent } from './error/error.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { WelcomeComponent } from './welcome/welcome.component';
import {LogoutComponent} from "./logout/logout.component";
import {RouteGuardService} from "../services/routeGuardService";

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'login', component: LoginComponent},
  {path:'welcome/:userid', component: WelcomeComponent,canActivate:[RouteGuardService]},
  {path:'stanze', component : StanzeComponent, canActivate:[RouteGuardService]},
  {path:'logout', component : LogoutComponent,canActivate:[RouteGuardService]},
  {path:'**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
