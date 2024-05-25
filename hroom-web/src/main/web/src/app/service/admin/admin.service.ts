import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError, Observable, pipe, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  apiEndPoint:  string;
  constructor(private http: HttpClient) {
    this.apiEndPoint = "/api/v1"
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

  banUserById(userId: number):any {
    console.log('Ban user request: id='+userId);
    return this.http.delete(this.apiEndPoint+'/ban/'+userId,
                            {responseType: 'text'});
  }

  deleteInsertionById(insId: number):any {
    console.log('Delete insertion request: id='+insId);
    return this.http.delete(this.apiEndPoint+'/delete/insertion/'+insId,
                            {responseType: 'text'});
  }

  deletePhotoById(photoId: number):any {
    console.log('Delete photo request: id='+photoId);
    return this.http.delete(this.apiEndPoint+'/delete/photo/'+photoId,
                            {responseType: 'text'});
  }


}
