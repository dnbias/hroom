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

@NgModule({
    declarations: [
        AppComponent,
        WelcomeComponent,
        LoginComponent,
        ErrorComponent,
        StanzeComponent,
        GridStanzeComponent,
        StanzeCardComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        CoreModule
    ],
    providers: [],
    exports: [
        StanzeCardComponent
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
