import {Component, Injectable, OnInit} from '@angular/core';
import {insertion} from "../../shared/models/insertion";
import {feedback} from "../../shared/models/feedback"
import {ActivatedRoute, Route, Router} from "@angular/router";
import {InsertionService} from "../../service/insertion/insertion.service";
import {FeedbackService} from "../../service/feedback/feedback.service";
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
  feedbacks: feedback[]=[];
  tags: string[]=[];
  photoURL: string = 'api/v1/insertion/photo/';
  photos: string[]=[];
  photoLoaded: boolean=false;
  start = 'start';

  constructor(private activetedRoute : ActivatedRoute,
              private svc : InsertionService,
              private svcFB : FeedbackService,
              private svcCart: CartService,
              private router: Router) {}

  ngOnInit(): void {
    this.activetedRoute.params.subscribe((params)=>{
      if(params['id'])
        this.insertion = this.svc.findInsertion(params['id']).subscribe((data: any) => {
          this.insertion = data;
          data.photoIds.forEach(id => {
            this.photos.push(this.photoURL+id);
          })
          data.features.forEach((tag: Tag) => {
            this.tags.push(tag.toString());
          })
          //test TODO
          var feedbacksIds = [1,2,3];
          feedbacksIds.forEach(fbID => {
          // data.receivedFeedbacksIds.forEach(fbID => {
            this.svcFB.findFeedback(fbID).subscribe((data: any) => {
              this.feedbacks.push(data);
            })
          })
        })
    })
  }

  addToCart(){
    this.svcCart.addToCart(this.insertion);
    this.router.navigateByUrl('/cart-page')
  }

  get isFavorite() {
    return true;
  }

  get stars() {
    return 5;
  }
}
