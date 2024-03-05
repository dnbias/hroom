import { Component, OnInit } from '@angular/core';
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userId: string = "enrico";
  password: string = "";

  autenticato: boolean = true;


  errMsg: string = "Spiacente, la userid e/o la password sono errati!";


  constructor(private route: Router) { }

  ngOnInit(): void {
  }

  gestAuth = (): void => {
    console.log(this.userId);

    if (this.userId === "enrico" && this.password === "123") {
      this.route.navigate(['welcome',this.userId]); //indirizzamento alla pagina quando il login è ok
      this.autenticato = true;

    }
    else {
      this.autenticato = false;

    }
  }
}
