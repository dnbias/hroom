import {Component, Injectable, OnInit} from '@angular/core';
import {insertion} from "../../shared/models/insertion";
import {feedback} from "../../shared/models/feedback"
import {ActivatedRoute, Route, Router} from "@angular/router";
import {InsertionService} from "../../service/insertion/insertion.service";
import {FeedbackService} from "../../service/feedback/feedback.service";
import {Cart} from "../../shared/models/cart";
import {CartService} from "../../service/Cart/cart.service";
import { Tag } from '../../shared/models/tags';
import {UserService} from "../../service/user/user.service";


@Component({
  selector: 'app-stanza-page',
  templateUrl: './stanza-page.component.html',
  styleUrl: './stanza-page.component.css',
})

export class StanzaPageComponent implements OnInit {
  insertion!: insertion;
  feedbacks: feedback[] = [];
  tags: string[] = [];
  photoURL: string = 'api/v1/insertion/photo/';
  photos: string[] = [];
  photoLoaded: boolean = false;
  start = 'start';

  feedbackSubject: number = 1; // Default to tenant
  feedbackLandlordId: number = 0;
  feedbackTenantId: number = 0;
  feedbackInsertionId: number = 0;
  feedbackRating: number = 0; // Default rating
  feedbackDescription: string = '';
  feedbackTimestamp: string = new Date().toISOString();

  constructor(private activetedRoute: ActivatedRoute,
              private svc: InsertionService,
              private svcFB: FeedbackService,
              private svcCart: CartService,
              private router: Router,

  ) {
  }

  ngOnInit(): void {
    this.activetedRoute.params.subscribe((params) => {
      if (params['id'])
        this.insertion = this.svc.findInsertion(params['id']).subscribe((data: any) => {
          this.insertion = data;
          data.photoIds.forEach(id => {
            this.photos.push(this.photoURL + id);
          })
          data.features.forEach((tag: Tag) => {
            this.tags.push(tag.toString());
          })
          //test TODO
          var feedbacksIds = [1, 2, 3];
          feedbacksIds.forEach(fbID => {
            // data.receivedFeedbacksIds.forEach(fbID => {
            this.svcFB.findFeedback(fbID).subscribe((data: any) => {
              this.feedbacks.push(data);
            })
          })
        })
    })
  }

  addToCart() {
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

      const feedbackAdd: feedback = {
        subject: this.feedbackSubject,
        landlordId: this.feedbackLandlordId,
        tenantId: this.feedbackTenantId,
        insertionId: this.feedbackInsertionId,
        rating: this.feedbackRating,
        description: this.feedbackDescription,
        timestamp: this.feedbackTimestamp
      };





  this.svcFB.saveFeedback(feedbackAdd).subscribe(
        response => {
      console.log('Feedback saved successfully', response);
      sessionStorage.getItem("username");
          this.currentInsertionId = this.svc.findInsertion(this.insertion.id);

        },
    error => {
        console.error('Error saving feedback', error);
        });

    }

  private currentInsertionId: number = 0;
  setCurrentInsertionId(insertionIds: number): void {
    this.currentInsertionId = insertionIds;
  }

  getCurrentInsertionId(): number {
    return this.currentInsertionId;
  }
}

