import { Component, ViewChild, ElementRef } from '@angular/core';
import { jqxRatingComponent } from 'jqwidgets-ng/jqxrating';
@Component({

  selector: 'app-write-feedback',
  templateUrl: './write-feedback.component.htm'

})
export class WriteFeedbackComponent {
  @ViewChild('rate', { static: false }) rate: ElementRef | undefined;
  change(event: any): void {
    // @ts-ignore
    let rate = this.rate.nativeElement;
    rate.innerHTML = '<span> ' + event.value + '</span>';
  }
}
