import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import {SalutiDataService} from "../../../services/data/saluti-data.service";

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  utente : string = "";
  titolo : string="Benvenuto in HRoom ";
  sottotitolo : string ="Goditi  il tuo divertimento ad ore ";

  constructor(private route : ActivatedRoute, private salutiSrv : SalutiDataService) {}

  ngOnInit(): void {

    this.utente = this.route.snapshot.params['userid'];

  }
  saluti : string = "";
  errore : string = "";

  getSaluti = () : void => {
    this.salutiSrv.getSaluti(this.utente).subscribe({
      next: this.handleResponse.bind(this),
      error: this.handleError.bind(this)
    });
  }

  handleResponse(response: Object) {
    this.saluti = response.toString();
  }

  handleError(error: any) {
    this.errore = error.error.message;
  }


}
