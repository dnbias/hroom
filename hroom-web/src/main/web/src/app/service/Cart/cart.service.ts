import { Injectable } from '@angular/core';
import {Cart} from "../../shared/models/cart";
import {CartItem} from "../../shared/models/cartItem";
import { insertion } from '../../shared/models/insertion';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cart: Cart = new Cart();
  addToCart(insertion:insertion) : void{
    let cartItem = this.cart.items.find(item =>item.insertion.id==insertion.id)
    if(cartItem){
      this.changeHour(insertion.id, cartItem.numeroOre +1)
      return;
    }
    this.cart.items.push(new CartItem(insertion));
  }
  removeFromCart(stanzaId : number):void{
    this.cart.items=this.cart.items.filter(item =>item.insertion.id != stanzaId);

  }

  changeHour(numeroOre: number, stanzaId: number) {
    let cartItem = this.cart.items.find(item => item.insertion.id == stanzaId);
    if(!cartItem) return;
    cartItem.numeroOre = numeroOre;
  }
  getCart():Cart{
    return this.cart;
  }
}
