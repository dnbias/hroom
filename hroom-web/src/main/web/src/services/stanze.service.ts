import { Injectable } from '@angular/core';
import {IStanze} from "../app/models/Stanze";

@Injectable({
  providedIn: 'root'
})
export class StanzeService {

  stanze: IStanze[] = [
    {codSta: '1234', descrizione: ' 20 metri quadri con finestra',categoria:'Singola' ,prezzo: 20, citta: 'Milano', valutazione: 4, active :true, data: new Date(),imageUrl:'/assets/images/stanze/2.jpg'},
    {codSta: '0321', descrizione:' 25 metri quadri con idromassaggio', categoria:'Singola', prezzo: 50, citta: 'Napoli', valutazione:5,active : true, data: new Date(),imageUrl:'assets/images/stanze/3.jpeg'},
    {codSta: '1211', descrizione: '20 metri quadri con bellissimo letto',categoria:'Singola', prezzo: 40, citta: 'Palermo', valutazione:5,active : true, data: new Date(),imageUrl:'assets/images/stanze/1.jpg'}

  ]
  constructor() { }

  getStanze =(): IStanze[]=> this.stanze;

  //getStanzeByCode = (codsta: string) : IStanze =>{

 //   const index = this.stanze.findIndex(stanze=>stanze.codSta=codsta);
  //  return  this.stanze[index];

 // }
}
