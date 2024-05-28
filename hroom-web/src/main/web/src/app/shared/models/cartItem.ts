import { insertion } from "./insertion";

export class CartItem{
  constructor(insertion: insertion) {
    this.insertion = insertion;


  }
   insertion: insertion;
   numeroOre:number = 1;

  get prezzo():number{
    return this.insertion.price * this.numeroOre;

  }
}
