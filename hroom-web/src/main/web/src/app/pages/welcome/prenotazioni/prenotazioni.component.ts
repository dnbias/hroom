import {Component, OnInit} from '@angular/core';

import {stanze} from "../../../shared/models/stanza";
import {ProjectService} from "../../../service/project/project.service";

@Component({
  selector: 'app-prenotazioni',

  templateUrl: './prenotazioni.component.html',
  styleUrl: './prenotazioni.component.css'
})
export class PrenotazioniComponent implements OnInit{

  featuredProject={} as stanze;
  constructor(private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.featuredProject= this.projectService.GetProjectById(1);

  }


}
