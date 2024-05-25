import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation} from "../shared/models/reservation";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private apiEndPoint: string = 'http://localhost:8888/api/v1/reservation';

  constructor(private http: HttpClient) { }

  saveReservation(reservation: Reservation):any {
    return this.http.post(this.apiEndPoint, reservation);
  }

  fetchReservationList(){
    return this.http.get(this.apiEndPoint);
  }

  findReservationById(id: number){
    return this.http.get(`${this.apiEndPoint}/${id}`);
  }

  updateReservation(reservation: Reservation, id: number){
    return this.http.put(`${this.apiEndPoint}/${id}`, reservation);
  }

  deleteReservationById(id: number){
    return this.http.delete(`${this.apiEndPoint}/${id}`, { responseType: 'text' });
  }
}
