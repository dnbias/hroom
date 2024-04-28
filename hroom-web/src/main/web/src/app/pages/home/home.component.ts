import {Component, OnInit} from '@angular/core';
import {StanzaService} from "../../../service/stanza/stanza.service";
import {stanze} from "../../shared/models/stanza";
import {ActivatedRoute, RouterLink} from '@angular/router';
import {Tag} from "../../shared/models/Tag";
import {filter} from "rxjs";
import {ProjectService} from "../../../service/project.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements  OnInit{
  room :stanze[]=[];
  parcheggio: boolean =false;
  appartamento: boolean =false;
  spa: boolean =false;
  stanza: boolean =false;
  allin: boolean =false;
  centro: boolean=false;
  idro: boolean=false;


  filtering :boolean=false;
  constructor(private ss: StanzaService, private route:ActivatedRoute, private projectService: ProjectService) {}

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
  filter(){
    let filterTags: Tag[]=[];

    if(this.parcheggio){
      filterTags.push(Tag.PARCHEGGIO);
    }
    if(this.appartamento){
      filterTags.push(Tag.APPARTAMENTO);
    }
    if(this.stanza){
      filterTags.push(Tag.STANZA);
    }
    if(this.allin){
      filterTags.push(Tag.ALLINCLUSIVE);
    }
    if(this.spa){
      filterTags.push(Tag.SPA);
    }
    if(this.centro){
      filterTags.push(Tag.CENTRO);
    }
     if(this.idro){
      filterTags.push(Tag.IDRO);
    }
     if(this.spa || this.allin || this.stanza || this.appartamento || this.centro || this.idro || this.parcheggio){
       this.filtering=true;
     }
    this.room = this.projectService.GetRoomByFilter(filterTags);
  }
ResetFilter(){
  this.idro=false;
  this.spa=false;
  this.parcheggio=false;
  this.centro=false;
  this.allin=false;
  this.stanza=false;
  this.appartamento=false;
  this.filtering=false;
}


  protected readonly RouterLink = RouterLink;
}
