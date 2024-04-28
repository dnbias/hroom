import {Component, OnInit} from '@angular/core';
import {stanze} from "../../shared/models/stanza";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {StanzaService} from "../../../service/stanza/stanza.service";
import {Cart} from "../../shared/models/Cart";
import {CartService} from "../../../service/cart/cart.service";


@Component({
  selector: 'app-stanza-page',
  templateUrl: './stanza-page.component.html',
  styleUrl: './stanza-page.component.css'
})
export class StanzaPageComponent implements OnInit{
  stanza!:stanze;
  constructor(private activetedRoute : ActivatedRoute,
              private stanzaService : StanzaService,
              private cartService:CartService,private router: Router) {
    activetedRoute.params.subscribe((params)=>{
      if(params['id'])
        this.stanza = stanzaService.getStanzaById(params['id'])
    })
  }
  ngOnInit(): void {
  }
  addToCart(){
    this.cartService.addToCart(this.stanza);
    this.router.navigateByUrl('/cart-page')
  }
}
