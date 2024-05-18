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
import { insertionWithPhoto } from '../../shared/models/insertionWithPhoto';
import { environment } from '../../../environment/environment';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent implements  OnInit{
  env = environment;
  room :stanze[]=[];
  insertions: insertion[]=[];
  insertionsWithPhoto: { insertion: any, photo: any }[] = [];
  photos: any[]=[];
  photoURLs: any[]=[];
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
              private projectService: ProjectService,
              private domSanitizer: DomSanitizer) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if(params['searchItem'])
        this.room = this.ss.getAll()
          .filter(stanza => stanza.nome.toLowerCase()
                            .includes(params['searchItem'].toLowerCase()));
      else if(params['tag'])
        this.room=this.ss.getAllRoomByTag(params['tag'])
      else {
        this.svc.fetchInsertionList().subscribe(data => {
          // console.log(data);
          // this.insertions = data;
          // this.insertionsWithPhoto = this.adaptInsertionsData(data);

          console.log('downloading photos');
          data.forEach((ins, index) => {
            var id = ins.photoIds[0];
            var photoURL = 'http://localhost:8888/api/v1/insertion/photo/'+id;

            this.insertionsWithPhoto.push({insertion: ins, photo: photoURL});
            // this.svc.downloadPhoto(id).subscribe((pdata) => {
            //   // this.photos[ins.id] = pdata;
            //   // this.photoURLs[ins.id] = URL.createObjectURL(pdata);
            //   // console.log(this.photoURLs[ins.id]);
            //   // this.insertionsWithPhoto[ins.id].photo = pdata;
            //   // var image = this.domSanitizer.bypassSecurityTrustHtml(pdata);
            //   console.log(pdata);
            // }, (err) => {
            //   console.log(err);
            // });
          });
        });
      }
    })
  }

  getPhoto(insId: number): any {
    this.svc.downloadPhoto(insId).subscribe(data => {
      return data;
    });
  }

  adaptInsertionsData(data: any): insertionWithPhoto[] {
    var newInsertions: insertionWithPhoto[]=[];
    var i = 0;
    data.forEach((ins: insertion) => {
      newInsertions.push(new insertionWithPhoto());
      newInsertions[i].insertion_type = ins.insertion_type;
      newInsertions[i].id = ins.id;
      newInsertions[i].landlordId = ins.landlordId;
      newInsertions[i].name = ins.name;
      newInsertions[i].tags = ins.tags;
      newInsertions[i].description = ins.description;
      newInsertions[i].price = ins.price;
      newInsertions[i].city = ins.city;
      newInsertions[i].address = ins.address;
      newInsertions[i].area = ins.area;
      newInsertions[i].photoIds = ins.photoIds;
      newInsertions[i].rating = ins.rating;
      newInsertions[i].receivedFeedbacksIds = ins.receivedFeedbacksIds;
      newInsertions[i].availabilityId = ins.availabilityId;

      // newInsertions[i].photo = this.photos[ins.id];
      i++;
    });
    return newInsertions;
  }

  adaptInsertions(): insertionWithPhoto[] {
    var newInsertions: insertionWithPhoto[]=[];
    var i = 0;
    this.insertions.forEach(ins => {
      newInsertions[i].insertion_type = ins.insertion_type;
      newInsertions[i].id = ins.id;
      newInsertions[i].landlordId = ins.landlordId;
      newInsertions[i].name = ins.name;
      newInsertions[i].tags = ins.tags;
      newInsertions[i].description = ins.description;
      newInsertions[i].price = ins.price;
      newInsertions[i].city = ins.city;
      newInsertions[i].address = ins.address;
      newInsertions[i].area = ins.area;
      newInsertions[i].photoIds = ins.photoIds;
      newInsertions[i].rating = ins.rating;
      newInsertions[i].receivedFeedbacksIds = ins.receivedFeedbacksIds;
      newInsertions[i].availabilityId = ins.availabilityId;

      // newInsertions[i].photo = this.photos[ins.id];
      i++;
    });
    return newInsertions;
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

  cached(id): boolean {
    return false;
  }

  protected readonly RouterLink = RouterLink;
}
