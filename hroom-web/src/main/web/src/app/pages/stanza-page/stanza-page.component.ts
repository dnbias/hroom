import {Component, OnInit} from '@angular/core';
import {insertion} from "../../shared/models/insertion";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {InsertionService} from "../../service/insertion/insertion.service";
import {Cart} from "../../shared/models/cart";
import {CartService} from "../../service/Cart/cart.service";
import { Tag } from '../../shared/models/tags';


@Component({
  selector: 'app-stanza-page',
  templateUrl: './stanza-page.component.html',
  styleUrl: './stanza-page.component.css',
})

export class StanzaPageComponent implements OnInit{
  insertion!: insertion;
  photoURL: string = 'api/v1/insertion/photo/';
  photos: string[]=[];
  tags: string[]=[];

  constructor(private activetedRoute : ActivatedRoute,
              private svc : InsertionService,
              private cartService:CartService,private router: Router) {
    activetedRoute.params.subscribe((params)=>{
      if(params['id'])
        this.insertion = svc.findInsertion(params['id']).subscribe((data: any) => {
          this.insertion = data;
          console.log(data);
          data.photoIds.forEach(id => {
            this.photos.push(this.photoURL+id);
          })
          data.features.forEach((tag: Tag) => {
            this.tags.push(tag.toString());
          })

        })
    })
  }
  ngOnInit(): void {
  }

  addToCart(){
    this.cartService.addToCart(this.insertion);
    this.router.navigateByUrl('/cart-page')
  }

  get isFavorite() {
    return true;
  }

  get stars() {
    return 5;
  }
}
