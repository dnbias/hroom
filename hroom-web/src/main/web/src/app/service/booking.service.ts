import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Booking} from "../shared/models/booking";

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private apiUrl = 'http://localhost:8888/api/v1/reservation'; // Sostituisci con l'URL del tuo backend

  constructor(private http: HttpClient) {}

  getUserBookings(): Observable<Booking[]> {
    // Effettua una chiamata HTTP per recuperare le prenotazioni dell'utente
    return this.http.get<Booking[]>(`${this.apiUrl}/user`);
  }

}
