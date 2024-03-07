import { RouterModule, Routes } from '@angular/router';
import { StanzeComponent } from './pages/stanze/stanze.component';
import { ErrorComponent } from './pages/error/error.component';
import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import {LogoutComponent} from "./pages/logout/logout.component";
import {RouteGuardService} from "../services/routeGuardService";
import {GridStanzeComponent} from "./pages/grid-stanze/grid-stanze.component";

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'login', component: LoginComponent},
  {path:'welcome/:userid', component: WelcomeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze', component: StanzeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze/grid', component: GridStanzeComponent,canActivate:[RouteGuardService]},
  {path:'logout', component : LogoutComponent,canActivate:[RouteGuardService]},
  {path:'**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
