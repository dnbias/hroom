import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {StanzeCardComponent} from "../../components/stanze-card/stanze-card.component";
import {StanzeService} from "../../../services/stanze.service";
import {IStanze} from "../../models/Stanze";


@Component({
  selector: 'app-grid-stanze',
  templateUrl: './grid-stanze.component.html',
  styleUrls: ['./grid-stanze.component.css']
})
export class GridStanzeComponent implements OnInit{
    stanze$: IStanze[]=[];


  constructor(private stanzeService: StanzeService) { }

  ngOnInit(): void {
      this.stanze$=this.stanzeService.getStanze();
      console.log(this.stanze$);
    }
    handleEdit = (codsta: string)=>{
      console.log("Cliccato tasto modifica del codice"+ codsta);
    }
    handleDelete= (codsta: string)=> {
        console.log("Cliccato tasto elimina del codice" + codsta);
        this.stanze$.splice(this.stanze$.findIndex(x=>x.codSta==codsta),1);
        console.log(this.stanze$);
  }

}
