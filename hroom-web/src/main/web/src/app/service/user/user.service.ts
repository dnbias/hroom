import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError, Observable, pipe, throwError} from 'rxjs';
import { User } from '../../shared/models/user';
import {SignUpRequest} from "../../shared/models/signUpRequest";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  apiEndPoint:  string;
  constructor(private http: HttpClient) {
    this.apiEndPoint = "/api/v1"
  }

  // Metodo per salvare un nuovo utente
  saveUser(user: SignUpRequest) {
    console.log('SaveUser request');
    return this.http.post( this.apiEndPoint+'/signup',user)
    .pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError('Something bad happened; please try again later.');
  }

/*
  fetchUserList() {
    return this.http.get(this.apiEndPoint + '/signup');

  }*/
  fetchUserList(): Observable<User[]> {
    return this.http.get<User[]>(this.apiEndPoint + '/signup')
      .pipe(
        catchError(this.handleError)
      );
  }

  // Metodo per eliminare un utente tramite ID
  deleteUserById(userId: number): Observable<void> {
    console.log('delete user request: id=' + userId);
    return this.http.delete<void>(this.apiEndPoint + '/user/' + userId)
      .pipe(
        catchError(this.handleError)
      );
  }


  updateUser(user: User, userId: number):any {
    return this.http.put<User>(this.apiEndPoint+'/signup/',userId);

  }


  /*deleteUserById(userId: number) {
    console.log('delete user request: id='+userId);
    return this.http.delete(this.apiEndPoint+'/user/'+userId);
  }
*/
  banUserById(userId: number) {
    console.log('Ban user request: id='+userId);
    return this.http.delete(this.apiEndPoint+'/user/ban/'+userId);
  }


}
