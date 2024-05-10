import { Injectable } from '@angular/core';
import {Cart} from "../../shared/models/cart";
import {stanze} from "../../shared/models/stanza";
import {CartItem} from "../../shared/models/cartItem";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cart: Cart = new Cart();
  addToCart(stanza:stanze) : void{
    let cartItem = this.cart.items.find(item =>item.stanza.id==stanza.id)
    if(cartItem){
      this.changeHour(stanza.id, cartItem.numeroOre +1)
      return;
    }
    this.cart.items.push(new CartItem(stanza));
  }
  removeFromCart(stanzaId : number):void{
    this.cart.items=this.cart.items.filter(item =>item.stanza.id != stanzaId);

  }

  changeHour(numeroOre: number, stanzaId: number) {
    let cartItem = this.cart.items.find(item => item.stanza.id == stanzaId);
    if(!cartItem) return;
    cartItem.numeroOre = numeroOre;
  }
  getCart():Cart{
    return this.cart;
  }
}
