import { Component } from '@angular/core';
import {feedback} from "../../shared/models/feedback";
import {FeedbackService} from "../../service/feedback/feedback.service";

@Component({
  selector: 'app-write-feedback',
  templateUrl: './write-feedback.component.html',
  styleUrl: './write-feedback.component.css'
})
export class WriteFeedbackComponent {
  /*
  feedbacks: feedback[] = [];
  newFeedback: feedback = {
    subject: 1,
    landlordId: 0,
    tenantId: 0,
    insertionId: 0,
    rating: 0,
    description: '',
    timestamp: ''
  };

  constructor(private feedbackService: FeedbackService) {

  }

  ngOnInit(): void {

  }

  loadFeedbacks(userId :number): void {
    this.feedbackService.getUserFeedbacks(userId)
      .subscribe(feedbacks => this.feedbacks );
  }

  submitFeedback(): void {
    this.feedbackService.submitFeedback(this.newFeedback)
      .subscribe(() => {
        this.newFeedback = {
          subject: 1,
          landlordId: 0,
          tenantId: 0,
          insertionId: 0,
          rating: 0,
          description: '',
          timestamp: ''
        };
       // this.loadFeedbacks();
      });
  }*/
}
