import {Component, OnInit} from '@angular/core';
import {StanzaService} from "../../../service/stanza/stanza.service";
import {stanze} from "../../shared/models/stanza";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements  OnInit{
  room :stanze[]=[];
  constructor(private sta: StanzaService) {}

  ngOnInit(): void {
    this.room = this.sta.getAll();
  }


}
