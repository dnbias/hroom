import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStanze} from "../../models/Stanze";
import {stanze} from "../../shared/models/stanza";
import {Tag} from "../../shared/models/tags";
import {insertion} from "../../shared/models/insertion";
import {environment} from "../../../environment/environment";
import {StanzaService} from "../../service/stanza/stanza.service";
import {InsertionService} from "../../service/insertion/insertion.service";
import {ActivatedRoute} from "@angular/router";
import {ProjectService} from "../../service/project/project.service";
import {LoadingService} from "../../service/loading/loading.service";
import {DomSanitizer} from "@angular/platform-browser";
import {insertionWithPhoto} from "../../shared/models/insertionWithPhoto";


@Component({
  selector: 'app-stanze-card',
  templateUrl: './stanze-card.component.html',
  styleUrls: ['./stanze-card.component.css']
})
export class StanzeCardComponent implements OnInit {
  env = environment;
  room: stanze[] = [];
  insertions: insertion[] = [];
  insertionsWithPhoto: { insertion: any, photo: any, loaded: boolean }[] = [];
  photos: any[] = [];
  photoURLs: any[] = [];
  parcheggio: boolean = false;
  appartamento: boolean = false;
  spa: boolean = false;
  stanza: boolean = false;
  allin: boolean = false;
  centro: boolean = false;
  idro: boolean = false;


  insertionList: any[] = [];
  insertionData: insertion = {
    "insertion_type": 'room',
    "id": 1,
    "landlordId": 1,
    "name": '',
    "features": [],
    "description": [''],
    "price": 0,
    "city": '',
    "address": '',
    "area": 0,
    "photoIds": [],
    "rating": 0,
    "receivedFeedbacksIds": [],
    "availabilityId": 0,
  };

  filtering: boolean = false;

  constructor(private ss: StanzaService,
              private svc: InsertionService,
              private route: ActivatedRoute,
              private projectService: ProjectService,
              private loadingService: LoadingService,
              private domSanitizer: DomSanitizer) {
  }

  ngOnInit(): void {
    this.loadingService.loadingOn();
    this.route.params.subscribe(params => {
      if (params['searchItem'])
        this.room = this.ss.getAll()
          .filter(stanza => stanza.nome.toLowerCase()
            .includes(params['searchItem'].toLowerCase()));
      else if (params['tag'])
        this.room = this.ss.getAllRoomByTag(params['tag'])
      else {
        this.svc.fetchInsertionList().subscribe(data => {
          // console.log(data);
          // this.insertions = data;
          // this.insertionsWithPhoto = this.adaptInsertionsData(data);

          data.forEach((ins, index) => {
            var id = ins.photoIds[0];
            var photoURL = 'http://localhost:8888/api/v1/insertion/photo/' + id;
            this.insertionsWithPhoto.push({insertion: ins, photo: photoURL, loaded: false});
          });
        });
        this.loadingService.loadingOff();
      }
    })
  }

  getPhoto(insId: number): any {
    this.svc.downloadPhoto(insId).subscribe(data => {
      return data;
    });
  }

  adaptInsertionsData(data: any): insertionWithPhoto[] {
    var newInsertions: insertionWithPhoto[] = [];
    var i = 0;
    data.forEach((ins: insertion) => {
      newInsertions.push(new insertionWithPhoto());
      newInsertions[i].insertion_type = ins.insertion_type;
      newInsertions[i].id = ins.id;
      newInsertions[i].landlordId = ins.landlordId;
      newInsertions[i].name = ins.name;
      newInsertions[i].tags = ins.features;
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
    var newInsertions: insertionWithPhoto[] = [];
    var i = 0;
    this.insertions.forEach(ins => {
      newInsertions[i].insertion_type = ins.insertion_type;
      newInsertions[i].id = ins.id;
      newInsertions[i].landlordId = ins.landlordId;
      newInsertions[i].name = ins.name;
      newInsertions[i].tags = ins.features;
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





  cached(id): boolean {
    return false;
  }
}
