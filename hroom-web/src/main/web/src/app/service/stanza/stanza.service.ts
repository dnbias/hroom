import { Injectable } from '@angular/core';
import{stanze} from "../../shared/models/stanza";
import {Tag} from "../../shared/models/tags";

@Injectable({
  providedIn: 'root'
})
export class StanzaService {

  constructor() { }

  getStanzaById(id:number): stanze{
    return this.getAll().find(stanza=> stanza.id == id)!;
  }
  getAllRoomByTag(tag:string): stanze[] {
    return tag == "All"?
      this.getAll() : this.getAll().filter(stanza=>stanza.tags.toString()
        ?.
        includes(tag));

  }
  getAllTag():Tag[]{
    return [

      Tag.STANZA,
      Tag.IDRO,
      Tag.COLAZIONE,
      Tag.SPA,
      Tag.PARCHEGGIO,

    ]
  }
  getAll():stanze[]{
    return[
      {
        id: 1 ,
        prezzo : 10,
        nome : 'ciao',
        favorite: false,
        stelle: 4.0,
        tags: [Tag.APPARTAMENTO, Tag.IDRO,],
        imageUrl:'../../../assets/StanzePic/foto2.jpeg',
        roomtime: 10,
        luogo: ['Parigi'],
        nomeHost: 'Enrico'
      },
      {
        id: 2 ,
        prezzo : 15,
        nome : 'Stanza suprema',
        favorite: false,
        stelle: 3.4,
        tags: [Tag.STANZA, Tag.COLAZIONE],
        imageUrl:'../../../assets/StanzePic/foto2.jpeg',
        roomtime: 10,
        luogo: ['Milano'],
        nomeHost: 'Carlo'
      },
      {
        id: 3 ,
        prezzo : 10,
        nome : 'Stanza spaziosa',
        favorite: false,
        stelle: 2.0,
        tags: [Tag.STANZA,  Tag.PARCHEGGIO],
        imageUrl:'../../../assets/StanzePic/foto3.jpeg',
        roomtime: 4,
        luogo: ['Londra'],
        nomeHost: 'Sara'
      },
      {
        id: 4 ,
        prezzo : 15,
        nome : 'Stanza Confortevole',
        favorite: false,
        stelle: 3.5,
        tags: [Tag.STANZA,Tag.COLAZIONE],
        imageUrl:'../../../assets/StanzePic/foto4.jpeg',
        roomtime: 10,
        luogo: ['Bologna'],
        nomeHost: 'Giovanni'
      },
      {
        id: 5 ,
        prezzo : 10,
        nome : 'Stanza Meravigliosa',
        favorite: false,
        stelle: 4.8,
        tags: [Tag.STANZA],
        imageUrl:'../../../assets/StanzePic/foto5.jpeg',
        roomtime: 10,
        luogo: ['Bergamo'],
        nomeHost: 'Francesco'
      },
      {
        id: 6 ,
        prezzo : 15,
        nome : 'Stanza unica',
        favorite: false,
        stelle: 4.0,
        tags: [Tag.STANZA],
        imageUrl:'../../../assets/StanzePic/foto6.jpeg',
        roomtime: 12,
        luogo: ['Brescia'],
        nomeHost: 'Simone'
      },
      {
        id: 7 ,
        prezzo : 15,
        nome : 'Stanza per coppie',
        favorite: false,
        stelle: 4.0,
        tags: [Tag.STANZA],
        imageUrl:'../../../assets/StanzePic/foto7.jpeg',
        roomtime: 4,
        luogo: ['Catania'],
        nomeHost: 'Corrado'
      },
      {
        id: 8 ,
        prezzo : 20,
        nome : 'Stanza deluxe',
        favorite: true,
        stelle: 4.2,
        tags: [Tag.STANZA,Tag.IDRO],
        imageUrl:'../../../assets/StanzePic/foto8.jpeg',
        roomtime: 4,
        luogo: ['Aosta'],
        nomeHost: 'Marco'
      },
      {
        id: 9,
        prezzo : 15,
        nome : 'Stanza standard',
        favorite: false,
        stelle: 2.5,
        tags: [Tag.STANZA,Tag.SPA,Tag.ALLINCLUSIVE],
        imageUrl:'../../../assets/StanzePic/foto9.jpeg',
        roomtime: 4,
        luogo: ['Torino'],
        nomeHost: 'Giovanna'
      },
      {
        id: 10 ,
        prezzo : 15,
        nome : 'Stanza notte',
        favorite: true,
        stelle: 4.0,
        tags: [Tag.STANZA,Tag.SPA],
        imageUrl:'../../../assets/StanzePic/foto10.jpeg',
        roomtime: 2,
        luogo: ['Cuneo'],
        nomeHost: 'Stefano'
      },
      {
        id:11,
        prezzo: 10,
        nome:'Colazione',
        favorite:false,
        stelle: 5.0,
        tags:[Tag.COLAZIONE,Tag.PARCHEGGIO],
        imageUrl:"../../../assets/StanzePic/fotox.jpeg",
        roomtime:1,
        luogo:['Plus'],
        nomeHost:'colazione'
      }


    ];
  }


}
