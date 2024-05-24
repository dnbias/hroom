import {Component, Input, OnInit} from '@angular/core';
import {stanze} from "../../../../shared/models/stanza";
import { TagUtility } from '../../../../shared/models/tags';


@Component({
  selector: 'app-project-card',

  templateUrl: './project-card.component.html',
  styleUrl: './project-card.component.css'
})
export class ProjectCardComponent {

  @Input() stanza ={} as stanze;


  constructor(public tagUtils: TagUtility) {
  }


}
