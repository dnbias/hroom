import { Injectable } from '@angular/core';
import{stanze} from "../../app/shared/models/stanza";
import {Tag} from "../../app/shared/models/Tag";

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
      this.getAll() : this.getAll().filter(stanza=>stanza.tags?.
      includes(tag));

  }
  getAllTag():Tag[]{
    return [
      {nome: 'all', count: 10},
      {nome: 'Appartamento', count: 10},
      {nome: 'Idromassaggio', count: 2},
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
          tags: ['parigi','Idromassaggio','Appartamento'],
          imageUrl:'/assets/StanzePic/fotox.jpeg',
          roomtime: 10,
          luogo: ['Parigi'],
          nomeHost: 'Pier'
        },
        {
            id: 2 ,
            prezzo : 15,
            nome : 'Stanza suprema',
            favorite: false,
            stelle: 3.4,
            tags: ['Milano','silenziosa','Appartamento'],
            imageUrl:'/assets/StanzePic/foto2.jpeg',
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
            tags: ['Londra','goodprice','matrimoniale'],
            imageUrl:'/assets/StanzePic/foto3.jpeg',
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
            tags: ['Bologna','silenziosa','matrimoniale'],
            imageUrl:'/assets/StanzePic/foto4.jpeg',
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
            tags: ['Bergamo','relax','matrimoniale'],
            imageUrl:'/assets/StanzePic/foto5.jpeg',
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
            tags: ['Brescia','Idromassaggio','coppia'],
            imageUrl:'/assets/StanzePic/foto6.jpeg',
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
            tags: ['Catania','sole','coppia'],
            imageUrl:'/assets/StanzePic/foto7.jpeg',
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
            tags: ['Aosta','relax','singola'],
            imageUrl:'/assets/StanzePic/foto8.jpeg',
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
            tags: ['Torino','universitario','singola'],
            imageUrl:'/assets/StanzePic/foto9.jpeg',
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
            tags: ['Catania','sole','coppia'],
            imageUrl:'/assets/StanzePic/foto10.jpeg',
            roomtime: 2,
            luogo: ['Cuneo'],
            nomeHost: 'Stefano'
        }


    ];
  }


}
