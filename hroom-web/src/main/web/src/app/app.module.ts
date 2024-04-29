import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {StanzeComponent} from './pages/stanze/stanze.component';
import { BrowserModule } from '@angular/platform-browser';
import { CoreModule } from './core/core.module';
import { ErrorComponent } from './pages/error/error.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import {StanzeCardComponent} from "./components/stanze-card/stanze-card.component";
import {GridStanzeComponent} from "./pages/grid-stanze/grid-stanze.component";
import {RegistrazioneComponent} from "./pages/registrazione/registrazione.component";
import {NotificationsComponent} from "./core/notifications/notifications.component";
import {LogoutComponent} from "./pages/logout/logout.component";
import {HttpClientModule} from "@angular/common/http";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatFormField} from "@angular/material/form-field";
import {MatCard, MatCardContent, MatCardHeader} from "@angular/material/card";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {MaterialModule} from "../material.module";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";


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

    ],
  imports: [
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
    //!!per collegare la parte di login al welcome

  ],
    providers: [
    provideAnimationsAsync()
  ],
    bootstrap: [AppComponent]
})
export class AppModule { }
