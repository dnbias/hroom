import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {IStanze} from "../../models/Stanze";
import {StanzeService} from "../../../services/stanze.service";

@Component({
  selector: 'app-stanze',
  templateUrl: './stanze.component.html',
  styleUrl: './stanze.component.css'
})
export class StanzeComponent implements OnInit{

  stanze: IStanze[] = [

  ]
  constructor(private stanzeService: StanzeService) {
  }

  ngOnInit(): void {
  this.stanze=this.stanzeService.getStanze();
  }

}
