import {Component, OnInit} from '@angular/core';

import {stanze} from "../../../shared/models/stanza";
import {ProjectService} from "../../../service/project/project.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Booking} from "../../../shared/models/booking";
import {BookingService} from "../../../service/booking.service";

@Component({
  selector: 'app-prenotazioni',

  templateUrl: './prenotazioni.component.html',
  styleUrl: './prenotazioni.component.css'
})
export class PrenotazioniComponent {
  bookings: Booking[] = [];

  constructor(private bookingService: BookingService) {}

  ngOnInit(): void {
    this.loadUserBookings();
  }

  loadUserBookings(): void {
    this.bookingService.getUserBookings()
      .subscribe(bookings => this.bookings = bookings);
  }
}
