import {Router} from "@angular/router";
import {Component, inject, OnInit} from '@angular/core';
declare var google: any;

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.css']
})

export class RegistrazioneComponent implements OnInit {

  titolo: string = "Registrazione Utente";
  sottotitolo: string = "Procedi a registrare i dati dell'utente";

  constructor() { }
  private router = inject(Router);
  ngOnInit(): void {
    google.accounts.id.initialize({
      client_id: '805273237589-dqg9c3gk6245vuk9qe62j6uoef0i4fa3.apps.googleusercontent.com',
      callback: (resp: any )=>this.handleLogin(resp)


    });
    google.accounts.id.renderButton(document.getElementById("google-btn"),{
      theme: 'filled-blue',
      size:'large',
      shape:'rectangle',
      width: 350,

    })

  }
  private decodeToken(token: string){
    return JSON.parse(atob(token.split(".")[1]));
  }
  handleLogin(response: any){
    if(response){
      //decode the token
      const payload = this.decodeToken((response.credential))
      //store in session
      sessionStorage.setItem("loggedInUser",JSON.stringify(payload));
      //navigate to home
      this.router.navigate(['home'])

    }
  }



}
