import { RouterModule, Routes } from '@angular/router';
import { StanzeComponent } from './pages/stanze/stanze.component';
import { ErrorComponent } from './pages/error/error.component';
import { LoginComponent } from './pages/login/login.component';
import { CommonModule } from '@angular/common';
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
import {CustomerComponent} from "./pages/customer/customer.component";
import {StanzeModificaComponent} from "./pages/stanze-modifica/stanze-modifica.component";
import {CartPageComponent} from "./pages/cart-page/cart-page.component";
import {PortfolioComponent} from "./pages/welcome/portfolio/portfolio.component";
import {NavComponent} from "./core/nav/nav.component";
import {PrenotazioniComponent} from "./pages/welcome/prenotazioni/prenotazioni.component";
import {FeedbackComponent} from "./pages/welcome/feedback/feedback.component";
import {StanzaPageComponent} from "./pages/stanza-page/stanza-page.component";
import {BookingComponent} from "./pages/booking/booking.component";
import {WriteFeedbackComponent} from "./pages/write-feedback/write-feedback.component";
import {NewBookingComponent} from "./pages/new-booking/new-booking.component";
import {RoomsComponent} from "./pages/rooms/rooms.component";
import {UploadImagesComponent} from "./components/upload-images/upload-images.component";
import {BookedComponent} from "./pages/booked/booked.component";
import {PaymentComponent} from "./pages/payment/payment.component";
import {PopupAddComponent} from "./pages/popup-add/popup-add.component";

const routes: Routes = [
  //{path:'', component: LoginComponent},
  {
    path:'',
    redirectTo:'home',
    pathMatch:'full'
  },

  {path:'home', component:HomeComponent},
  {path:'login', component: LoginComponent},
  {path:'registrazione',component:RegistrazioneComponent},
  {path:'welcome/:userid', component: WelcomeComponent,canActivate:[AuthGuard]},
  {path: 'stanze', component: StanzeModificaComponent},
  {path: 'stanze/grid', component: GridStanzeComponent},
  {path:'logout', component : LogoutComponent,canActivate:[AuthGuard]},
  {path:'user',component:UserListComponent,canActivate:[AuthGuard]},
  {path:'update',component:UpdatepopupComponent,canActivate:[AuthGuard]},
  {path:'tag/:tag',component:HomeComponent},
  {component:CustomerComponent,path:'customer',canActivate:[AuthGuard]},
  {path:'search/:searchItem',component:HomeComponent},
  {path: 'cart-page',component:CartPageComponent},
  {path:'portfolio',component:PortfolioComponent,canActivate:[AuthGuard]},
  {path:'booking',component:BookingComponent},
  {path:'NewBook',component:NewBookingComponent,canActivate:[AuthGuard]},
  {path:'prenotazioni',component:PrenotazioniComponent,canActivate:[AuthGuard]},
  {path:'feedback', component:FeedbackComponent,canActivate:[AuthGuard]},
  {path:'stanza/:id',component:StanzaPageComponent,canActivate:[AuthGuard]},
  {path:'feed',component:WriteFeedbackComponent,canActivate:[AuthGuard]},
  {path:'upload',component:UploadImagesComponent},
  {path:'room',component:RoomsComponent},
  {path:'booked',component:BookedComponent,canActivate:[AuthGuard]},
  {path:'payment',component:PaymentComponent,canActivate:[AuthGuard]},
  {path:'popup',component:PopupAddComponent},
  {path:'**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule],
  exports: [RouterModule],

})
export class AppRoutingModule { }
