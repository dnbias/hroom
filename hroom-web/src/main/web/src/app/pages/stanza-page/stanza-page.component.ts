import {Component, OnInit} from '@angular/core';
import {stanze} from "../../shared/models/stanza";
import {ActivatedRoute} from "@angular/router";
import {StanzaService} from "../../../service/stanza/stanza.service";


@Component({
  selector: 'app-stanza-page',
  templateUrl: './stanza-page.component.html',
  styleUrl: './stanza-page.component.css'
})
export class StanzaPageComponent implements OnInit{
  stanza!:stanze;
  constructor(private activetedRoute:ActivatedRoute,private stanzaService:StanzaService) {
    activetedRoute.params.subscribe((params)=>{
      if(params['id'])
        this.stanza = stanzaService.getStanzaById(params['id'])
    })
  }
  ngOnInit(): void {
  }

}
