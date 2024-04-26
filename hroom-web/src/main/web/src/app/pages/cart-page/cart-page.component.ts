import {Component, OnInit} from '@angular/core';
import {Cart} from "../../shared/models/Cart";
import {CartService} from "../../../service/cart/cart.service";
import {CartItem} from "../../shared/models/cartItem";
import {StanzaService} from "../../../service/stanza/stanza.service";

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrl: './cart-page.component.css'
})
export class CartPageComponent implements OnInit{
  cart!:Cart;
  constructor(private cartService: CartService) {

    this.setCart();
  }
  ngOnInit(): void {
  }

   setCart(){
     this.cart= this.cartService.getCart();
    }

    removeFromCart(cartItem : CartItem){
      this.cartService.removeFromCart(cartItem.stanza.id);
      this.setCart();
    }
    changeHour(cartItem: CartItem, hourInString: string){
      const hourRoom= parseInt(hourInString);
      this.cartService.changeHour(cartItem.stanza.id,hourRoom);
      this.setCart();
    }



}
