import {Component, OnInit} from '@angular/core';
import {StanzaService} from "../../../service/stanza/stanza.service";
import {stanze} from "../../shared/models/stanza";
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements  OnInit{
  room :stanze[]=[];
  constructor(private ss: StanzaService, private route:ActivatedRoute) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if(params['searchItem'])
           this.room = this.ss.getAll().filter(stanza => stanza.nome.toLowerCase().includes(params['searchItem'].toLowerCase()));
      else if(params['tag'])
        this.room=this.ss.getAllRoomByTag(params['tag'])
      else
          this.room = this.ss.getAll();

    })

  }


}
