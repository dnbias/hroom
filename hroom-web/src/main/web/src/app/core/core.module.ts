import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {JumbotronComponent} from "./jumbotron/jumbotron.component";
import {RouterModule} from "@angular/router";
import {NotificationsComponent} from "./notifications/notifications.component";



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    JumbotronComponent,
    NotificationsComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    HeaderComponent,
    FooterComponent,
    JumbotronComponent
  ]
})
export class CoreModule { }
