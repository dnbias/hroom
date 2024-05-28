import {Component, OnInit} from '@angular/core';
import {Cart} from "../../shared/models/cart";
import {CartService} from "../../service/Cart/cart.service";
import {CartItem} from "../../shared/models/cartItem";

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrl: './cart-page.component.css'
})
export class CartPageComponent implements OnInit{
  cart!:Cart;
  photoURL: string = 'http://localhost:8888/api/v1/insertion/photo/';

  constructor(private cartService: CartService) {

    this.setCart();
  }
  ngOnInit(): void {
  }

  setCart(){
    this.cart= this.cartService.getCart();
  }

  removeFromCart(cartItem : CartItem){
    this.cartService.removeFromCart(cartItem.insertion.id);
    this.setCart();
  }
  changeHour(cartItem: CartItem, hourInString: string){
    const hourRoom= parseInt(hourInString);
    this.cartService.changeHour(cartItem.insertion.id,hourRoom);
    this.setCart();
  }



}
