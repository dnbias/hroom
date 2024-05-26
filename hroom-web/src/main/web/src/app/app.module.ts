import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {StanzeComponent} from './pages/stanze/stanze.component';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { CoreModule } from './core/core.module';
import { ErrorComponent } from './pages/error/error.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './pages/login/login.component';
import { NgModule, Component } from '@angular/core';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import {StanzeCardComponent} from "./components/stanze-card/stanze-card.component";

import {RegistrazioneComponent} from "./pages/registrazione/registrazione.component";
import {NotificationsComponent} from "./core/notifications/notifications.component";
import {LogoutComponent} from "./pages/logout/logout.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatFormField, MatFormFieldModule} from "@angular/material/form-field";
import {MatCard, MatCardContent, MatCardHeader} from "@angular/material/card";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {MaterialModule} from "../material.module";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

import {CustomerComponent} from "./pages/customer/customer.component";
import {TagComponent} from "./pages/tag/tag.component";
import {TagButtonComponent} from "./pages/tag/button/tag.button.component";
import {SearchComponent} from "./pages/search/search.component";
import {HomeComponent} from "./pages/home/home.component";
import {NotFoundComponent} from "./pages/not-found/not-found.component";
import {CartPageComponent} from "./pages/cart-page/cart-page.component";
import {StanzeModificaComponent} from "./pages/stanze-modifica/stanze-modifica.component";
import {StanzaPageComponent} from "./pages/stanza-page/stanza-page.component";
import {PortfolioComponent} from "./pages/welcome/portfolio/portfolio.component";
import {ProjectCardComponent} from "./pages/welcome/portfolio/project-card/project-card.component";
import {NavComponent} from "./core/nav/nav.component";
import {PrenotazioniComponent} from "./pages/welcome/prenotazioni/prenotazioni.component";
import {FeedbackComponent} from "./pages/welcome/feedback/feedback.component";
import { LoadingComponent } from "./service/loading/loading.component";
import {BookingComponent} from "./pages/booking/booking.component";
import {MatButton, MatButtonModule} from "@angular/material/button";
import {MatStepperModule} from "@angular/material/stepper";
import {MatInput, MatInputModule} from "@angular/material/input";

// import {AsyncPipe} from "@angular/material/progress-spinner";
// import dotenv from 'dotenv';

import {
  MatDatepicker,
  MatDatepickerInput,
  MatDatepickerModule,
  MatDatepickerToggle
} from "@angular/material/datepicker";
import {provideNativeDateAdapter} from "@angular/material/core";
import {DataComponent} from "./pages/data/data.component";

import 'jqwidgets-ng/jqwidgets/jqxcore';
import {jqxGridModule} from "jqwidgets-ng/jqxgrid";
import {jqxWindowModule} from "jqwidgets-ng/jqxwindow";
import {jqxChartModule} from "jqwidgets-ng/jqxchart";
import {jqxButtonModule} from 'jqwidgets-ng/jqxbuttons';
import {jqxRatingModule}    from 'jqwidgets-ng/jqxrating';

import {NewBookingComponent} from "./pages/new-booking/new-booking.component";
import {RoomsComponent} from "./pages/rooms/rooms.component";

import {BookedComponent} from "./pages/booked/booked.component";
import {PaymentComponent} from "./pages/payment/payment.component";
import {PopupAddComponent} from "./pages/popup-add/popup-add.component";
import { LoadingInterceptor } from './service/loading/loading.interceptor';
import {AdminFunctionComponent} from "./admin-function/admin-function.component";
// import {ListaUtentiComponent} from "./pages/lista-utenti/lista-utenti.component";


@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    ErrorComponent,
    StanzeComponent,
    LogoutComponent,
    StanzeCardComponent,
    RegistrazioneComponent,
    CustomerComponent,
    HomeComponent,
    SearchComponent,
    TagComponent,
    TagButtonComponent,
    NotFoundComponent,
    CartPageComponent,
    StanzeModificaComponent,
    StanzaPageComponent,
    PortfolioComponent,
    ProjectCardComponent,
    NavComponent,
    PrenotazioniComponent,
    FeedbackComponent,
    StanzeCardComponent,
    NewBookingComponent,
    RoomsComponent,
    BookedComponent,
    PaymentComponent,
    AdminFunctionComponent,
    // ListaUtentiComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CoreModule,
    HttpClientModule,
    MatFormField,
    MatCardContent,
    MatCardHeader,
    MatCard,
    ReactiveFormsModule,
    MatRadioGroup,
    MatRadioButton,
    BrowserAnimationsModule,
    MaterialModule,
    ToastrModule.forRoot(),
    MatButtonModule,
    MatStepperModule,
    MatInputModule,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatDatepicker,
    MatDatepickerModule,
    MatFormFieldModule,
    DataComponent,
    jqxButtonModule,
    jqxGridModule, jqxWindowModule,
    jqxChartModule, jqxRatingModule,
    LoadingComponent,
  ],
  providers: [
    provideAnimationsAsync(),
    { provide: HTTP_INTERCEPTORS,
      useClass: LoadingInterceptor, multi:true }
  ],
  exports: [
    TagComponent,
    TagButtonComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
