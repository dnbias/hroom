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
import {GridStanzeComponent} from "./pages/grid-stanze/grid-stanze.component";
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
import {UpdatepopupComponent} from "./pages/updatepopup/updatepopup.component";
import {UserListComponent} from "./pages/user-list/user-list.component";
import {CustomerComponent} from "./pages/customer/customer.component";
import {TagComponent} from "./pages/tag/tag.component";
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
import {jqxGridModule} from "jqwidgets-ng/jqxgrid";
import {jqxWindowModule} from "jqwidgets-ng/jqxwindow";
import {jqxChartModule} from "jqwidgets-ng/jqxchart";
import {WriteFeedbackComponent} from "./pages/write-feedback/write-feedback.component";

import { jqxRatingModule }    from 'jqwidgets-ng/jqxrating';
import {NewBookingComponent} from "./pages/new-booking/new-booking.component";
import {RoomsComponent} from "./pages/rooms/rooms.component";
import { LoadingInterceptor } from './service/loading/loading.interceptor';
import {BookedComponent} from "./pages/booked/booked.component";
import {PaymentComponent} from "./pages/payment/payment.component";

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    LoginComponent,
    ErrorComponent,
    StanzeComponent,
    LogoutComponent,
    GridStanzeComponent,
    StanzeCardComponent,
    RegistrazioneComponent,
    UpdatepopupComponent,
    UserListComponent,
    CustomerComponent,
    TagComponent,
    HomeComponent,
    SearchComponent,
    TagComponent,
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
    WriteFeedbackComponent,
    NewBookingComponent,
    RoomsComponent,
    BookedComponent,
    PaymentComponent,
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
    jqxGridModule, jqxWindowModule, jqxChartModule,jqxRatingModule,
    LoadingComponent,

//!!per collegare la parte di login al welcome

  ],
  providers: [
    provideAnimationsAsync(),
    { provide: HTTP_INTERCEPTORS,
      useClass: LoadingInterceptor, multi:true }
  ],
  exports: [
    TagComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
