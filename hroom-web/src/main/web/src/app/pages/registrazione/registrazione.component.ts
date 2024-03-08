import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.css']
})
export class RegistrazioneComponent implements OnInit {

  titolo: string = "Registrazione Utente";
  sottotitolo: string = "Procedi a registrare i dati dell'utente";

  constructor() { }

  ngOnInit(): void {
  }

}
