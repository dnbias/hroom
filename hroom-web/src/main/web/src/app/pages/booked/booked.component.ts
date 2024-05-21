import {Component, Input} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-booked',
  templateUrl: './booked.component.html',
  styleUrl: './booked.component.css'
})
export class BookedComponent {
  @Input() guestName: string | undefined;
  @Input() checkInDate: Date | undefined;
  @Input() checkOutDate: Date | undefined;
  @Input() roomType: string | undefined;
  @Input() price: number | undefined;
}
