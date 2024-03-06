import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {IStanze} from "../models/Stanze";

@Component({
  selector: 'app-stanze',
  templateUrl: './stanze.component.html',
  styleUrl: './stanze.component.css'
})
export class StanzeComponent implements OnInit{

  stanze: IStanze[] = [
    {codSta: '1234', descrizione: ' 20 metri quadri con finestra', prezzo: 20, citta: 'Milano', valutazione: 5, active :true, data: new Date()},
    {codSta: '0321', descrizione:'25 metri quadri con idromassaggio', prezzo: 40, citta: 'Palermo', valutazione:4,active : true, data: new Date()}

  ]
  constructor() {
  }

  ngOnInit(): void {
  }

}
