import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from "../../../environment/environment";
import { feedback } from '../../shared/models/feedback';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  apiEndPoint: string;
  constructor(private http: HttpClient) {
    const proxy = environment.proxy_ip;
    this.apiEndPoint = "/api/v1/feedback"
  }

  saveFeedback(fb: feedback) {
    console.log('saveFeedback request');
    return this.http.post(this.apiEndPoint, fb);
  }

  deleteFeedback(id: number) {
    console.log('deleteFeedback request');
    return this.http.delete(this.apiEndPoint+'/'+id);
  }

  updateFeedback(id: number, fb: feedback) {
    console.log('updateFeedback request');
    return this.http.put(this.apiEndPoint+'/'+id, fb);
  }

  fetchFeedbackList() {
    console.log('fetchFeedbackList request');
    return this.http.get(this.apiEndPoint);
  }

  fetchFeedbackOfTenant(id: number) {
    console.log('fetchFeedbacksOfTenant request');
    return this.http.get(this.apiEndPoint+'/tenant/'+id);
  }

  fetchFeedbackOfInsertion(id: number) {
    console.log('fetchFeedbacksOfInsertion request');
    return this.http.get(this.apiEndPoint+'/insertion/'+id);
  }

  findFeedback(id: number) {
    console.log('findFeedback request');
    return this.http.get(this.apiEndPoint+'/'+id);
  }
  /*
  getUserFeedbacks(userId: number) {
    console.log('findFeedback request');
    return this.http.get(this.apiEndPoint+'/'+userId);
  }

  submitFeedback(feedback: feedback) {
    console.log('submitdFeedback request');
    return this.http.get(this.apiEndPoint+'/');
  }*/
}
