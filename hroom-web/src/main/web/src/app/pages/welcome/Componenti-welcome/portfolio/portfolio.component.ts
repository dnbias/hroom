import {Component, OnInit} from '@angular/core';

import {stanze} from "../../../../shared/models/stanza";
import{Tag} from "../../../../shared/models/Tag";
import {ProjectService} from "../../../../../service/project.service";
import {Projects} from "@angular/cli/lib/config/workspace-schema";

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrl: './portfolio.component.css'
})
export class PortfolioComponent implements OnInit{

    project= {} as stanze[];
  constructor( private projectService: ProjectService) {}

    ngOnInit(): void {
      this.project=this.projectService.GetProject();
   }



}
