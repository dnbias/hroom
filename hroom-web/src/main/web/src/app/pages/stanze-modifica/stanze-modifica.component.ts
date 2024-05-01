import { Component } from '@angular/core';
import {StanzeService} from "../../../services/stanze.service";
import {stanze} from "../../shared/models/stanza";
//import {IStanze} from "../../Models/Stanze";


@Component({
  selector: 'app-stanze-modifica',
  templateUrl: './stanze-modifica.component.html',
  styleUrl: './stanze-modifica.component.css'
})
export class StanzeModificaComponent {
 // stanze: IStanze[] = [];
  constructor(private stanzeService: StanzeService) {
  }

  ngOnInit(): void {
   // this.stanze=this.stanzeService.getStanze();
  }
}
