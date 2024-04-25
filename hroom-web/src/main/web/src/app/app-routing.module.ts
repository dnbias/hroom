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
import {HomeComponent} from "./pages/home/home.component";
import {LoggoogleComponent} from "./pages/loggoogle/loggoogle.component";
import {NewBookingComponent} from "./pages/new-booking/new-booking.component";

const routes: Routes = [
  {path:'', component: HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'registrazione',component:RegistrazioneComponent},
  {path:'welcome/:userid', component: WelcomeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze', component: StanzeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze/grid', component: GridStanzeComponent,canActivate:[RouteGuardService]},
  {path:'logout', component : LogoutComponent,canActivate:[RouteGuardService]},
  {path:'home',component:HomeComponent},
  {path:'loggoogle',component:LoggoogleComponent,canActivate:[RouteGuardService]},
  {path:'booking',component:NewBookingComponent,canActivate:[RouteGuardService]},
  {path:'**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
