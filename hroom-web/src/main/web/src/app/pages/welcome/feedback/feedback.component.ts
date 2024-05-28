import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {feedback} from "../../../shared/models/feedback";
import {FeedbackService} from "../../../service/feedback/feedback.service";

@Component({
  selector: 'app-feedback',

  templateUrl: './feedback.component.html',
  styleUrl: './feedback.component.css'
})
export class FeedbackComponent {


  feedbacks: feedback[] = [];

  constructor(private feedbackService: FeedbackService) {}

  ngOnInit(): void {
    //this.loadFeedbacks();
  }
/*
  loadFeedbacks(): void {
    const userId = 123;
    this.feedbackService.getUserFeedbacks(userId)
      .subscribe((feedbacks: feedback[]) => {
        this.feedbacks = feedbacks;
      });
  }*/
}
