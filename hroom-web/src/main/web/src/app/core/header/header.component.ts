import {Component, DoCheck, OnInit} from '@angular/core';
import {AuthappService} from "../../../services/authapp.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements  OnInit,DoCheck {
  title = "hroom";
  ismenurequired = false;

  constructor(public BasicAuth: AuthappService, private router: Router) {

  }

  ngOnInit(): void {
  }

  ngDoCheck(): void {
    let currenturl = this.router.url;
    if (currenturl == '/login' || currenturl == '/register') {
      this.ismenurequired = false;
    } else {
      this.ismenurequired = true;
    }

  }

}
