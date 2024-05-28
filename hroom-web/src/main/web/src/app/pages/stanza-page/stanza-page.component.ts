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
              private router: Router,
    ) {}

  ngOnInit(): void {
    this.activetedRoute.params.subscribe((params)=>{
      if(params['id'])
        this.insertion = this.svc.findInsertion(params['id']).
        subscribe((data: any) => {
          this.insertion = data;
          data.photoIds.forEach(id => {
            this.photos.push(this.photoURL+id);
          })
          data.features.forEach((tag: Tag) => {
            this.tags.push(tag.toString());
          })
        })
      this.svcFB.fetchFeedbackOfInsertion(params['id']).subscribe(((fbs: any) => {
        fbs.forEach(fb => {
            this.feedbacks.push(fb);
          })
      }))
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
  feedbackText: string = '';
  rating: number | null = null;
  starsX: number[] = [1, 2, 3, 4, 5];

  onSubmit() {
    if (this.feedbackText && this.rating !== null) {
      console.log('Feedback:', this.feedbackText);
      console.log('Rating:', this.rating);
      var id = sessionStorage.getItem('id')
      if (id) {
        var fb: feedback = {
          subject: 2, tenantId: +id, landlordId: 0, timestamp: '',
          insertionId: this.insertion.id, rating: this.rating,
          description: this.feedbackText
        };

        this.svcFB.saveFeedback(fb).subscribe(res => {
          console.log(res);
          this.feedbacks.push(fb);
          console.log('Ok');
        })
      } else {
        console.log('No userId found')
      }
    }
  }

}
