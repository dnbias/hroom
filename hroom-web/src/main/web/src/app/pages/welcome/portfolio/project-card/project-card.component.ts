import {Component, Input, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {StanzaService} from "../../../../service/stanza/stanza.service";
import {ActivatedRoute} from "@angular/router";
import {stanze} from "../../../../shared/models/stanza";


@Component({
  selector: 'app-project-card',

  templateUrl: './project-card.component.html',
  styleUrl: './project-card.component.css'
})
export class ProjectCardComponent {

  @Input() stanza ={} as stanze;



  constructor() {
  }



}
