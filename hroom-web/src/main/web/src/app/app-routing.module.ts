import { RouterModule, Routes } from '@angular/router';
import { StanzeComponent } from './pages/stanze/stanze.component';
import { ErrorComponent } from './pages/error/error.component';
import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import {LogoutComponent} from "./pages/logout/logout.component";
import {RouteGuardService} from "../services/routeGuardService";
import {GridStanzeComponent} from "./pages/grid-stanze/grid-stanze.component";
import {RegistrazioneComponent} from "./pages/registrazione/registrazione.component";
import {NotificationsComponent} from "./core/notifications/notifications.component";
import {UserListComponent} from "./pages/user-list/user-list.component";
import {AuthGuard} from "./guard/auth.guard.service";
import {HomeComponent} from "./pages/home/home.component";
import {UpdatepopupComponent} from "./pages/updatepopup/updatepopup.component";

const routes: Routes = [
  //{path:'', component: LoginComponent},
  {component:HomeComponent,path:'',canActivate:[AuthGuard]},
  {path:'login', component: LoginComponent},
  {path:'registrazione',component:RegistrazioneComponent},
  {path:'welcome/:userid', component: WelcomeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze', component: StanzeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze/grid', component: GridStanzeComponent,canActivate:[RouteGuardService]},
  {path:'logout', component : LogoutComponent,canActivate:[RouteGuardService]},
  {path:'user',component:UserListComponent,canActivate:[AuthGuard]},
  {path:'update',component:UpdatepopupComponent},
  {path:'**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
