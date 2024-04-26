import {stanze} from "./stanza";

export class CartItem{
  constructor(stanza: stanze) {
    this.stanza = stanza;


  }
   stanza: stanze;
   numeroOre:number =1;

  get prezzo():number{
    return this.stanza.prezzo * this.numeroOre;

  }
}
