import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {StanzeComponent} from './pages/stanze/stanze.component';
import { BrowserModule } from '@angular/platform-browser';
import { CoreModule } from './core/core.module';
import { ErrorComponent } from './pages/error/error.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import {StanzeCardComponent} from "./components/stanze-card/stanze-card.component";
import {GridStanzeComponent} from "./pages/grid-stanze/grid-stanze.component";
import {RegistrazioneComponent} from "./pages/registrazione/registrazione.component";
import {NotificationsComponent} from "./core/notifications/notifications.component";
import {LogoutComponent} from "./pages/logout/logout.component";
import {HttpClientModule} from "@angular/common/http";

import {NewBookingComponent} from "./pages/new-booking/new-booking.component";
import {RoomsComponent} from "./pages/room/room.component";
import {ProvaComponent} from "./pages/prova/prova.component";
import {UtentiComponent} from "./pages/utenti/utenti.component";
import {LoggoogleComponent} from "./pages/loggoogle/loggoogle.component";
import {HomeComponent} from "./pages/home/home.component";
// @ts-ignore
import {RatingModule}  from "ng-starrating";
import {SearchComponent} from "./search/search.component";

@NgModule({
    bootstrap: [AppComponent],
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
        RoomsComponent,
        NewBookingComponent,
        ProvaComponent,
        UtentiComponent,
        LoggoogleComponent,
        HomeComponent,
        LoggoogleComponent,
        SearchComponent,



    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        CoreModule,
        HttpClientModule, //!!per collegare la parte di login al welcome


    ],
    providers: []
})
export class AppModule { }
