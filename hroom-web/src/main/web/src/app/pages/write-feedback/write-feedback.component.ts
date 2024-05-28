import { Component } from '@angular/core';

@Component({
  selector: 'app-write-feedback',

  templateUrl: './write-feedback.component.html',
  styleUrl: './write-feedback.component.css'
})
export class WriteFeedbackComponent {
  feedbackText: string = '';
  rating: number | null = null;
  stars: number[] = [1, 2, 3, 4, 5];

  onSubmit() {
    if (this.feedbackText && this.rating !== null) {
      console.log('Feedback:', this.feedbackText);
      console.log('Rating:', this.rating);

    }
  }
}
