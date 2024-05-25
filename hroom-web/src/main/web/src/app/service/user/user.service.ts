import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../../shared/models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiEndPoint:  string;
  constructor(private http: HttpClient) {
    this.apiEndPoint = "/api/v1"
  }

  // Metodo per salvare un nuovo utente
  saveUser(user:any[]) {
    console.log('SaveUser request');
    return this.http.post( this.apiEndPoint+'/user',user);
  }

  // Metodo per ottenere la lista degli utenti
  fetchUserList(){
    return this.http.get( this.apiEndPoint+'/user');
  }

  // Metodo per aggiornare un utente esistente
  updateUser(user: User, userId: number):any {
    return this.http.put<User>(this.apiEndPoint+'/user/',userId);

  }

  // Metodo per eliminare un utente tramite ID
  deleteUserById(userId: number) {
    console.log('delete user request: id='+userId);
    return this.http.delete(this.apiEndPoint+'/user/'+userId);
  }

  // Metodo per bannare un utente tramite ID
  banUserById(userId: number) {
    console.log('Ban user request: id='+userId);
    return this.http.delete(this.apiEndPoint+'/user/ban/'+userId);
  }
}
