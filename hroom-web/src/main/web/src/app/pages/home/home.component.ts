import {Component, OnInit} from '@angular/core';
import {StanzaService} from "../../service/stanza/stanza.service";
import {InsertionService} from "../../service/insertion/insertion.service";
import {stanze} from "../../shared/models/stanza";
import {ActivatedRoute, RouterLink} from '@angular/router';
import {Tag} from "../../shared/models/tags";
import {filter} from "rxjs";
import { map } from 'rxjs/operators';
import {ProjectService} from "../../service/project/project.service";
import { insertion } from '../../shared/models/insertion';
import { environment } from '../../../environment/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent implements  OnInit{
  env = environment;
  room :stanze[]=[];
  insertions: insertion[]=[];
  parcheggio: boolean =false;
  appartamento: boolean =false;
  spa: boolean =false;
  stanza: boolean =false;
  allin: boolean =false;
  centro: boolean=false;
  idro: boolean=false;

  filtering :boolean=false;
  constructor(private ss: StanzaService,
              private svc: InsertionService,
              private route:ActivatedRoute,
              private projectService: ProjectService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if(params['searchItem'])
        this.room = this.ss.getAll()
          .filter(stanza => stanza.nome.toLowerCase()
                            .includes(params['searchItem'].toLowerCase()));
      else if(params['tag'])
        this.room=this.ss.getAllRoomByTag(params['tag'])
      else {
        this.room = this.ss.getAll();
        this.svc.fetchInsertionList().subscribe(data => {
          console.log(data);
          this.insertions = data;
        });
      }
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
