import { Injectable } from "@angular/core";

export enum Tag {
  BATHROOM,
  HYDROMASSAGE,
  WHEELCHAIR_ACCESS,
  SPA,
  ALLINCLUSIVE,
  CENTER,
  APARTMENT,
  ROOM,
  PRIVATEBATHROOM,
  SEA,
  MONTAIN,
  MAISON,
  PARKING,
  AIRCONDITIONER,
  BREAKFAST,
  GYM,
  CLEAN,
  MASSAGE,
  FREEZER,
  TV,
  WC,
  MINIBAR,
  BIDET
}

@Injectable({
  providedIn: 'root'
})
export class TagUtility {
  colors: string[] = [
    '#a8e6cf',
    '#dcedc1',
    '#ffd3b6',
    '#ff8b94',
    '#e6cce6',
    '#bef5b3',
    '#a0ddff',
    '#00bfff'
  ]

  public getColor(tag: string): string {
    switch (Tag[tag]) {
      case Tag.BATHROOM: {
        return this.colors[0];
      }
      case Tag.HYDROMASSAGE: {
        return this.colors[1];
      }
      case Tag.WHEELCHAIR_ACCESS: {
        return this.colors[2];
      }
      case Tag.SPA: {
        return this.colors[3];
      }
      case Tag.ALLINCLUSIVE: {
        return this.colors[4];
      }
      case Tag.CENTER: {
        return this.colors[5];
      }
      case Tag.APARTMENT: {
        return this.colors[6];
      }
      case Tag.ROOM: {
        return this.colors[7];
      }
      case Tag.PRIVATEBATHROOM: {
        return this.colors[0];
      }
      case Tag.SEA: {
        return this.colors[1];
      }
      case Tag.MONTAIN: {
        return this.colors[2];
      }
      case Tag.MAISON: {
        return this.colors[3];
      }
      case Tag.PARKING: {
        return this.colors[4];
      }
      case Tag.AIRCONDITIONER: {
        return this.colors[5];
      }
      case Tag.BREAKFAST: {
        return this.colors[6];
      }
      case Tag.GYM: {
        return this.colors[7];
      }
      case Tag.CLEAN: {
        return this.colors[0];
      }
      case Tag.MASSAGE: {
        return this.colors[1];
      }
      case Tag.FREEZER: {
        return this.colors[2];
      }
      case Tag.TV: {
        return this.colors[3];
      }
      case Tag.WC: {
        return this.colors[4];
      }
      case Tag.MINIBAR: {
        return this.colors[5];
      }
      case Tag.BIDET: {
        return this.colors[6];
      }
      default: {
        return this.colors[7];
      }
    }
  }

  public getAllTags(): string[] {
    return Object.keys(Tag).filter((t:string)=>t.length>3); //ts weirdness with enums
  }
}
