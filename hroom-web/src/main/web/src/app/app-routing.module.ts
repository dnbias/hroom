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
import {NewBookingComponent} from "./pages/new-booking/new-booking.component";
import {RoomsComponent} from "./pages/room/room.component";
import {ProvaComponent} from "./pages/prova/prova.component";
import {UtentiComponent} from "./pages/utenti/utenti.component";
import {LoggoogleComponent} from "./pages/loggoogle/loggoogle.component";
import {HomeComponent} from "./pages/home/home.component";

const routes: Routes = [
  {path:'', component: LoginComponent},
  {path:'login', component: LoginComponent},
  {path:'registrazione',component:RegistrazioneComponent},
  {path:'welcome/:userid', component: WelcomeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze', component: StanzeComponent,canActivate:[RouteGuardService]},
  {path: 'stanze/grid', component: GridStanzeComponent,canActivate:[RouteGuardService]},
  {path:'logout', component : LogoutComponent,canActivate:[RouteGuardService]},
  {path:'booking',component: NewBookingComponent, canActivate:[RouteGuardService]},


  {path:'room',component: RoomsComponent,canActivate:[RouteGuardService]},
  {path:'prova',component:ProvaComponent, canActivate:[RouteGuardService]},
  {path:'utenti', component:UtentiComponent, canActivate:[RouteGuardService]},
  {path: 'google',component:LoggoogleComponent,canActivate:[RouteGuardService]},
  {path:'home',component:HomeComponent,canActivate:[RouteGuardService]},
  {path:'**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
