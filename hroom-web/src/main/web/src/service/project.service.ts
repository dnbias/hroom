import { Injectable } from '@angular/core';
import {stanze} from "../app/shared/models/stanza";
import {Tag} from "../app/shared/models/Tag";
import {Projects} from "@angular/cli/lib/config/workspace-schema";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  roomSta: stanze[] = [
    {id:1, prezzo:10, nome: "Stanza magnifica", stelle:3.4, tags:[Tag.STANZA], nomeHost: "Enrico", imageUrl:"../../../../assets/StanzePic/foto2.jpeg", favorite: false, luogo: ["Milano"], roomtime: 10,
    },
    {id:2, prezzo:11, nome: "Stanza Bela", stelle:3.4, tags:[Tag.PARCHEGGIO], nomeHost: "Enrico", imageUrl:"../../../../assets/StanzePic/foto3.jpeg", favorite: false, luogo: ["Milano"], roomtime: 10,
    }
  ];
  constructor() { }
  GetProject(){
    return this.roomSta;
  }
  GetProjectById(id:number) : stanze{
    let project = this.roomSta.find(project => project.id === id);

  if(project === undefined){
    throw new TypeError('Non ci sono stati risultati con questo id'+id);
  }
  return project;

  }

}
