import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {StanzeCardComponent} from "../../components/stanze-card/stanze-card.component";
import {StanzeService} from "../../../services/stanze.service";
import {IStanze} from "../../models/Stanze";
import {stanze} from "../../shared/models/stanza";
import{StanzaService} from "../../service/stanza/stanza.service";
import {insertion} from "../../shared/models/insertion";
import {InsertionService} from "../../service/insertion/insertion.service";

@Component({
  selector: 'app-grid-stanze',
  templateUrl: './grid-stanze.component.html',
  styleUrls: ['./grid-stanze.component.css']
})
export class GridStanzeComponent implements OnInit{
    stanze$: IStanze[]=[];
    room$: stanze[]=[];
    insert$:insertion[]=[];
    in$:insertion[]=[];

  constructor(private stanzeService: StanzeService, private rs: StanzaService, private ins: InsertionService) { }

  ngOnInit(): void {

      this.stanze$=this.stanzeService.getStanze();
      console.log(this.stanze$);
      this.room$=this.rs.getAll();
      console.log(this.room$);
    }
    modifica= (codice: number)=>{
      console.log("cliccato tasto modifica del codice" + codice);
    }
    elimina=(codice:number)=>{
    console.log("cliccato tasto elimina del codice"+codice);
    this.room$.splice(this.room$.findIndex(x=>x.id==codice),1);
    console.log(this.room$);
  }

    handleEdit = (codsta: string)=>{
      console.log("Cliccato tasto modifica del codice"+ codsta);
    }
    handleDelete= (codsta: string)=> {
        console.log("Cliccato tasto elimina del codice" + codsta);
        this.stanze$.splice(this.stanze$.findIndex(x=>x.codSta==codsta),1);
        console.log(this.stanze$);
  }

  showPopup: boolean = false;

  // Metodo per aprire il popup
  openPopup() {
    this.showPopup = true;
  }

  // Metodo per chiudere il popup
  closePopup() {
    this.showPopup = false;
  }
}
